import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class commUtli {

	@Keyword
	def static boolean isElementPresent(TestObject element, int timeout) {
		try {
			WebUI.verifyElementPresent(element, timeout)
			return true
		} catch (Exception e) {
			return false
		}
	}

	@Keyword
	def static void clickOnElement(TestObject element) {
		try {
			WebUI.click(element)
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to click on the element: " + e.getMessage())
		}
	}

	@Keyword
	def static void sendTextToElement(TestObject element, String text) {
		try {
			WebUI.sendKeys(element, text)
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to send text to the element: " + e.getMessage())
		}
	}


	@Keyword
	def static String getTextFromElement(String testObj) {
		TestObject element = findTestObject(testObj)
		String text = WebUI.getText(element)
		return text
	}
}
