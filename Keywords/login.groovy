import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class login {

	@Keyword
	def static void loginIntoApplication(String applicationURL,String username,String password){

		WebUI.openBrowser(applicationURL)
		WebUI.maximizeWindow()

		WebUI.verifyElementPresent(findTestObject('Login/logo'), 0)
		WebUI.sendKeys(findTestObject('Login/userName'), username)
		WebUI.sendKeys(findTestObject('Login/userPassword'), password)
		WebUI.click(findTestObject('Login/loginButton'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Login/moduleIdDescription'), 0)
	}

	@Keyword
	def static void loginIntoApplicationWithGlobalVariable(){
		loginIntoApplication(GlobalVariable.urlLogin, GlobalVariable.username, GlobalVariable.password)
	}

	@Keyword
	def static void verifyFieldIsEmpty(TestObject fieldObject) {
		def fieldValue = WebUI.getAttribute(fieldObject, 'value')
		if (fieldValue.isEmpty()) {
			KeywordUtil.markPassed("The field is empty")
		} else {
			KeywordUtil.markFailed("The field is not empty")
		}
	}

	@Keyword
	def static void verificationIDcheck(String country,String MobNum,String name, String refrence, boolean sendSMS) {
		WebUI.click(findTestObject('Modules/verificationIcon'))
		if (sendSMS) {
			WebUI.click(findTestObject('Modules/verification/Idcheck/countryCodeDropDown'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/countrySearch'), country)
			WebUI.click(findTestObject('Modules/verification/Idcheck/selectCountry'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterMobileNumber'), MobNum)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterName'), name)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterRefrence'), refrence)
			WebUI.click(findTestObject('Modules/verification/Idcheck/buttonSend'))
			WebUI.verifyElementPresent(findTestObject('Modules/verification/Idcheck/succefulAlert'), 0)
			WebUI.click(findTestObject('Modules/hamburgerMenu'))
		}
	}

	@Keyword
	def static void verificationresetIDcheck(String country,String MobNum,String name, String refrence, boolean sendSMS) {
		WebUI.click(findTestObject('Modules/verificationIcon'))
		if (sendSMS) {
			WebUI.click(findTestObject('Modules/verification/Idcheck/countryCodeDropDown'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/countrySearch'), country)
			WebUI.click(findTestObject('Modules/verification/Idcheck/selectCountry'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterMobileNumber'), MobNum)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterName'), name)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterRefrence'), refrence)
			WebUI.click(findTestObject('Modules/verification/Idcheck/resetButton'))
			// Pass the TestObject for the fields you want to verify
			verifyFieldIsEmpty(findTestObject('Modules/verification/Idcheck/enterMobileNumber'))
			verifyFieldIsEmpty(findTestObject('Modules/verification/Idcheck/enterName'))
			verifyFieldIsEmpty(findTestObject('Modules/verification/Idcheck/enterRefrence'))
			WebUI.click(findTestObject('Modules/hamburgerMenu'))
		}
	}

	@Keyword
	def static void sendNotification(String recipient, String subject, String message, boolean sendSMS) {
		if (sendSMS) {


			// Send SMS (implement this part using an SMS gateway)
			sendSMSNotification(recipient, message)
		} else {
			// Send email
			sendEmailNotification(recipient, subject, message)
		}
	}
}

