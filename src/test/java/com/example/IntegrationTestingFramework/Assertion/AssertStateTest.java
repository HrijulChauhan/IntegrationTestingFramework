package com.example.IntegrationTestingFramework.Assertion;

import com.example.IntegrationTestingFramework.GenerationDeletion.TestCaseGenerationDeletion;
import com.example.IntegrationTestingFramework.entity.Model;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
public class AssertStateTest extends TestCaseGenerationDeletion {

    // will trigger 10 tests
   @ParameterizedTest
   @MethodSource("testData")
   public void checkState(int id){
       // getting Model via Id
       Model sampleModel = database.get((long) id);

       // calculating our expected output
       int expectedState = ((id * 2) + (id * 3)) + 1;

       // checking expected vs actual output
       assertEquals(expectedState, sampleModel.getState());

       log.info("expected state {} vs actual state {}", expectedState, sampleModel.getState());
   }

   // Method to provide test data
   private static Stream<Object[]> testData() {
       return Stream.of(
               new Object[]{0},
               new Object[]{1},
               new Object[]{2},
               new Object[]{3},
               new Object[]{4},
               new Object[]{5},
               new Object[]{6},
               new Object[]{7},
               new Object[]{8},
               new Object[]{9}
       );
   }
}
