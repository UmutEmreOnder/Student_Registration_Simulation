from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.Student import Student


class AdvisorService:
    def get_student(self, student_id: int, advisor: Advisor) -> Student:
        pass

    def approve_schedule(self, student: Student) -> None:
        pass

    def deny_schedule(self, student: Student) -> None:
        pass
