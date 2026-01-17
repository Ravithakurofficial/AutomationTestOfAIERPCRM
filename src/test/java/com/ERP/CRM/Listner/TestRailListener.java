package com.ERP.CRM.Listner;

import com.testRailmanager.testrailmanager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TestRailListener {

    @After
    public void afterScenario(Scenario scenario) {
        String testCaseId = getTestCaseIdFromScenario(scenario); // implement this
        int status = scenario.isFailed() ? 5 : 1; // 1=Passed, 5=Failed (TestRail IDs)
        String error = "no error found test is executed";

        if (scenario.isFailed()) {
            error = scenario.getStatus().name() + ": " + scenario.getName();
        }

        // Call your TestRail method
        testrailmanager.addresult(testCaseId, status, error);
    }

    // Helper method: map scenario name to TestRail ID
    private String getTestCaseIdFromScenario(Scenario scenario) {
        // Option 1: read from scenario name like "C1234 - Login test"
        // Option 2: use @TestCaseId tag on feature
        if (scenario.getSourceTagNames() != null) {
            for (String tag : scenario.getSourceTagNames()) {
                if (tag.startsWith("@C")) {
                    return tag.substring(2); // e.g., @C123 → 123
                }
            }
        }
        return "0"; // default or throw error
    }
}
