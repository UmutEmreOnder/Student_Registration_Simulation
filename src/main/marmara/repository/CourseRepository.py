from src.main.marmara.model.Course import Course


class CourseRepository:
    def save(self, course: Course) -> None:
        pass

    def find_by_course_code(self, course_code: str) -> Course:
        pass
