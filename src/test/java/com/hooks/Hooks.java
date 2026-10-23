package com.hooks;

import com.driver.DeviceSessionManager;

import io.cucumber.java.Before;

import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        if (!DeviceSessionManager.isDriverActive()) {
            System.out.println("===== Starting Mobile Device =====");
            DeviceSessionManager.startDevices();
        }
    }
    
    @After
    public void tearDown() {

        System.out.println("===== Scenario Completed =====");

    }

}