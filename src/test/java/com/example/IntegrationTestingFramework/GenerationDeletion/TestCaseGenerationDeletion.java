package com.example.IntegrationTestingFramework.GenerationDeletion;

import com.example.IntegrationTestingFramework.entity.Model;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCaseGenerationDeletion {

    // hashmap to store our generated users
    public static HashMap<Long, Model> database = new HashMap<>();
    // List to keep track of all generated users
    public static List<Long> userIds = new ArrayList<>();

    @BeforeAll
    public void createTestCase(){
        for (int i = 0; i < 10; i++) {
            // creating a new test case
            Model sampleModel = new Model();
            // setting information for our test case
            sampleModel.setId(i);
            sampleModel.setEmail("test@email.com");
            sampleModel.setName("test");
            sampleModel.setState((i * 2) + (i * 3));

            // storing our generated userIds
            userIds.add((long) i);
            // saving to our "database"
            // for clarity I am simply storing in a hashmap for now
            database.put((long) i, sampleModel);
        }

        // calling our business logic
        executeBusinessLogic();
    }


    private void executeBusinessLogic() {
        // write whatever business logic you want /
        // whatever external third party service calls
        // NO MOCKING!!
        // for now we will simply increment value of "state"
        for (int i = 0; i < 10; i++) {
            Model sampleModel = database.get((long) i);
            sampleModel.setState(sampleModel.getState() + 1);
        }
    }

    // method to delete all users
    // @AfterAll being used in order t
    @AfterAll
    public void deleteUser(){
        for(Long userId : userIds){
            database.remove(userId);
        }
        userIds.clear();

        log.info("size of database : {}" , database.size());
    }
}
