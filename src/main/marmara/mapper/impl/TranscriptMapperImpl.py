

from src.main.marmara.dto.TranscriptGetDTo import TranscriptGetDTO
from src.main.marmara.mapper import TranscriptMapper
from src.main.marmara.model import Course, Transcript
from src.main.marmara.repository.impl import CourseRepositoryImpl


class TranscriptMapperImpl(TranscriptMapper):
    def __init__(self):
        self.course_repository = CourseRepositoryImpl()

    def map_to(self, transcript_get_dto: "TranscriptGetDTO") -> Transcript:
        transcript = Transcript()

        transcript.gpa = transcript_get_dto.gpa
        transcript.passed_credit = transcript_get_dto.passed_credit
        transcript.failed_credit = transcript_get_dto.failed_credit

        transcript.currently_taken_courses = []
        for course_code in transcript_get_dto.currently_taken_courses:
            transcript.currently_taken_courses.append(self.course_repository.find_by_course_code(course_code))

        transcript.failed_courses = []
        for course_code in transcript_get_dto.failed_courses:
            transcript.failed_courses.append(self.course_repository.find_by_course_code(course_code))

        transcript.not_taken_courses = []
        for course_code in transcript_get_dto.not_taken_courses:
            transcript.not_taken_courses.append(self.course_repository.find_by_course_code(course_code))

        transcript.passed_courses = {}
        for course_and_grade in transcript_get_dto.passed_courses:
            course_code, grade = course_and_grade.split(" ")
            transcript.passed_courses[self.course_repository.find_by_course_code(course_code)] = float(grade)

        return transcript

    def map_from(self, transcript: Transcript) -> "TranscriptGetDTO":
        transcript_get_dto = TranscriptGetDTO()

        transcript_get_dto.gpa = transcript.gpa
        transcript_get_dto.passed_credit = transcript.passed_credit
        transcript_get_dto.failed_credit = transcript.failed_credit

        transcript_get_dto.failed_courses = []
        for course in transcript.failed_courses:
            transcript_get_dto.failed_courses.append(course.course_code)

        transcript_get_dto.not_taken_courses = []
        for course in transcript.not_taken_courses:
            transcript_get_dto.not_taken_courses.append(course.course_code)

        transcript_get_dto.currently_taken_courses = []
        for course in transcript.currently_taken_courses:
            transcript_get_dto.currently_taken_courses.append(course.course_code)

        transcript_get_dto.passed_courses = []
        for course in transcript.passed_courses:
            transcript_get_dto.add_passed_course.append(course.course_code)

