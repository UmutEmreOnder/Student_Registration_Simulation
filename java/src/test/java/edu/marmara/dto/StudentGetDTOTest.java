package edu.marmara.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class StudentGetDTOTest {
    /**
     * Methods under test:
     *
     *   Class:StudentGetDTO Method:StudentGetDTO()
     *   Class:StudentGetDTO Method:setAdvisor(String)
     *   Class:StudentGetDTO Method:setBirthDate(Date)
     *   Class:StudentGetDTO Method:setEmail(String)
     *   Class:StudentGetDTO Method:setName(String)
     *   Class:StudentGetDTO Method:setSemester(Integer)
     *   Class:StudentGetDTO Method:setStudentId(Long)
     *   Class:StudentGetDTO Method:setSurname(String)
     *   Class:StudentGetDTO Method:setUuid(UUID)
     *   Class:StudentGetDTO Method:setYearEnrolled(Integer)
     *   Class:StudentGetDTO Method:toString()
     *   Class:StudentGetDTO Method:getAdvisor()
     *   Class:StudentGetDTO Method:getBirthDate()
     *   Class:StudentGetDTO Method:getEmail()
     *   Class:StudentGetDTO Method:getName()
     *   Class:StudentGetDTO Method:getSemester()
     *   Class:StudentGetDTO Method:getStudentId()
     *   Class:StudentGetDTO Method:getSurname()
     *   Class:StudentGetDTO Method:getUuid()
     *   Class:StudentGetDTO Method:getYearEnrolled()
     */
    @Test
    void testConstructor() {
        StudentGetDTO actualStudentGetDTO = new StudentGetDTO();
        actualStudentGetDTO.setAdvisor("Advisor");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualStudentGetDTO.setBirthDate(fromResult);
        actualStudentGetDTO.setEmail("jane.doe@example.org");
        actualStudentGetDTO.setName("Name");
        actualStudentGetDTO.setSemester(1);
        actualStudentGetDTO.setStudentId(123L);
        actualStudentGetDTO.setSurname("Doe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualStudentGetDTO.setUuid(randomUUIDResult);
        actualStudentGetDTO.setYearEnrolled(1);
        actualStudentGetDTO.toString();
        assertEquals("Advisor", actualStudentGetDTO.getAdvisor());
        assertSame(fromResult, actualStudentGetDTO.getBirthDate());
        assertEquals("jane.doe@example.org", actualStudentGetDTO.getEmail());
        assertEquals("Name", actualStudentGetDTO.getName());
        assertEquals(1, actualStudentGetDTO.getSemester().intValue());
        assertEquals(123L, actualStudentGetDTO.getStudentId().longValue());
        assertEquals("Doe", actualStudentGetDTO.getSurname());
        assertSame(randomUUIDResult, actualStudentGetDTO.getUuid());
        assertEquals(1, actualStudentGetDTO.getYearEnrolled().intValue());
    }

    /**
     * Methods under test:
     *
     *   Class:StudentGetDTO Method:StudentGetDTO(UUID, String, String, String, Date, Long, Integer, String, Integer)
     *   Class:StudentGetDTO Method:setAdvisor(String)
     *   Class:StudentGetDTO Method:setBirthDate(Date)
     *   Class:StudentGetDTO Method:setEmail(String)
     *   Class:StudentGetDTO Method:setName(String)
     *   Class:StudentGetDTO Method:setSemester(Integer)
     *   Class:StudentGetDTO Method:setStudentId(Long)
     *   Class:StudentGetDTO Method:setSurname(String)
     *   Class:StudentGetDTO Method:setUuid(UUID)
     *   Class:StudentGetDTO Method:setYearEnrolled(Integer)
     *   Class:StudentGetDTO Method:toString()
     *   Class:StudentGetDTO Method:getAdvisor()
     *   Class:StudentGetDTO Method:getBirthDate()
     *   Class:StudentGetDTO Method:getEmail()
     *   Class:StudentGetDTO Method:getName()
     *   Class:StudentGetDTO Method:getSemester()
     *   Class:StudentGetDTO Method:getStudentId()
     *   Class:StudentGetDTO Method:getSurname()
     *   Class:StudentGetDTO Method:getUuid()
     *   Class:StudentGetDTO Method:getYearEnrolled()
     */
    @Test
    void testConstructor2() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        StudentGetDTO actualStudentGetDTO = new StudentGetDTO(uuid, "Name", "Doe", "jane.doe@example.org",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 123L, 1, "Advisor", 1);
        actualStudentGetDTO.setAdvisor("Advisor");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualStudentGetDTO.setBirthDate(fromResult);
        actualStudentGetDTO.setEmail("jane.doe@example.org");
        actualStudentGetDTO.setName("Name");
        actualStudentGetDTO.setSemester(1);
        actualStudentGetDTO.setStudentId(123L);
        actualStudentGetDTO.setSurname("Doe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualStudentGetDTO.setUuid(randomUUIDResult);
        actualStudentGetDTO.setYearEnrolled(1);
        actualStudentGetDTO.toString();
        assertEquals("Advisor", actualStudentGetDTO.getAdvisor());
        assertSame(fromResult, actualStudentGetDTO.getBirthDate());
        assertEquals("jane.doe@example.org", actualStudentGetDTO.getEmail());
        assertEquals("Name", actualStudentGetDTO.getName());
        assertEquals(1, actualStudentGetDTO.getSemester().intValue());
        assertEquals(123L, actualStudentGetDTO.getStudentId().longValue());
        assertEquals("Doe", actualStudentGetDTO.getSurname());
        assertSame(randomUUIDResult, actualStudentGetDTO.getUuid());
        assertEquals(1, actualStudentGetDTO.getYearEnrolled().intValue());
    }
}

