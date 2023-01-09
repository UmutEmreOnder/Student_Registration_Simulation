from typing import List


class CourseGetDTO:
    def __init__(self, course_code: str, course_title: str, given_semester: int, course_credit: int,
                 prerequisites: List[str], weekly_date: List[str], max_seats: int, taken_seats: int,
                 min_credit_req: int):
        self.course_code = course_code
        self.course_title = course_title
        self.given_semester = given_semester
        self.course_credit = course_credit
        self.prerequisites = prerequisites
        self.weekly_date = weekly_date
        self.max_seats = max_seats
        self.taken_seats = taken_seats
        self.min_credit_req = min_credit_req

    def __repr__(self):
        return (f"CourseGetDTO(course_code='{self.course_code}', course_title='{self.course_title}', "
                f"given_semester={self.given_semester}, course_credit={self.course_credit}, "
                f"prerequisites={self.prerequisites}, weekly_date={self.weekly_date})")

    @property
    def course_code(self) -> str:
        return self._course_code

    @course_code.setter
    def course_code(self, course_code: str):
        self._course_code = course_code

    @property
    def course_title(self) -> str:
        return self._course_title

    @course_title.setter
    def course_title(self, course_title: str):
        self._course_title = course_title

    @property
    def given_semester(self) -> int:
        return self._given_semester

    @given_semester.setter
    def given_semester(self, given_semester: int):
        self._given_semester = given_semester

    @property
    def course_credit(self) -> int:
        return self._course_credit

    @course_credit.setter
    def course_credit(self, course_credit: int):
        self._course_credit = course_credit

    @property
    def prerequisites(self) -> List[str]:
        return self._prerequisites

    @prerequisites.setter
    def prerequisites(self, prerequisites: List[str]):
        self._prerequisites = prerequisites

    @property
    def weekly_date(self) -> List[str]:
        return self._weekly_date

    @weekly_date.setter
    def weekly_date(self, weekly_date: List[str]):
        self._weekly_date = weekly_date

    @property
    def max_seats(self) -> int:
        return self._max_seats

    @max_seats.setter
    def max_seats(self, max_seats: int):
        self._max_seats = max
