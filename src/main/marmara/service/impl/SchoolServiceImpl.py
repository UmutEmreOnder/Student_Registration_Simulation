from lib2to3.pgen2.parse import ParseError
from src.main.marmara.service.impl import StudentServiceImpl
from typing import List
import os
import json

from src.main.marmara.model.School import School
from src.main.marmara.service.impl.JsonServiceImpl import JsonServiceImpl


class SchoolServiceImpl:
    def upload_jsons(self):
        json_service = JsonServiceImpl()
        school = School.get_instance()

        student_service = StudentServiceImpl()

        try:
            with open("json/config/config.json", "r") as config_file:
                config_info = config_file.read()
            config = json_service.read_config_from_json(config_info)
            school.set_config(config)
        except IOError as e:
            raise RuntimeError(e)

        try:
            with open("json/course/course.json", "r") as course_file:
                course_info = course_file.read()
            courses = json_service.read_courses_from_json(course_info)
            school.set_courses(courses)
        except (IOError, ParseError) as e:
            raise RuntimeError(e)

        try:
            with open("json/instructor/instructor.json", "r") as instructor_file:
                instructor_info = instructor_file.read()
            instructors = json_service.read_instructors_from_json(instructor_info)
            school.set_instructors(instructors)

            count = 0
            student_files = [f for f in os.listdir("json/student/") if f.endswith(".json")]
            for student_file in student_files:
                if count >= school.config.number_of_students() {
                    break;
                }

                with open(f"json/student/{student_file}", "r") as file:
                    content = file.read()
                student = json_service.read_student_from_json(content)

                schedule_file = f"json/schedule/{student.get_student_id()}.json"
                transcript_file = f"json/transcript/{student.get_student_id()}.json"

                if os.path.exists(schedule_file):
                    with open(schedule_file, "r") as file:
                        schedule = json_service.read_schedule_from_json(file.read())
                    student.set_weekly_schedule(schedule)

                if os.path.exists(transcript_file):
                    with open(transcript_file, "r") as file:
                        transcript = json_service.read_transcript_from_json(file.read())
                    transcript.calculate_gpa()
                    student.set_transcript(transcript)
                else:
                    student_service.assign_random_courses(student)

                school.add_student(student)
        except (RuntimeError, IOError, ParseError) as e:
            raise RuntimeError(e)
