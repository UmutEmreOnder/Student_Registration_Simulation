from typing import List

from src.main.marmara.model import School, Student
from src.main.marmara.repository import StudentRepository


class StudentRepositoryImpl(StudentRepository):
    # todo: Update the corresponding json file
    # todo: Save the schedule, parse the saved schedule on re-run
    def save(self, student: Student) -> None:
        school = School.get_instance()

        if school.students is None:
            school.students = []

        school.add_student(student)

    def find_by_student_id(self, student_id: int) -> Student:
        school = School.get_instance()

        if school.students is None:
            return None

        for student in school.students:
            if student.student_id == student_id:
                return student

        return None
