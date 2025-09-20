package com.project.testhelper;

public enum TestDataStore {
    /*
     * That single enum constant (INSTANCE) represents the only
     * object of TestDataStore that will ever exist in your JVM.
     */
    INSTANCE;

    private String username;
    private String email;
    private String password;
    private String areaOfInterest;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }
}
