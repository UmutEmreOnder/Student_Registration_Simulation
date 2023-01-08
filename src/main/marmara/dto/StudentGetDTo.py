
from datetime import datetime
from uuid import UUID

class StudentGetDTO:
    def __init__(self, uuid=None, name=None, surname=None, email=None, birth_date=None, student_id=None, year_enrolled=None, advisor=None, semester=None):
        self.uuid = uuid
        self.name = name
        self.surname = surname
        self.email = email
        self.birth_date = birth_date
        self.student_id = student_id
        self.year_enrolled = year_enrolled
        self.advisor = advisor
        self.semester = semester

    def __str__(self):
        return (f"StudentGetDTO{{uuid={self.uuid}, name='{self.name}', surname='{self.surname}', "
                f"email='{self.email}', birth_date={self.birth_date}, student_id={self.student_id}, "
                f"year_enrolled={self.year_enrolled}, advisor='{self.advisor}', semester={self.semester}}}")

    @property
    def uuid(self):
        return self._uuid

    @uuid.setter
    def uuid(self, value):
        if isinstance(value, UUID):
            self._uuid = value
        elif isinstance(value, str):
            self._uuid = UUID(value)
        else:
            self._uuid = value

    @property
    def birth_date(self):
        return self._birth_date

    @birth_date.setter
    def birth_date(self, value):
        if isinstance(value, datetime):
            self._birth_date = value
        elif isinstance(value, str):
            self._birth_date = datetime.fromisoformat(value)
        else:
            self._birth_date = value