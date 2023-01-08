from src.main.marmara.dto.ScheduleGetDTo import ScheduleGetDTO
from src.main.marmara.model import Schedule
from src.main.marmara.repository.impl import CourseRepositoryImpl

class ScheduleMapperImpl:
    course_repository = CourseRepositoryImpl()

    def map_to(self, schedule_get_dto: ScheduleGetDTO) -> Schedule:
        schedule = Schedule()
        schedule.courses = []

        for course_code in schedule_get_dto.courses:
            schedule.add_course(self.course_repository.find_by_course_code(course_code))

        schedule.approved = schedule_get_dto.approved
        schedule.send_to_review = schedule_get_dto.send_to_review

        return schedule

    def map_to_dto(self, schedule: Schedule) -> ScheduleGetDTO:
        schedule_get_dto = ScheduleGetDTO()
        schedule_get_dto.courses = []

        if schedule is None or schedule.courses is None:
            return None

        for course in schedule.courses:
            schedule_get_dto.add_course(course.course_code)

        schedule_get_dto.approved = schedule.approved
        schedule_get_dto.send_to_review = schedule.send_to_review

        return schedule_get_dto