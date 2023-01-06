from typing import List


class CourseGetDTO:
    def __init__(self, course_code: str, prerequisites: List[str]):
        self.course_code = course_code
        self.prerequisites = prerequisites


class Course:
    def __init__(self, course_code: str):
        self.course_code = course_code
        self.prerequisites = []

    def add_prerequisite(self, prerequisite_course: 'Course'):
        self.prerequisites.append(prerequisite_course)


class CourseRepositoryImpl:
    def __init__(self):
        self.courses = []

    def save(self, course: Course):
        self.courses.append(course)

    def find_by_course_code(self, course_code: str) -> Course:
        for course in self.courses:
            if course.course_code == course_code:
                return course
        return None


class CourseServiceImpl:
    def __init__(self):
        self.course_repository = CourseRepositoryImpl()

    def add_prerequisites(self, course_get_dtos: List[CourseGetDTO]):
        for course_get_dto in course_get_dtos:
            if course_get_dto.prerequisites:
                main_course = self.course_repository.find_by_course_code(course_get_dto.course_code)
                for course_code in course_get_dto.prerequisites:
                    prerequisite_course = self.course_repository.find_by_course_code(course_code)
                    if prerequisite_course:
                        if not main_course.prerequisites:
                            main_course.prerequisites = []
                        main_course.add_prerequisite(prerequisite_course)
