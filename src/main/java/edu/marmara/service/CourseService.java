package edu.marmara.service;

import edu.marmara.dto.CourseGetDTO;

import java.util.List;

public interface CourseService {
    void addPrerequisites(List<CourseGetDTO> courseGetDTOS);
}
