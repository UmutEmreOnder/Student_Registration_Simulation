
from typing import List

from src.main.marmara.dto.CourseGetDTo import CourseGetDTO
from src.main.marmara.dto.InstructorGetDTo import InstructorGetDTO
from src.main.marmara.dto.ScheduleGetDTo import ScheduleGetDTO
from src.main.marmara.dto.StudentGetDTo import StudentGetDTO
from src.main.marmara.dto.TranscriptGetDTo import TranscriptGetDTO
from src.main.marmara.mapper.CourseMapper import CourseMapper
from src.main.marmara.mapper.InstructorMapper import InstructorMapper
from src.main.marmara.mapper.ScheduleMapper import ScheduleMapper
from src.main.marmara.mapper.StudentMapper import StudentMapper
from src.main.marmara.mapper.TranscriptMapper import TranscriptMapper
from src.main.marmara.model.Course import Course
from src.main.marmara.model.Instructor import Instructor
from src.main.marmara.model.Schedule import Schedule
from src.main.marmara.model.School import School
from src.main.marmara.model.Student import Student
from src.main.marmara.model.Transcript import Transcript
from src.main.marmara.service import CourseService


class JsonService:
    def readStudentFromJson(self, jsonFormattedStudentList: str) -> Student:
        pass

    def readInstructorsFromJson(self, jsonFormattedInstructorList: str) -> List[Instructor]:
        pass

    def readCoursesFromJson(self, jsonFormattedCourseList: str) -> List[Course]:
        pass

    def readScheduleFromJson(self, jsonFormattedSchedule: str) -> Schedule:
        pass

    def readTranscriptFromJson(self, jsonFormattedTranscript: str) -> Transcript:
        pass

from json import loads

class JsonServiceImpl(JsonService):
    def readStudentFromJson(self, jsonFormattedStudentList: str) -> Student:
        studentGetDTO = loads(jsonFormattedStudentList, StudentGetDTO)
        return StudentMapper.mapTo(studentGetDTO)

    def readInstructorsFromJson(self, jsonFormattedInstructorList: str) -> List[Instructor]:
        instructorGetDTOList = loads(jsonFormattedInstructorList, InstructorGetDTO[self])
        return [InstructorMapper.mapTo(dto) for dto in instructorGetDTOList]

    def readCoursesFromJson(self, jsonFormattedCourseList: str) -> List[Course]:
        courseGetDTOS = loads(jsonFormattedCourseList, CourseGetDTO[self])
        coursesWithoutPrerequisites = [CourseMapper.mapTo(dto) for dto in courseGetDTOS]

        school = School.get_instance()
        school.courses = coursesWithoutPrerequisites
        CourseService.addPrerequisites(courseGetDTOS)

        return school.courses

    def readScheduleFromJson(self, jsonFormattedSchedule: str) -> Schedule:
        scheduleGetDTO = loads(jsonFormattedSchedule, ScheduleGetDTO)
        return ScheduleMapper.mapTo(scheduleGetDTO)

    def readTranscriptFromJson(self, jsonFormattedTranscript: str) -> Transcript:
        transcriptGetDTO = loads(jsonFormattedTranscript, TranscriptGetDTO)
        return TranscriptMapper.mapTo(transcriptGetDTO)
