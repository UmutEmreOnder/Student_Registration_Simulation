from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.School import School


class InstructorRepositoryImpl:
    def save(self, instructor):
        school = School.get_instance()
        if school.instructors is None:
            school.instructors = []
        school.add_instructor(instructor)

    def find_by_email(self, email):
        school = School.get_instance()
        if school.instructors is None:
            return None
        for instructor in school.instructors:
            if instructor.email == email:
                return instructor
        return None

    def find_advisor_by_email(self, advisor):
        school = School.get_instance()
        if school.instructors is None:
            return None
        for instructor in school.instructors:
            if instructor.email == advisor:
                if isinstance(instructor, Advisor):
                    return instructor
        return None
