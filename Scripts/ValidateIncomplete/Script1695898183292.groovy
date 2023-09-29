import groovy.json.JsonSlurper

def jsonFilePath = "TestData/data.json"
def jsonSlurper = new JsonSlurper()
def jsonData = jsonSlurper.parseText(new File(jsonFilePath).text)

def IDcheck = jsonData.IDcheck

def name = IDcheck.name



CustomKeywords.'incomplete.incompleteValidation.serachIncompleteRec'(name)
def id = CustomKeywords.'commUtli.getTextFromElement'("Modules/Repository/labelID")
println(id)