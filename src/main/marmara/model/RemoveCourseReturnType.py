from enum import Enum

class RemoveCourseReturnType(Enum):
    Success = 1
    WaitingScheduleReview = 2
    Locked = 3
    NotExist = 4
