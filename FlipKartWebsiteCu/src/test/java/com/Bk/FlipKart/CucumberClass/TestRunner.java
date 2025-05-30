package com.Bk.FlipKart.CucumberClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\2261164\\eclipse-workspace\\FlipKartWebsiteCu\\src\\test\\resources\\Features\\AddingProductToCart.feature", plugin = {"html:target/jsonReports/cucumber-report.html","pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, glue = {"com.Bk.StepDefinition"}/*,
tags = ("@AddingProductToTheCart")*/)
public class TestRunner {
	
	


}
