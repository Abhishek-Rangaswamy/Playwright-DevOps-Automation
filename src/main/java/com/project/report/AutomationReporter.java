package com.project.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationReporter {

    private static ExtentReports extentReports;

    public static ExtentReports getReporter() {
        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            String reportPath = "./target/reports/automation-report-" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
        return extentReports;
    }
}
