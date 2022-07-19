package com.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
// As an Abstractor I shall be able to search for Participating Site with CTEP ID OH029 in PA
@CucumberOptions(
    plugin={"pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
        features={"src/test/resources/features/browseToURL.feature","src/test/resources/features/organizations.feature"},
        glue={"com.example.Steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
