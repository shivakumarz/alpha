import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

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
	def static void verificationIDcheck(String country,String MobNum,String name, String refrence, boolean sendSMS) {
		WebUI.click(findTestObject('Modules/verification/Idcheck/verificationIcon'))
		if (sendSMS) {
			WebUI.click(findTestObject('Modules/verification/Idcheck/countryCodeDropDown'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/countrySearch'), country)
			WebUI.click(findTestObject('Modules/verification/Idcheck/selectCountry'))
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterMobileNumber'), MobNum)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterName'), name)
			WebUI.sendKeys(findTestObject('Modules/verification/Idcheck/enterRefrence'), refrence)
			WebUI.click(findTestObject('Modules/verification/Idcheck/resetButton'))
			WebUI.verifyElementAttributeValue(findTestObject('Modules/verification/Idcheck/enterMobileNumber'), "value", MobNum)
			WebUI.verifyElementAttributeValue(findTestObject('Modules/verification/Idcheck/enterName'), "value", name)
			WebUI.verifyElementAttributeValue(findTestObject('Modules/verification/Idcheck/enterRefrence'), "value", refrence)
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

