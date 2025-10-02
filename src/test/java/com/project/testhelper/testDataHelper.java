package com.project.testhelper;

import com.github.javafaker.Faker;

public class testDataHelper {
    Faker faker = new Faker();
    public static final TestDataStore USERNAME = TestDataStore.INSTANCE;
    public static final TestDataStore EMAIL = TestDataStore.INSTANCE;
    public static final TestDataStore PASSWORD = TestDataStore.INSTANCE;
    private static boolean initialized = false;

    public void populateTestData() {
        if (!initialized) {
            String username = faker.name().firstName() + " " + faker.name().lastName();
            USERNAME.setUsername(username);
            EMAIL.setEmail(USERNAME.getUsername().toLowerCase().replace(" ", ".") + "@example.com");
            PASSWORD.setPassword(faker.internet().password(6, 10, true, true));
            initialized = true;
        }
    }
}
