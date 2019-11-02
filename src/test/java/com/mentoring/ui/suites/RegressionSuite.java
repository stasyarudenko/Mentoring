package com.mentoring.ui.suites;

import com.mentoring.ui.google.SearchForSeleniumAndVerifyResultsTest;
import com.mentoring.ui.google.SendEmailToYourselfTest;
import com.mentoring.ui.kieskeurig.RegisterAtKieskeurigTest;
import com.mentoring.ui.kieskeurig.SortingAtKieskeurigTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses( {SearchForSeleniumAndVerifyResultsTest.class
        , SendEmailToYourselfTest.class
        , RegisterAtKieskeurigTest.class
        , SortingAtKieskeurigTest.class
} )
public class RegressionSuite {
}
