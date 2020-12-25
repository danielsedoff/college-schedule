package com.danielsedoff.college.schedule.dao.datasource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ResourceFileReaderTest {

    @Test
    void ResourceFileReaderShouldReturnThis() throws IOException {
        ResourceFileReader reader = new ResourceFileReader();
        String result = reader.readFileToString("database.properties");
        assertTrue(result.indexOf("driver=") > -1);
    }

    @Test
    void testExpectedException() {

        assertThrows(NullPointerException.class, () -> {
            ResourceFileReader reader = new ResourceFileReader();
            reader.readFileToString("WRONG.FILE");
        });

    }
}
