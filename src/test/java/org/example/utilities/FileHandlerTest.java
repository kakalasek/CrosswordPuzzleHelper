package org.example.utilities;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.utilities.FileHandler.*;

class FileHandlerTest {

    @Test
    void throwsExceptionIfInvalidFilePath(){
        assertThrows(IOException.class,
                () -> {
                    CSV_to_array("IAmAnInvalidFilePath");
                });
    }

    @Test
    void throwsExceptionIfInvalidCSVFormat(){
        assertThrows(IOException.class,
                () -> {
                    CSV_to_array("src/test/java/org/example/utilities/InvalidCSV");
                });
    }


}