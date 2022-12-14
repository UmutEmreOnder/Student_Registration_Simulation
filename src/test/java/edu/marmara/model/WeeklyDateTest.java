package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WeeklyDateTest {
    /**
     * Methods under test:
     *
     *   Class:WeeklyDate Method:WeeklyDate()
     *   Class:WeeklyDate Method:setDayName(DayName)
     *   Class:WeeklyDate Method:setHours(Integer)
     *   Class:WeeklyDate Method:toString()
     *   Class:WeeklyDate Method:getDayName()
     *   Class:WeeklyDate Method:getHours()
     */
    @Test
    void testConstructor() {
        WeeklyDate actualWeeklyDate = new WeeklyDate();
        actualWeeklyDate.setDayName(DayName.MON);
        actualWeeklyDate.setHours(1);
        String actualToStringResult = actualWeeklyDate.toString();
        assertEquals(DayName.MON, actualWeeklyDate.getDayName());
        assertEquals(1, actualWeeklyDate.getHours().intValue());
        assertEquals("WeeklyDate{dayName=MON, hours=1}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     *   Class:WeeklyDate Method:WeeklyDate(DayName, Integer)
     *   Class:WeeklyDate Method:setDayName(DayName)
     *   Class:WeeklyDate Method:setHours(Integer)
     *   Class:WeeklyDate Method:toString()
     *   Class:WeeklyDate Method:getDayName()
     *   Class:WeeklyDate Method:getHours()
     */
    @Test
    void testConstructor2() {
        WeeklyDate actualWeeklyDate = new WeeklyDate(DayName.MON, 1);
        actualWeeklyDate.setDayName(DayName.MON);
        actualWeeklyDate.setHours(1);
        String actualToStringResult = actualWeeklyDate.toString();
        assertEquals(DayName.MON, actualWeeklyDate.getDayName());
        assertEquals(1, actualWeeklyDate.getHours().intValue());
        assertEquals("WeeklyDate{dayName=MON, hours=1}", actualToStringResult);
    }
}

