package edu.marmara.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class InstructorGetDTOTest {
    /**
     * Methods under test:
     *
     *    Class:InstructorGetDTO Method:InstructorGetDTO()
     *    Class:InstructorGetDTO Method:setAdvisor(Boolean)
     *    Class:InstructorGetDTO Method:setBirthDate(Date)
     *    Class:InstructorGetDTO Method:setEmail(String)
     *    Class:InstructorGetDTO Method:setName(String)
     *    Class:InstructorGetDTO Method:setPresentedCourses(List)
     *    Class:InstructorGetDTO Method:setSurname(String)
     *    Class:InstructorGetDTO Method:setUuid(UUID)
     *    Class:InstructorGetDTO Method:toString()
     *    Class:InstructorGetDTO Method:getAdvisor()
     *    Class:InstructorGetDTO Method:getBirthDate()
     *    Class:InstructorGetDTO Method:getEmail()
     *    Class:InstructorGetDTO Method:getName()
     *    Class:InstructorGetDTO Method:getPresentedCourses()
     *    Class:InstructorGetDTO Method:getSurname()
     *    Class:InstructorGetDTO Method:getUuid()
     * </ul>
     */
    @Test
    void testConstructor() {
        InstructorGetDTO actualInstructorGetDTO = new InstructorGetDTO();
        actualInstructorGetDTO.setAdvisor(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualInstructorGetDTO.setBirthDate(fromResult);
        actualInstructorGetDTO.setEmail("jane.doe@example.org");
        actualInstructorGetDTO.setName("Name");
        ArrayList<String> stringList = new ArrayList<>();
        actualInstructorGetDTO.setPresentedCourses(stringList);
        actualInstructorGetDTO.setSurname("Doe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualInstructorGetDTO.setUuid(randomUUIDResult);
        actualInstructorGetDTO.toString();
        assertTrue(actualInstructorGetDTO.getAdvisor());
        assertSame(fromResult, actualInstructorGetDTO.getBirthDate());
        assertEquals("jane.doe@example.org", actualInstructorGetDTO.getEmail());
        assertEquals("Name", actualInstructorGetDTO.getName());
        assertSame(stringList, actualInstructorGetDTO.getPresentedCourses());
        assertEquals("Doe", actualInstructorGetDTO.getSurname());
        assertSame(randomUUIDResult, actualInstructorGetDTO.getUuid());
    }

    /**
     * Methods under test:
     *
     *   Class:InstructorGetDTO Method:InstructorGetDTO(UUID, String, String, String, Date, List, Boolean)
     *   Class:InstructorGetDTO Method:setAdvisor(Boolean)
     *   Class:InstructorGetDTO Method:setBirthDate(Date)
     *   Class:InstructorGetDTO Method:setEmail(String)
     *   Class:InstructorGetDTO Method:setName(String)
     *   Class:InstructorGetDTO Method:setPresentedCourses(List)
     *   Class:InstructorGetDTO Method:setSurname(String)
     *   Class:InstructorGetDTO Method:setUuid(UUID)
     *   Class:InstructorGetDTO Method:toString()
     *   Class:InstructorGetDTO Method:getAdvisor()
     *   Class:InstructorGetDTO Method:getBirthDate()
     *   Class:InstructorGetDTO Method:getEmail()
     *   Class:InstructorGetDTO Method:getName()
     *   Class:InstructorGetDTO Method:getPresentedCourses()
     *   Class:InstructorGetDTO Method:getSurname()
     *   Class:InstructorGetDTO Method:getUuid()
     */
    @Test
    void testConstructor2() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date birthDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        ArrayList<String> stringList = new ArrayList<>();
        InstructorGetDTO actualInstructorGetDTO = new InstructorGetDTO(uuid, "Name", "Doe", "jane.doe@example.org",
                birthDate, stringList, true);
        actualInstructorGetDTO.setAdvisor(true);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualInstructorGetDTO.setBirthDate(fromResult);
        actualInstructorGetDTO.setEmail("jane.doe@example.org");
        actualInstructorGetDTO.setName("Name");
        ArrayList<String> stringList1 = new ArrayList<>();
        actualInstructorGetDTO.setPresentedCourses(stringList1);
        actualInstructorGetDTO.setSurname("Doe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualInstructorGetDTO.setUuid(randomUUIDResult);
        actualInstructorGetDTO.toString();
        assertTrue(actualInstructorGetDTO.getAdvisor());
        assertSame(fromResult, actualInstructorGetDTO.getBirthDate());
        assertEquals("jane.doe@example.org", actualInstructorGetDTO.getEmail());
        assertEquals("Name", actualInstructorGetDTO.getName());
        List<String> presentedCourses = actualInstructorGetDTO.getPresentedCourses();
        assertSame(stringList1, presentedCourses);
        assertEquals(stringList, presentedCourses);
        assertEquals("Doe", actualInstructorGetDTO.getSurname());
        assertSame(randomUUIDResult, actualInstructorGetDTO.getUuid());
    }
}

