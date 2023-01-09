from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.Student import Student
from src.main.marmara.repository.impl import StudentRepositoryImpl
from src.main.marmara.service import AdvisorService


class AdvisorServiceImpl(AdvisorService):
    student_repository = StudentRepositoryImpl()

    def get_student(self, student_id: int, advisor: Advisor) -> Student:
        student = self.student_repository.find_by_student_id(student_id)

        if student is None:
            return None

        if student in advisor.get_students():
            return student

        return None

    def approve_schedule(self, student: Student):
        for course in student.get_weekly_schedule().get_courses():
            student.remove_from_transcript_not_taken_course(course)
            student.remove_from_transcript_failed_course(course)
            student.add_currently_taken_course_to_transcript(course)

        student.get_weekly_schedule().set_approved(True)

    def deny_schedule(self, student: Student):
        student.get_weekly_schedule().set_send_to_review(False)
