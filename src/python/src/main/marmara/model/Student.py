from src.main.marmara.model.Person import Person


class Student(Person):
    def __init__(self, student_id, year_enrolled, weekly_schedule, transcript, advisor, semester):
        self.student_id = student_id
        self.year_enrolled = year_enrolled
        self.weekly_schedule = weekly_schedule
        self.transcript = transcript
        self.advisor = advisor
        self.semester = semester

    def add_currently_taken_course_to_transcript(self, course):
        self.transcript.add_currently_taken_course(course)

    def add_not_taken_course_to_transcript(self, course):
        self.transcript.add_not_taken_course(course)

    def add_failed_courses_to_transcript(self, course):
        self.transcript.add_failed_course(course)

    def remove_from_transcript_not_taken_course(self, course):
        self.transcript.remove_not_taken_course(course)

    def remove_from_transcript_failed_course(self, course):
        self.transcript.remove_failed_course(course)

    def add_course_to_schedule(self, course):
        self.weekly_schedule.add_course(course)

    def remove_from_schedule(self, course):
        self.weekly_schedule.remove_course(course)

    def calculate_gpa(self):
        return self.transcript.calculate_gpa()

    def __str__(self):
        return (
            f"Student(student_id={self.student_id}, "
            f"year_enrolled={self.year_enrolled}, "
            f"weekly_schedule={self.weekly_schedule}, "
            f"transcript={self.transcript}, "
            f"advisor={self.advisor}, "
            f"semester={self.semester})"
        )

    @property
    def student_id(self):
        return self.student_id

    @student_id.setter
    def student_id(self, student_id):
        self.student_id = student_id

    @property
    def year_enrolled(self):
        return self.year_enrolled

    @year_enrolled.setter
    def year_enrolled(self, year_enrolled):
        self.year_enrolled = year_enrolled

    @property
    def weekly_schedule(self):
        return self.weekly_schedule

    @weekly_schedule.setter
    def weekly_schedule(self, weekly_schedule):
        self.weekly_schedule = weekly_schedule

    @property
    def transcript(self):
        return self.transcript

    @transcript.setter
    def transcript(self, transcript):
        self.transcript = transcript

    @property
    def advisor(self):
        return self.advisor


