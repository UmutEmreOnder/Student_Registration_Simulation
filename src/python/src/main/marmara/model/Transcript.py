from typing import List

from src.main.marmara.model.Course import Course


class Transcript:
    def __init__(self, gpa: float, passed_credit: int, failed_credit: int, passed_courses: Dict[Course, float], failed_courses: List[Course],
                 not_taken_courses: List[Course], currently_taken_courses: List[Course]):
        self.gpa = gpa
        self.passed_credit = passed_credit
        self.failed_credit = failed_credit
        self.passed_courses = passed_courses
        self.failed_courses = failed_courses
        self.not_taken_courses = not_taken_courses
        self.currently_taken_courses = currently_taken_courses

    def add_currently_taken_course(self, course: Course):
        self.currently_taken_courses.add(course)

    def add_failed_course(self, course: Course):
        self.failed_courses.add(course)

    def add_not_taken_course(self, course: Course):
        self.not_taken_courses.add(course)

    def remove_failed_course(self, course: Course):
        self.failed_courses.remove(course)

    def remove_not_taken_course(self, course: Course):
        self.not_taken_courses.remove(course)

    def calculate_gpa(self) -> float:
        passed_courses = self.passed_courses
        gpa = 0

        for course, grade in passed_courses.items():
            gpa += grade * course.course_credit

        gpa = gpa / (self.passed_credit + self.failed)
