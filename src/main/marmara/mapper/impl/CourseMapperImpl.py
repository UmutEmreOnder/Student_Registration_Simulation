from src.main.marmara.dto import CourseGetDTo
from src.main.marmara.mapper import CourseMapper
from src.main.marmara.model import Course, DayName, WeeklyDate

class CourseMapperImpl(CourseMapper):
    def mapTo(self, courseGetDTO: CourseGetDTo) -> Course:
        course = Course()

        course.courseCode = courseGetDTO.courseCode
        course.courseTitle = courseGetDTO.courseTitle
        course.givenSemester = courseGetDTO.givenSemester
        course.courseCredit = courseGetDTO.courseCredit

        course.dates = []

        for date in courseGetDTO.weeklyDate:
            day_and_hour = date.split(" ")

            day_name = DayName[day_and_hour[0]]
            weekly_date = WeeklyDate()
            weekly_date.dayName = day_name
            weekly_date.hours = int(day_and_hour[1])

            course.dates.append(weekly_date)

        course.maxSeats = courseGetDTO.maxSeats
        course.takenSeats = courseGetDTO.takenSeats
        course.minCreditReq = courseGetDTO.minCreditReq

        return course
