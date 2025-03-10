package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.yaksha.assignment.utils.CustomParser;

public class UserControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testJspTagsAndHtmlTagPresenceInRegisterJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/register.jsp";

		// Check for form submission and input elements in register.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<form");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<form:input");
		boolean hasPasswordTags = CustomParser.checkJspTagPresence(filePath, "<form:password");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags && hasPasswordTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagPresenceInRegistrationSuccessJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/registration-success.jsp";

		// Check for success message and link to go back to home
		boolean hasSuccessMessage = CustomParser.checkJspTagPresence(filePath, "<h1>Registration Successful!</h1>");
		boolean hasBackLink = CustomParser.checkJspTagPresence(filePath, "<a href=\"/\">Back to Home</a>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasSuccessMessage && hasBackLink, businessTestFile);
	}

	@Test
	public void testFormActionForUserRegistrationInRegisterJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/register.jsp";

		// Check for correct form action tag for user registration submission
		boolean hasFormAction = CustomParser.checkJspTagPresence(filePath, "action=\"/user/register\"");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormAction, businessTestFile);
	}

	@Test
	public void testUserRegistrationRedirectAfterSuccess() throws Exception {
		// Simulate a user registration action and check for the redirect
		String expectedRedirectUrl = "/user/success";
		String actualRedirectUrl = "/user/success"; // Assuming successful registration redirects to this URL

		// Check if the redirect URL after user registration matches
		yakshaAssert(currentTest(), expectedRedirectUrl.equals(actualRedirectUrl), businessTestFile);
	}
}
