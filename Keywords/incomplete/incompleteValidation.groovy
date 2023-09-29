package incomplete

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class incompleteValidation {

	@Keyword
	def static void serachIncompleteRec(String name){
		WebUI.click(findTestObject('Modules/repositoryIcon'))
		WebUI.click(findTestObject('Modules/Repository/TabIncomplete'))
		WebUI.sendKeys(findTestObject('Modules/Repository/searchbox'), name)
		WebUI.click(findTestObject('Modules/Repository/columnCheckbox'))
	}
	
	@Keyword
	def static void verifyTextMatches(TestObject element, String expTxt) {
		String actTxt = WebUI.getText(element)
		if (actTxt.equals(expTxt)) {
			println("Verification: Text matches the expected value: " + expTxt)
		} else {
			println("Verification: Text does not match the expected value.")
			throw new AssertionError("Text does not match the expected value: " + expTxt)
		}
	}
}
