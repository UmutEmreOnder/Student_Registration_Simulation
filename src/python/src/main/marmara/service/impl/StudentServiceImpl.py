import math

from src.main.marmara.model import AddCourseReturnType, Course, RemoveCourseReturnType, School, Student, WeeklyDate
from src.main.marmara.repository import CourseRepository
from src.main.marmara.repository.impl import CourseRepositoryImpl
from src.main.marmara.service import StudentService
from typing import List
import random

class StudentServiceImpl(StudentService):
    school = School.get_instance()
    course_repository = CourseRepositoryImpl()

    def get_available_courses(self, student: Student, is_random: bool) -> List[Course]:
        courses = []

        for course in School.courses:
            if not is_random and course.given_semester % 2 != student.semester % 2:
                continue

            if course.min_credit_req > student.transcript.passed_credit:
                continue

            if course not in student.transcript.passed_courses:
                if course.prerequisites:
                    for prerequisite_course in course.prerequisites:
                        if prerequisite_course not in student.transcript.passed_courses:
                            continue

                if student.weekly_schedule and course not in student.weekly_schedule.courses:
                    courses.append(course)
                else:
                    courses.append(course)

        return courses

    def add_course_to_schedule(self, student: Student, course_code: str, available_courses: List[Course]) -> AddCourseReturnType:
        course = CourseRepository.find_by_course_code(course_code)

        if not course:
            return AddCourseReturnType.NotExistOnAvailableCourses

        if student.weekly_schedule.approved:
            return AddCourseReturnType.Locked

        if student.weekly_schedule.send_to_review:
            return AddCourseReturnType.WaitingScheduleReview

        if course.max_seats <= course.taken_seats:
            return AddCourseReturnType.NoAvailableSeats

        if not self.is_slot_empty(student.weekly_schedule.courses, course):
            return AddCourseReturnType.SlotNotEmpty

        if course in available_courses:
            student.add_course_to_schedule(course)
            course.increase_taken_seat()
            return AddCourseReturnType.Success

        return AddCourseReturnType.NotExistOnAvailableCourses

    def remove_course_from_schedule(self, student: Student, course_code: str) -> RemoveCourseReturnType:
        course = CourseRepository.find_by_course_code(course_code)

        if student.weekly_schedule.approved:
            return RemoveCourseReturnType.Locked

        if student.weekly_schedule.send_to_review:
            return RemoveCourseReturnType.WaitingScheduleReview

        if course not in student.weekly_schedule.courses:
            return RemoveCourseReturnType.NotExistOnSchedule

        student.remove_course_from_schedule(course)
        course.decrease_taken_seat()
        return RemoveCourseReturnType.Success

    def assign_random_courses(self, student):
        list_of_courses = School.get_courses()

        pass_probability = School.get_config().get_pass_probability()
        grade_luck = School.get_config().get_grade_luck()
        grade_variance = School.get_config().get_grade_variance()

        rng = random.Random()

        for course in list_of_courses:
            if course.get_given_semester() > student.get_semester():
                student.add_not_taken_course_to_transcript(course)
                continue
            if self.get_available_courses(student, True).contains(course):
                rand = rng.random()
                if rand <= pass_probability:
                    grade = self.get_grade(grade_luck, grade_variance)
                    student.get_transcript().get_passed_courses().put(course, grade)
                    student.get_transcript().set_passed_credit(
                        student.get_transcript().get_passed_credit() + course.get_course_credit())
                else:
                    student.add_failed_courses_to_transcript(course)
                    student.get_transcript().set_failed_credit(
                        student.get_transcript().get_failed_credit() + course.get_course_credit())
            else:
                student.add_not_taken_course_to_transcript(course)

        student.calculate_GPA()

    def get_grade(self, grade_luck, grade_variance):
        f_random = random.Random()
        grade = -1
        while grade < 0 or grade > 4.00:
            grade = grade_luck * (4) + f_random.gauss(0, grade_variance)

        if grade < 0.25:
            return 0.5
        elif math.isclose(math.round(grade), grade, rel_tol=1e-9, abs_tol=1e-9):
            if math.isclose(math.round(grade) - grade, 0.25, rel_tol=1e-9, abs_tol=1e-9):
                return math.round(grade) - 0.5
            else:
                return math.round(grade)
        else:
            if math.isclose(grade - math.round(grade), 0.25, rel_tol=1e-9, abs_tol=1e-9):
                return math.round(grade) + 0.5
            else:
                return math.round(grade)

    def is_slot_empty(self, schedule, course):
        for c in schedule:
            for dt in course.get_dates():
                for dt2 in c.get_dates():
                    if dt.get_day_name() == dt2.get_day_name() and dt.get_hours() == dt2.get_hours():
                        return False
        return True
