package com.co.rimac.tests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/ServiceUser.feature",
        //features = "src/test/resources/features/ServiceImage.feature",
        glue = "com.co.rimac.steps",
        tags = "@getAuthors",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ServiceUserTest {
}
