import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputCheckTests {

    @Test
    void test_validInput_Double() {
        // Arrange
        String toCheck = "7.7";
        boolean testResult;
        // Act
        testResult = InputCheck.validInput(toCheck);
        // Assert
        assertTrue(testResult, "used basic double, result should have been true");
    }

    @Test
    void test_validInput_Letters(){
        // Arrange
        String toCheck = "hello";
        boolean testResult;
        // Act
        testResult = InputCheck.validInput(toCheck);
        // Assert
        assertFalse(testResult, "Used alphabetic letters, so input cannot be parsed into double"+
                "result should have been false");
    }

    @Test
    void test_validMenuInput_IntInRange(){
        // Arrange
        String toCheck = "2";
        boolean testResult;
        // Act
        testResult = InputCheck.validMenuInput(toCheck);
        // Assert
        assertTrue(testResult, "used number between 1 and 3, result should have been True");
    }

    @Test
    void test_validMenuInput_IntOutRange(){
        // Arrange
        String toCheck = "4";
        boolean testResult;
        // Act
        testResult = InputCheck.validMenuInput(toCheck);
        // Assert
        assertFalse(testResult, "Used the number 4 which is out of range 1-3. result should have been False");
    }

    @Test
    void test_validMenuInput_letters(){
        // Arrange
        String toCheck = "hello";
        boolean testResult;
        // Act
        testResult = InputCheck.validMenuInput(toCheck);
        // Assert
        assertFalse(testResult, "hello cannot be parsed to an int and therfore the result should have been False");
    }

}


