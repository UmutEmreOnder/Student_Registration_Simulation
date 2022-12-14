package edu.marmara.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class PersonTest {
    /**
     * Method under test:
     *
     * Class:Person Method:toString()
     */
    @Test
    void testToString() {
        assertEquals("Advisor{students=null}", (new Advisor()).toString());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:getUuid()
     */
    @Test
    void testGetUuid() {
        assertNull((new Advisor()).getUuid());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:setUuid(UUID)
     */
    @Test
    void testSetUuid() {
        Advisor advisor = new Advisor();
        UUID randomUUIDResult = UUID.randomUUID();
        advisor.setUuid(randomUUIDResult);
        assertSame(randomUUIDResult, advisor.getUuid());
    }

    /**
     * Method under test:
     *
     * Class:Person Person:getName()
     */
    @Test
    void testGetName() {
        assertNull((new Advisor()).getName());
    }

    /**
     * Method under test:
     *
     * Class:Person Person:setName(String)
     *
     */
    @Test
    void testSetName() {
        Advisor advisor = new Advisor();
        advisor.setName("Name");
        assertEquals("Name", advisor.getName());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:getSurname()
     */
    @Test
    void testGetSurname() {
        assertNull((new Advisor()).getSurname());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:setSurname(String)
     */
    @Test
    void testSetSurname() {
        Advisor advisor = new Advisor();
        advisor.setSurname("Doe");
        assertEquals("Doe", advisor.getSurname());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:getEmail()
     */
    @Test
    void testGetEmail() {
        assertNull((new Advisor()).getEmail());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:setEmail(String)
     */
    @Test
    void testSetEmail() {
        Advisor advisor = new Advisor();
        advisor.setEmail("jane.doe@example.org");
        assertEquals("jane.doe@example.org", advisor.getEmail());
    }

    /**
     * Method under test:
     *
     * Class:Person Method:getBirthDate()
     */
    @Test
    void testGetBirthDate() {
        assertNull((new Advisor()).getBirthDate());
    }

    /**
     * Method under test:
     *
     * Class:Person Method: setBirthDate(Date)
     */
    @Test
    void testSetBirthDate() {
        Advisor advisor = new Advisor();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        advisor.setBirthDate(fromResult);
        assertSame(fromResult, advisor.getBirthDate());
    }
}

