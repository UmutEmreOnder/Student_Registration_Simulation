from enum import Enum

class AddCourseReturnType(Enum):
    SlotNotEmpty = 1
    NoAvailableSeats = 2
    NotExistOnAvailableCourses = 3
    Success = 4
    WaitingScheduleReview = 5
    Locked = 6
