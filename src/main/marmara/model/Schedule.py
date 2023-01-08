from typing import List

from src.main.marmara.model.Course import Course


class Schedule:
    def __init__(self, courses: List[Course], approved: bool, send_to_review: bool):
        self.courses = courses
        self.approved = approved
        self.send_to_review = send_to_review

    def __str__(self) -> str:
        return f"Schedule{{courses={self.courses}}}"

    def add_course(self, course: Course):
        self.courses.append(course)

    def remove_course(self, course: Course):
        self.courses.remove(course)

    @property
    def approved(self) -> bool:
        return self._approved

    @approved.setter
    def approved(self, value: bool):
        self._approved = value

    @property
    def send_to_review(self) -> bool:
        return self._send_to_review

    @send_to_review.setter
    def send_to_review(self, value: bool):
        self._send_to_review = value

    @property
    def courses(self) -> List[Course]:
        return self._courses

    @courses.setter
    def courses(self, value: List[Course]):
        self._courses = value
