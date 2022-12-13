package edu.marmara.service.impl;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class SchoolServiceImplTest {
    /**
     * Method under test:
     *
     * Class:SchoolServiceImpl Method:uploadJsons()
     */
    @Test
    void testUploadJsons() throws IOException, ParseException {
        (new SchoolServiceImpl()).uploadJsons();
    }
}

