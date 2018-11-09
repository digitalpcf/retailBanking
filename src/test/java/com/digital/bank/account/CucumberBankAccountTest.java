package com.digital.bank.account;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/feature", glue="com.digital.bank.account.stepdef")
public class CucumberBankAccountTest {
}
