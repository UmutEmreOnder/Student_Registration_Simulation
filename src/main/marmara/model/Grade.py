from enum import Enum

class Grade(Enum):
    AA = 4.0
    BA = 3.5
    BB = 3.0
    CB = 2.5
    CC = 2.0
    DC = 1.5
    DD = 1.0
    FD = 0.5
    FF = 0.0

    @classmethod
    def value_of_grade(cls, point):
        for grade in cls:
            if grade.value == point:
                return grade.name
        return None
