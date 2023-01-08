import uuid
from datetime import date

class Person:
    def __init__(self, uuid: uuid.UUID, name: str, surname: str, email: str, birth_date: date):
        self.uuid = uuid
        self.name = name
        self.surname = surname
        self.email = email
        self.birth_date = birth_date

    def __str__(self) -> str:
        return f"Person{{uuid={self.uuid}, name='{self.name}', surname='{self.surname}', email='{self.email}', birth_date={self.birth_date}"

    def add_course_to_schedule(self, course):
        raise NotImplementedError