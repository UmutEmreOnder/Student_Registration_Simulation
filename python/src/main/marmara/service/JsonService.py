from typing import List

from src.main.marmara.config.config import Config
from src.main.marmara.model.Course import Course
from src.main.marmara.model.Instructor import Instructor
from src.main.marmara.model.Schedule import Schedule
from src.main.marmara.model.Student import Student
from src.main.marmara.model.Transcript import Transcript


class JsonService:
    def read_student_from_json(self, json_formatted_student: str) -> Student:
        pass

    def read_instructors_from_json(self, json_formatted_instructor: str) -> List[Instructor]:
        pass

    def read_courses_from_json(self, json_formatted_course: str) -> List[Course]:
        pass

    def read_schedule_from_json(self, json_formatted_schedule: str) -> Schedule:
        pass

    def read_config_from_json(self, json_formatted_config: str) -> Config:
        pass

    def end(self):
        pass

    def read_transcript_from_json(self, json_formatted_transcript: str) -> Transcript:
        pass
