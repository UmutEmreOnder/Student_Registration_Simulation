from typing import List

from src.main.marmara.model.AddCourseReturnType import AddCourseReturnType
from src.main.marmara.model.Course import Course
from src.main.marmara.model.RemoveCourseReturnType import RemoveCourseReturnType
from src.main.marmara.model.Student import Student


class StudentService:
    def get_available_courses(self, student: Student, is_random: bool) -> List[Course]:
        pass

    def add_course_to_schedule(self, student: Student, course_code: str, available_courses: List[Course]) -> AddCourseReturnType:
        pass

    def remove_course_from_schedule(self, student: Student, course_code: str) -> RemoveCourseReturnType:
        pass

    def assign_random_courses(self, student: Student):
        pass

    def send_to_review(self, schedule: Schedule):
        pass