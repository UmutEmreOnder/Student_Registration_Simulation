class ScheduleGetDTO:
    def __init__(self, courses=None, approved=None, send_to_review=None):
        self.courses = courses or []
        self.approved = approved
        self.send_to_review = send_to_review

    def add_course(self, course):
        self.courses.append(course)

    def __str__(self):
        return f"ScheduleGetDTO{{courses={self.courses}}}"
