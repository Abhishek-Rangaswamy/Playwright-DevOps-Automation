package com.project.testhelper;

import com.github.javafaker.Faker;

public class testDataHelper {
    Faker faker = new Faker();
    public static final TestDataStore USERNAME = TestDataStore.INSTANCE;
    public static final TestDataStore EMAIL = TestDataStore.INSTANCE;
    public static final TestDataStore PASSWORD = TestDataStore.INSTANCE;

    public void populateTestData() {
        USERNAME.setUsername(faker.name().fullName());
        EMAIL.setEmail(faker.internet().emailAddress());
        PASSWORD.setPassword(faker.internet().password(5, 10, true, true));
    }
}
