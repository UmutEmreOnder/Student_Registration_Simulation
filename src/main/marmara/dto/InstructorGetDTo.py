
import uuid
from datetime import datetime
from typing import List, Optional

class InstructorGetDTO:
    def __init__(self, uuid: Optional[uuid.UUID] = None, name: Optional[str] = None, surname: Optional[str] = None,
                 email: Optional[str] = None, birth_date: Optional = None,
                 presented_courses: Optional[List[str]] = None, is_advisor: Optional[bool] = None):
        self.uuid = uuid
        self.name = name
        self.surname = surname
        self.email = email
        self.birth_date = birth_date
        self.presented_courses = presented_courses
        self.is_advisor = is_advisor

    def __repr__(self):
        return (f"InstructorGetDTO(uuid={self.uuid}, name='{self.name}', surname='{self.surname}', email='{self.email}', "
                f"birth_date={self.birth_date}, presented_courses={self.presented_courses}, is_advisor={self.is_advisor})")
