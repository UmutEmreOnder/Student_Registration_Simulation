from ctypes import Union

from src.main.marmara.dto.InstructorGetDTo import InstructorGetDTO
from src.main.marmara.model import Advisor, Instructor, Schedule
from src.main.marmara.repository.impl import CourseRepositoryImpl


class InstructorMapperImpl:
    course_repository = CourseRepositoryImpl()

    def map_to(self, instructor_get_dto: InstructorGetDTO) -> Union[Instructor, Advisor]:
        if instructor_get_dto.advisor:
            return self._map_to_advisor(instructor_get_dto)

        instructor = Instructor()
        instructor.uuid = instructor_get_dto.uuid
        instructor.name = instructor_get_dto.name
        instructor.surname = instructor_get_dto.surname
        instructor.email = instructor_get_dto.email
        instructor.birth_date = instructor_get_dto.birth_date
        instructor.presented_courses = []
        instructor.weekly_schedule = Schedule()
        instructor.weekly_schedule.courses = []

        for course_code in instructor_get_dto.presented_courses:
            course = self.course_repository.find_by_course_code(course_code)
            if course:
                instructor.add_presented_course(course)
                course.instructor = instructor
                instructor.add_course_to_schedule(course)

        return instructor

    def _map_to_advisor(self, instructor_get_dto: InstructorGetDTO) -> Advisor:
        advisor = Advisor()
        advisor.uuid = instructor_get_dto.uuid
        advisor.name = instructor_get_dto.name
        advisor.surname = instructor_get_dto.surname
        advisor.email = instructor_get_dto.email
        advisor.birth_date = instructor_get_dto.birth_date
        advisor.presented_courses = []
        advisor.students = []
        advisor.weekly_schedule = Schedule()
        advisor.weekly_schedule.courses = []

        for course_code in instructor_get_dto.presented_courses:
            course = self.course_repository.find_by_course_code(course_code)
            if course:
                advisor.add_presented_course(course)
                course.instructor = advisor
                advisor.add_course_to_schedule(course)

        return advisor
