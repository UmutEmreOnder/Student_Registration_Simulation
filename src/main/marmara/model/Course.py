from typing import List, Union


class Course:
    def __init__(self, course_code: str, course_title: str, given_semester: int, enrolled_students: List["Student"],
                 course_credit: int, prerequisites: List["Course"], instructor: "Instructor", dates: List["WeeklyDate"],
                 max_seats: int, min_credit_req: int):
        self.course_code = course_code
        self.course_title = course_title
        self.given_semester = given_semester
        self.enrolled_students = enrolled_students
        self.course_credit = course_credit
        self.prerequisites = prerequisites
        self.instructor = instructor
        self.dates = dates
        self.max_seats = max_seats
        self.taken_seats = max_seats
        self.min_credit_req = min_credit_req

    def add_weekly_date(self, weekly_date: "WeeklyDate"):
        self.dates.append(weekly_date)

    def add_prerequisite(self, course: "Course"):
        self.prerequisites.append(course)

    def increase_taken_seat(self):
        self.taken_seats += 1

    def decrease_taken_seat(self):
        self.taken_seats -= 1

    def __str__(self):
        return f"Course{{course_code='{self.course_code}', course_title='{self.course_title}', given_semester={self.given_semester}, enrolled_students={self.enrolled_students}, " \
               f"course_credit={self.course_credit}, prerequisites={self.prerequisites}, instructor={self.instructor}, dates={self.dates} "

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
    def enrolled_students(self) -> List["Student"]:
        return self._enrolled_students

    @enrolled_students.setter
    def enrolled_students(self, enrolled_students: List["Student"]):
        self._enrolled_students = enrolled_students

    @property
    def course_credit(self) -> int:
        return self._course_credit

    @course_credit.setter
    def course_credit(self, course_credit:int):
        self._course_credit = course_credit
