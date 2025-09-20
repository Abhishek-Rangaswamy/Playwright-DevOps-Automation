package com.project.runtest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "com.project.stepdefinitions",
        "com.project.hooks" }, plugin = {
                "pretty", "html:target/cucumber-reports.html" }, monochrome = true)
public class TestRunner {

}
