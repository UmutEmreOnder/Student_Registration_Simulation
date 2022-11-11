package edu.marmara.model;

import lombok.Data;

import java.util.List;

@Data
public class WeeklyDate {
    private DayName dayName;
    private List<Integer> hours;
}
