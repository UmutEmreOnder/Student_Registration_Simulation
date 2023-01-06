
from src.main.marmara.dto.StudentGetDTo import StudentGetDTO
from src.main.marmara.model import Student
from src.main.marmara.model import Transcript
from src.main.marmara.model import Schedule
from src.main.marmara.repository.impl import InstructorRepositoryImpl
class StudentMapperImpl:
    def mapTo(self, studentGetDTO: StudentGetDTO) -> Student:
        student = Student()

        student.uuid = studentGetDTO.uuid
        student.name = studentGetDTO.name
        student.surname = studentGetDTO.surname
        student.email = studentGetDTO.email
        student.birth_date = studentGetDTO.birth_date
        student.student_id = studentGetDTO.student_id
        student.year_enrolled = studentGetDTO.year_enrolled
        student.semester = studentGetDTO.semester

        student.transcript = Transcript()
        student.transcript.passed_courses = {}
        student.transcript.failed_courses = []
        student.transcript.failed_credit = 0
        student.transcript.passed_credit = 0
        student.transcript.not_taken_courses = []
        student.transcript.currently_taken_courses = []

        student.weekly_schedule = Schedule()
        student.weekly_schedule.courses = []

        instructor_repository = InstructorRepositoryImpl()
        advisor = instructor_repository.find_advisor_by_email(studentGetDTO.advisor)
        if advisor is not None:
            student.advisor = advisor
            advisor.add_student(student)

        return student
