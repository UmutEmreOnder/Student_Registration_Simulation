package edu.marmara.model;

public class WeeklyDate {
    private DayName dayName;
    private Integer hours;

    public WeeklyDate() {
    }

    public WeeklyDate(DayName dayName, Integer hours) {
        this.dayName = dayName;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "WeeklyDate{" +
                "dayName=" + dayName +
                ", hours=" + hours +
                '}';
    }

    public DayName getDayName() {
        return dayName;
    }

    public void setDayName(DayName dayName) {
        this.dayName = dayName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
