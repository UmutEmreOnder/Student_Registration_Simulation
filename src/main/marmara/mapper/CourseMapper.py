from src.main.marmara.dto import CourseGetDTo
from src.main.marmara.model import Course

class CourseMapper:
    def map_to(self, course_get_dto: CourseGetDTo) -> Course:
        course = Course()
        # map properties of course_get_dto to course
        return course
