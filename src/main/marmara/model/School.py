from typing import List

from src.main.marmara.config.config import Config
from src.main.marmara.model import Student
from src.main.marmara.model.Course import Course
from src.main.marmara.model.Instructor import Instructor


class School:
    _school_instance = None

    def __new__(cls):
        if School._school_instance is None:
            School._school_instance = object.__new__(cls)
            School._school_instance.instructors = []
            School._school_instance.students = []
            School._school_instance.courses = []
            School._school_instance.config = Config()
        return School._school_instance

    @classmethod
    def get_instance(cls) -> 'School':
        return cls()

    def add_course(self, course: Course):
        self.courses.append(course)

    def add_instructor(self, instructor: Instructor):
        self.instructors.append(instructor)

    def add_student(self, student: Student):
        self.students.append(student)

    @property
    def students(self) -> List[Student]:
        return self._students

    @students.setter
    def students(self, value: List[Student]):
        self._students = value

    @property
    def instructors(self) -> List[Instructor]:
        return self._instructors

    @instructors.setter
    def instructors(self, value: List[Instructor]):
        self._instructors = value

    @property
    def courses(self) -> List[Course]:
        return self._courses

    @courses.setter
    def courses(self, value: List[Course]):
        self._courses = value

    @property
    def config(self) -> Config:
        return self._config

    @config.setter
    def config(self, value: Config):
        self._config = value
