import unittest
from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.Student import Student
from src.main.marmara.model.Transcript import Transcript
from src.main.marmara.model.Course import Course
from src.main.marmara.model.WeeklySchedule import WeeklySchedule
from src.main.marmara.repository.impl.StudentRepositoryImpl import StudentRepositoryImpl
from src.main.marmara.service.AdvisorService import AdvisorService
from src.main.marmara.service.impl.AdvisorServiceImpl import AdvisorServiceImpl

class TestAdvisorServiceImpl(unittest.TestCase):
    def setUp(self):
        self.student_repository = StudentRepositoryImpl()
        self.advisor_service = AdvisorServiceImpl()

        self.advisor = Advisor()
        self.student = Student()
        self.transcript = Transcript()
        self.course = Course()
        self.weekly_schedule = WeeklySchedule()

        self.advisor.add_student(self.student)

        self.student.set_transcript(self.transcript)
        self.student.set_weekly_schedule(self.weekly_schedule)
        self.weekly_schedule.add_course(self.course)

    def test_get_student(self):
        student = self.advisor_service.get_student(
            self.student.get_student_id(), self.advisor
        )

        self.assertEqual(student, self.student)

    def test_approve_schedule(self):
        self.advisor_service.approve_schedule(self.student)

        self.assertTrue(self.student.get_weekly_schedule().is_approved())
        self.assertFalse(self.student.get_weekly_schedule().is_send_to_review())
        self.assertNotIn(self.course, self.student.get_transcript_not_taken_courses())
        self.assertNotIn(self.course, self.student.get_transcript_failed_courses())
        self.assertIn(self.course, self.student.get_transcript_currently_taken_courses())

    def test_deny_schedule(self):
        self.advisor_service.deny_schedule(self.student)

        self.assertFalse(self.student.get_weekly_schedule().is_send_to_review())

if __name__ == '__main__':
    unittest.main()
