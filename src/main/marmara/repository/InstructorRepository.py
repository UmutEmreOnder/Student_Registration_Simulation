from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.Instructor import Instructor


class InstructorRepository:
    def save(self, instructor: Instructor):
        pass

    def find_by_email(self, email: str) -> Instructor:
        pass

    def find_advisor_by_email(self, advisor: str) -> Advisor:
        pass
