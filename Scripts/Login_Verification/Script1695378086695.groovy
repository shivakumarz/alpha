import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import groovy.json.JsonSlurper

def jsonFilePath = "TestData/data.json"
def jsonSlurper = new JsonSlurper()
def jsonData = jsonSlurper.parseText(new File(jsonFilePath).text)

def IDcheck = jsonData.IDcheck

def country = IDcheck.Country
def mobNum = IDcheck.mobNumAU
def name = IDcheck.name
def refrence = IDcheck.refrence


CustomKeywords.'login.loginIntoApplicationWithGlobalVariable'()
CustomKeywords.'login.verificationIDcheck'(country, mobNum, name, refrence, true)


