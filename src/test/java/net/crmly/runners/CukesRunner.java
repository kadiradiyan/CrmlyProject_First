package net.crmly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {

                "pretty", // prints out additional information about the scenario that is being executed in the console

                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "net/crmly/step_definitions",
        dryRun = false, // if true: not executing the step definitions
        // if false: executing the step definitions
        tags = "@done",

        publish = true // when true --> publishes the tests online and the link can be shared with others, valid for a day
)
public class CukesRunner {
}

//report   https://reports.cucumber.io/reports/ff7ec980-2981-4596-9787-7a0d6305045c