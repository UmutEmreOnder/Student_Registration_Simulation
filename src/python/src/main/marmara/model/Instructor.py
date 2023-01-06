from typing import List

from src.main.marmara.model import Person, Schedule
from src.main.marmara.model.Course import Course


class Instructor(Person):
    def __init__(self, presented_courses: List[Course], weekly_schedule: Schedule):
        self.presented_courses = presented_courses
        self.weekly_schedule = weekly_schedule

    def add_presented_course(self, course: Course):
        self.presented_courses.append(course)

    def add_course_to_schedule(self, course: Course):
        self.weekly_schedule.add_course(course)

    def __str__(self):
        return f"Instructor(presented_courses={self.presented_courses}, weekly_schedule={self.weekly_schedule})"

    @property
    def presented_courses(self) -> List[Course]:
        return self.presented_courses

    @presented_courses.setter
    def presented_courses(self, presented_courses: List[Course]):
        self.presented_courses = presented_courses

    @property
    def weekly_schedule(self) -> Schedule:
        return self.weekly_schedule

    @weekly_schedule.setter
    def weekly_schedule(self, weekly_schedule: Schedule):
        self.weekly_schedule = weekly_schedule
