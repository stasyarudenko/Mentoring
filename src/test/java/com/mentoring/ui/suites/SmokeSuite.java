package com.mentoring.ui.suites;

import com.mentoring.ui.google.SearchForSeleniumAndVerifyResultsTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses( {SearchForSeleniumAndVerifyResultsTest.class} )
public class SmokeSuite {
}
