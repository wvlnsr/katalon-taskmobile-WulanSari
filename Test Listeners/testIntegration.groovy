import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class testIntegration {
	String webhookURL = "https://hooks.slack.com/services/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"
	int totalTestCases = 0
	int passedCount = 0
	int failedCount = 0
	int errorCount = 0
	int skippedCount = 0

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		totalTestCases++
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		String status = testCaseContext.getTestCaseStatus()

		if (status == "PASSED") {
			passedCount++
		} else if (status == "FAILED") {
			failedCount++
		} else if (status == "ERROR") {
			errorCount++
		} else if (status == "SKIPPED") {
			skippedCount++
		}
	}

	@AfterTestSuite
	def notifySlack(TestSuiteContext testSuiteContext) {
		String testSuiteId = testSuiteContext.getTestSuiteId()

		String message = """
        Test Suite '${testSuiteId}' COMPLETED:
        Total Test Case: ${totalTestCases}
        Total Passed: ${passedCount}
        Total Failure: ${failedCount}
        Total Error: ${errorCount}
        Total Skipped: ${skippedCount}
        """

		sendSlackNotification(message)
	}
	def sendSlackNotification(String message) {
		try {
			URL url = new URL(webhookURL)
			HttpURLConnection connection = (HttpURLConnection) url.openConnection()
			connection.setRequestMethod("POST")
			connection.setRequestProperty("Content-Type", "application/json")
			connection.setDoOutput(true)

			String payload = """
            {
                "text": "${message}"
            }
            """

			OutputStream os = connection.getOutputStream()
			os.write(payload.getBytes("UTF-8"))
			os.close()

			int responseCode = connection.getResponseCode()
			if (responseCode == 200) {
				println "Notification sent to Slack successfully!"
			} else {
				println "Failed to send notification to Slack. Response code: ${responseCode}"
			}
		} catch (Exception e) {
			println "Error: ${e.message}"
		}
	}
}