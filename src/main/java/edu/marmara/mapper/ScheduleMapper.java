package edu.marmara.mapper;

import edu.marmara.dto.ScheduleGetDTO;
import edu.marmara.model.Schedule;

public interface ScheduleMapper {
    Schedule mapTo(ScheduleGetDTO scheduleGetDTO);

    ScheduleGetDTO mapTo(Schedule schedule);
}