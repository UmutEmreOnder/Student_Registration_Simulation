import logging
import os

import argparse
import sys
from datetime import datetime


from src.main.marmara.mapper.impl.InstructorMapperImpl import InstructorMapperImpl
from src.main.marmara.mapper.impl.StudentMapperImpl import StudentMapperImpl
from src.main.marmara.model.AddCourseReturnType import AddCourseReturnType
from src.main.marmara.model.Advisor import Advisor
from src.main.marmara.model.Grade import Grade
from src.main.marmara.model.RemoveCourseReturnType import RemoveCourseReturnType
from src.main.marmara.model.School import School
from src.main.marmara.repository.InstructorRepository import InstructorRepository
from src.main.marmara.repository.StudentRepository import StudentRepository
from src.main.marmara.repository.impl.InstructorRepositoryImpl import InstructorRepositoryImpl
from src.main.marmara.repository.impl.StudentRepositoryImpl import StudentRepositoryImpl
from src.main.marmara.service.AdvisorService import AdvisorService
from src.main.marmara.service.SchoolService import SchoolService
from src.main.marmara.service.StudentService import StudentService
from src.main.marmara.service.impl.AdvisorServiceImpl import AdvisorServiceImpl
from src.main.marmara.service.impl.SchoolServiceImpl import SchoolServiceImpl
from src.main.marmara.service.impl.StudentServiceImpl import StudentServiceImpl
from src.main.marmara.view.formatter.CustomFileFormatter import CustomFileFormatter
from src.main.marmara.view.formatter.CustomFormatter import CustomFormatter

logger = logging.getLogger(__name__)

class View:
    school = School.get_instance()
    student_service = StudentServiceImpl()
    student_repository = StudentRepositoryImpl()
    instructor_repository = InstructorRepositoryImpl()
    student_mapper = StudentMapperImpl()
    instructor_mapper = InstructorMapperImpl()
    school_service = SchoolServiceImpl()
    advisor_service = AdvisorServiceImpl()

    #JAVA CODE VIEW CLASS LINE 61
    scanner = argparse.ArgumentParser()
    scanner.add_argument('--int_value', type=int, required=True)
    args = scanner.parse_args()
    int_value = args.int_value

    @classmethod
    def __init__(cls):
        pass


def configure_logger():
    try:
        # get the current time
        date = datetime.now()

        # generate the log file name using the current time
        file_name = "log-" + str(date) + ".txt"
        os.makedirs("logs", exist_ok=True)
        # configure the logger
        handler = logging.FileHandler(f"logs/{file_name}")
        # Create a console handler that writes log messages to the console
        console_handler = logging.StreamHandler()

        # Set the formatter for both handlers to use the CustomFormatter
        handler.setFormatter(CustomFileFormatter())
        console_handler.setFormatter(CustomFormatter())
        # Add the file and console handlers to the logger
        logger.addHandler(handler)
        logger.addHandler(console_handler)

        # Set the logger to not use the parent (default) handlers
        logger.propagate = False
    except Exception as e:
        logger.log(logging.SEVERE, "an error occurred while configuring the logger", exc_info=True)

def start():
    SchoolService.upload_jsons()
    configure_logger()
    while True:
        logger.info("Select User Type: \n1- Student\n2- Instructor\n9- Exit\n")
        input = int(input())
        if input == 1:
            print_student_menu()
        elif input == 2:
            print_instructor_menu()
        elif input == 9:
            break
        else:
            logger.warning("Wrong input!\n")
def print_student_menu():
    input = 0

    logger.info("Enter your Student ID: ")
    student = StudentRepository.find_by_student_id(int(input()))
    if student is not None:
        while True:
            logger.info(f"\nWelcome {student.name} {student.surname}!\n")
            logger.info("What would you like to do?\n1-View Student Info\n2-Add/Drop Course\n3-View Schedule\n4-View Transcript\n9-Exit\n")
            input = int(input())
            if input == 1:
                print_student_info(student)
            elif input == 2:
                print_add_drop_menu(student)
            elif input == 3:
                print_schedule(student.weekly_schedule, True)
            elif input == 4:
                print_transcript(student)
            elif input == 9:
                break
            else:
                logger.warning("Wrong input!")
            if input == 9:
                break
    else:
        logger.warning("\nCannot find the student with given ID\n")

def print_instructor_menu():
    input = 0
    student_id = 0
    logger.info("Enter your Email Address: ")
    instructor = InstructorRepository.find_by_email(scanner.next())
    if instructor is not None:
        while True:
            logger.info(f"\nWelcome {instructor.name} {instructor.surname}!\n")
            if isinstance(instructor, Advisor):
                logger.info("What would you like to do?\n1-View Student Info\n2-View Student Schedule" + "\n3-View List Of Students\n4-View Instructor Info\n5-View Schedule\n9-Exit\n")
                input = scanner.next_int()
                if input == 1:
                    logger.info("Enter student ID:")
                    student_id = scanner.next_long()
                    student = AdvisorService.get_student(student_id, instructor)
                    if student is not None:
                        print_student_info(student)
                    else:
                        logger.info("The student you're trying to reach doesn't exist or you're not the advisor of him/her\n")
                elif input == 2:
                    logger.info("Enter student ID:")
                    student_id = scanner.next_long()
                    student = AdvisorService.get_student(student_id, instructor)
                    if student is not None:
                        if student.weekly_schedule.send_to_review != True:
                            logger.info("The student hasn't send his schedule to review yet!\n")
                        else:
                            print_schedule(student.weekly_schedule, False)
                            if student.weekly_schedule.approved != True:
                                logger.info("\n1- Approve\n2- Deny\n")
                                if scanner.next_int() == 1:
                                    AdvisorService.approve_schedule(student)
                                    logger.info("You've successfully approved the schedule\n")
                                else:
                                    AdvisorService.deny_schedule(student)
                                    logger.info("You've successfully denied the schedule\n")
                    else:
                        logger.info("The student you're trying to reach doesn't exist or you're not the advisor of him/her\n")
                elif input == 3:
                    for student in instructor.students:
                        logger.info(f"{student.student_id} | {student.name} {student.surname}\n")
                    logger.info("\nPress enter to go back\n")
                    from re import Scanner
                    scanner = Scanner(sys.stdin)
                    scanner.next_line()
                elif input == 4:
                    print_instructor_info(instructor)
                elif input == 5:
                    print_schedule(instructor.weekly_schedule, False)
                elif input == 9:
                    break
                else:
                    logger.warning("Wrong input!")
            else:
                logger.info("What would you like to do?\n1-View Student Info\n2-View Student Schedule" + "\n3-View List Of Students\n4-View Instructor")

def print_transcript(student):
    if student.get_transcript() is not None:
        logger.info("\n\n\n\n\n")
        passed_credit = student.get_transcript().get_passed_credit()
        failed_credit = student.get_transcript().get_failed_credit()
        gpa = student.get_transcript().get_gpa()

        logger.info(f"\nGPA = {gpa:.2f}\n")
        logger.info(f"Passed Credit = {passed_credit}\n")
        logger.info(f"Failed Credit = {failed_credit}\n")
        logger.info("\nPassed Courses\n")
        for passed_course, grade in student.get_transcript().get_passed_courses().items():
            logger.info(f"| {passed_course.get_course_code():<8} | {passed_course.get_course_title():<60} | {Grade.value_of_grade(grade)}\n")
        logger.info("\nFailed Courses\n")
        for course in student.get_transcript().get_failed_courses():
            logger.info(f"| {course.get_course_code():<8} | {course.get_course_title():<60} | FF\n")
        logger.info("\nCurrently Taken Courses\n")
        for course in student.get_transcript().get_currently_taken_courses():
            logger.info(f"| {course.get_course_code():<8} | {course.get_course_title():<60} |\n")
        logger.info("\nNot Taken Courses\n")
        for course in student.get_transcript().get_not_taken_courses():
            logger.info(f"| {course.get_course_code():<8} | {course.get_course_title():<60} |\n")
    else:
        logger.info("Transcript is empty.")

    logger.info("\nPress enter to go back")
    scanner = input()

def print_schedule(schedule, is_student):
    logger.info("\n\n\nSchedule")
    if schedule is None:
        logger.info(" is empty.")
    else:
        logger.info("\n")
        monday_courses = []
        tuesday_courses = []
        wednesday_courses = []
        thursday_courses = []
        friday_courses = []
        saturday_courses = []
        sunday_courses = []

        for course in schedule.get_courses():
            for weekly_date in course.get_dates():
                if weekly_date.get_day_name() == 'MON':
                    monday_courses.append(course)
                elif weekly_date.get_day_name() == 'TUE':
                    tuesday_courses.append(course)
                elif weekly_date.get_day_name() == 'WED':
                    wednesday_courses.append(course)
                elif weekly_date.get_day_name() == 'THU':
                    thursday_courses.append(course)
                elif weekly_date.get_day_name() == 'FRI':
                    friday_courses.append(course)
                elif weekly_date.get_day_name() == 'SAT':
                    saturday_courses.append(course)
                elif weekly_date.get_day_name() == 'SUN':
                    sunday_courses.append(course)

        print_schedule_days(monday_courses, 'MON')
        print_schedule_days(tuesday_courses, 'TUE')
        print_schedule_days(wednesday_courses, 'WED')
        print_schedule_days(thursday_courses, 'THU')
        print_schedule_days(friday_courses, 'FRI')
        print_schedule_days(saturday_courses, 'SAT')
        print_schedule_days(sunday_courses, 'SUN')

    if is_student:
        logger.info("\n\n1-Send to Review\n9-Exit\n")
        choice = int(input())

        if choice == 1:
            if schedule.get_approved() is False:
                if schedule.get_send_to_review() is True:
                    logger.warning("You've already sent your draft schedule to your advisor!\n")
                else:
                    total_credit = 0

                    for course in schedule.get_courses():
                        total_credit += course.get_course_credit()

                    if total_credit < School.get_config().get_minimum_credit_req():
                        logger.warning(f"You cannot send your schedule to review since your total credit({total_credit}) is lower than minimum credit requirement {School.get_config().get_minimum_credit_req()}\n")
                    else:
                        schedule.set_send_to_review(True)
                        logger.info("You've successfully sent your schedule to your advisor to review!\n")
            else:
                logger.warning("You can't modify your schedule since it's already has been")

def print_schedule_days(courses, day_name):
    if day_name == 'MON':
        logger.info("\nMonday")
    elif day_name == 'TUE':
        logger.info("\nTuesday")
    elif day_name == 'WED':
        logger.info("\nWednesday")
    elif day_name == 'THU':
        logger.info("\nThursday")
    elif day_name == 'FRI':
        logger.info("\nFriday")
    elif day_name == 'SAT':
        logger.info("\nSaturday")
    elif day_name == 'SUN':
        logger.info("\nSunday")

    is_empty = True
    for i in range(9, 19):
        for course in courses:
            for j in range(len(course.get_dates())):
                if course.get_dates()[j].get_day_name() == day_name and course.get_dates()[j].get_hours() == i:
                    if is_empty:
                        logger.info("\n")
                    formatted = f"\n{i:02d}"
                    formatted2 = f"\n{i+1:02d}"
                    logger.info(f"{formatted}.00 -|  {course.get_course_code()} {course.get_course_title():<60} |")
                    logger.info(f"{formatted2}.00 -|  {course.get_instructor().get_name()} {course.get_instructor().get_surname():<60} |\n")
                    if i != 18:
                        logger.info("------------------------------------------------------------------------\n")
                    is_empty = False
                    break
        if is_empty:
            logger.info(" is empty.\n")

def print_add_drop_menu(student):
  while True:
    logger.info("\nSelect the Operation:\n1- Add Course\n2- Remove Course\n9- Exit\n")
    choice = int(input())

    if choice == 1:
      add_course_menu(student)
    elif choice == 2:
      remove_course_menu(student)
    elif choice == 9:
      break
    else:
      logger.warning("\nWrong Input!\n")

def remove_course_menu(student):
    for course in student.weekly_schedule.courses:
        logger.info(f"|  {course.course_code}  | {course.course_title}\n")

    while True:
        logger.info("\nEnter the course code to remove from your schedule (Type 9 to exit): ")
        course_code = input()

        if course_code == "9":
            break

        is_removed = StudentService.remove_course_from_schedule(student, course_code)

        if is_removed == RemoveCourseReturnType.Locked:
            logger.warning("You can't remove any course since your schedule is already been approved!\n")
        elif is_removed == RemoveCourseReturnType.WaitingScheduleReview:
            logger.warning("Your schedule is under review by your advisor right now!\n")
        elif is_removed == RemoveCourseReturnType.NotExist:
            logger.warning(f"You cannot remove {course_code} from your schedule!\n")
        elif is_removed == RemoveCourseReturnType.Success:
            logger.info(f"You successfully removed {course_code} from your schedule\n")

def add_course_menu(student):
    logger.info("\n\n\n\n\nAvailable Courses\n")
    available_courses = StudentService.get_available_courses(student, False)
    for course in available_courses:
        logger.info(f"|  {course.course_code:<8}  |  {course.course_title:<40}  |  {course.taken_seats}/{course.max_seats} | ")
        for i in range(len(course.dates)):
            dayName = ""
            if course.dates[i].day_name == "MON":
                day_name = "Monday"
            elif course.dates[i].day_name == "TUE":
                day_name = "Tuesday"
            elif course.dates[i].day_name == "WED":
                day_name = "Wednesday"
            elif course.dates[i].day_name == "THU":
                day_name = "Thursday"
            elif course.dates[i].day_name == "FRI":
                day_name = "Friday"
            elif course.dates[i].day_name == "SAT":
                day_name = "Saturday"
            elif course.dates[i].day_name == "SUN":
                day_name = "Sunday"
            formatted = f"{course.dates[i].hours:02d}"
            formatted2 = f"{course.dates[i].hours + 1:02d}"
            logger.info(f"{dayName} {formatted}.00-{formatted2}.00{'' if i == len(course.dates) - 1 else ' & '}")
        logger.info("\n")

    while True:
        logger.info("\nEnter the course code to add it to your schedule (Type 9 to exit): ")


        course_code = scanner.next()

        if course_code == "9":
            break

        is_added = StudentService.add_course_to_schedule(student, course_code, available_courses)

        if is_added == AddCourseReturnType.Locked:
            logger.warning("You can't add any course right now since your schedule is approved!\n")
        elif is_added == AddCourseReturnType.WaitingScheduleReview:
            logger.warning("Your schedule is under review by your advisor right now!\n")
        elif is_added == AddCourseReturnType.SlotNotEmpty:
            logger.warning(f"You cannot add {course_code} because the time slot is not empty!\n")
        elif is_added == AddCourseReturnType.Success:
            logger.info(f"{course_code} successfully added to your schedule!\n")
        elif is_added == AddCourseReturnType.NotExistOnAvailableCourses:
            logger.warning(f"You cannot add {course_code} to your schedule!\n")
        elif is_added == AddCourseReturnType.NoAvailableSeats:
            logger.warning(f"You cannot add {course_code} because there isn't any available seats!\n")

def print_student_info(student):
    logger.info(f"\n\n\n\n\n{student.name} {student.surname}\n")
    logger.info(f"UUID = {student.uuid}\n")
    logger.info(f"E-mail = {student.email}\n")
    logger.info(f"Birth Date = {student.birth_date}\n")
    logger.info(f"Year enrolled = {student.year_enrolled}\n")
    logger.info(f"Semester = {student.semester}\n")
    logger.info(f"Advisor = {student.advisor.name} {student.advisor.surname if student.advisor else 'N/A'}\n")
    logger.info("Press enter to go back")
    scanner = input()

def print_instructor_info(instructor):
    logger.info(f"\n\n\n\n\n{instructor.name} {instructor.surname}\n")
    logger.info(f"UUID = {instructor.uuid}\n")
    logger.info(f"E-mail = {instructor.email}\n")
    logger.info(f"Birth Date = {instructor.birth_date}\n")
    logger.info("\nPresented Courses\n")
    for course in instructor.presented_courses:
        logger.info(f"{course.course_code} | {course.course_title}\n")
    logger.info("\nPress enter to go back")
    scanner = input()
