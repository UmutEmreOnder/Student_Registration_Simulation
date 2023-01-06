from src.main.marmara.model.School import School


class CourseRepositoryImpl:
    def save(self, course):
        school = School.get_instance()
        if school.courses is None:
            school.courses = []
        school.add_course(course)

    def find_by_course_code(self, course_code):
        school = School.get_instance()
        if school.courses is None:
            return None
        for course in school.courses:
            if course.course_code == course_code:
                return course
        return None
