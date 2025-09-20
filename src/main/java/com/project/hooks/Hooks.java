package com.project.hooks;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;
import com.project.base.BrowserManager;
import com.project.report.AutomationReporter;

/**
 * Hooks class to manage test lifecycle events.
 */
public class Hooks {
    private static final ExtentReports extent = AutomationReporter.getReporter();
    private static final Map<String, ExtentTest> featureMap = new HashMap<>();
    private static final ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @BeforeAll
    public static void setUp() {
        extent.setSystemInfo("Tester", "Abhishek Rangaswamy");
        BrowserManager.getInstance().openBrowser("chrome");
    }

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        String featureTitle = getFeatureTitle(scenario);
        String featureName = "Feature: " + featureTitle;

        ExtentTest feature = featureMap.computeIfAbsent(featureName, k -> extent.createTest(featureName));
        ExtentTest scenarioNode = feature.createNode("Scenario: " + scenario.getName());
        scenarioTest.set(scenarioNode);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot(scenario);
        } else {
            scenarioTest.get().pass("Step passed");
        }
    }

    @After
    public void afterScenario() {
        // Add per-scenario cleanup logic if needed
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
        BrowserManager.getInstance().closeBrowser();
    }

    private String getFeatureTitle(Scenario scenario) {
        try {
            Path featureFilePath = Paths.get(scenario.getUri());
            List<String> lines = Files.readAllLines(featureFilePath);
            return lines.stream()
                    .filter(line -> line.trim().startsWith("Feature:"))
                    .map(line -> line.replace("Feature:", "").trim())
                    .findFirst()
                    .orElse("Unknown Feature");
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown Feature";
        }
    }

    private void captureScreenshot(Scenario scenario) {
        try {
            Page page = BrowserManager.getInstance().getPage();
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + UUID.randomUUID() + ".png";
            String screenshotDir = "target/reports/screenshots/";
            Path screenshotPath = Paths.get(screenshotDir, screenshotName);
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath).setFullPage(true));
            scenarioTest.get().fail("Step failed").addScreenCaptureFromPath("./screenshots/" + screenshotName);
        } catch (Exception e) {
            scenarioTest.get().fail("Failed to attach screenshot: " + e.getMessage());
        }
    }

    public static void logStep(String stepText) {
        scenarioTest.get().info(stepText);
    }
}
