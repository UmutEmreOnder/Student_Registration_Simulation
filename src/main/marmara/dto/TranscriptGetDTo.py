
class TranscriptGetDTO:
    def __init__(self, gpa=None, passed_credit=None, failed_credit=None, passed_courses=None, failed_courses=None, not_taken_courses=None, currently_taken_courses=None):
        self.gpa = gpa
        self.passed_credit = passed_credit
        self.failed_credit = failed_credit
        self.passed_courses = passed_courses or []
        self.failed_courses = failed_courses or []
        self.not_taken_courses = not_taken_courses or []
        self.currently_taken_courses = currently_taken_courses or []

    def add_currently_taken_course(self, course):
        self.currently_taken_courses.append(course)

    def add_failed_course(self, course):
        self.failed_courses.append(course)

    def add_not_taken_course(self, course):
        self.not_taken_courses.append(course)

    def add_passed_course(self, course):
        self.passed_courses.append(course)

    @property
    def gpa(self):
        return self._gpa

    @gpa.setter
    def gpa(self, value):
        self._gpa = value or 0.0

    @property
    def passed_credit(self):
        return self._passed_credit

    @passed_credit.setter
    def passed_credit(self, value):
        self._passed_credit = value or 0

    @property
    def failed_credit(self):
        return self._failed_credit

    @failed_credit.setter
    def failed_credit(self, value):
        self._failed_credit = value or 0
