from src.main.marmara.model import Instructor

class Advisor(Instructor):
    def __init__(self, students=None):
        if students is None:
            students = []
        self.students = students

    def add_student(self, student):
        self.students.append(student)

    def __str__(self):
        return "Advisor(students={})".format(self.students)

    @property
    def students(self):
        return self._students

    @students.setter
    def students(self, students):
        self._students = students
