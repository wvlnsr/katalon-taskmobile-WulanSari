import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('Apk/Solodroid_E-CommerceApp Demo_3.2.0.apk', false)

Mobile.verifyElementExist(findTestObject('profile-menu'), 0)

//Mobile.swipe(541, 1624, 532, 946)
Mobile.tap(findTestObject('profile-menu'), 0)

Mobile.verifyElementExist(findTestObject('profile-page/edit-btn'), 0)

Mobile.tap(findTestObject('profile-page/edit-btn'), 0)

Mobile.verifyElementExist(findTestObject('profile-page/username-btn'), 0)

Mobile.tap(findTestObject('profile-page/ok-btn'), 0)

Mobile.tap(findTestObject('profile-page/username-btn'), 0)

Mobile.setText(findTestObject('profile-page/field'), GlobalVariable.username, 0)

Mobile.tap(findTestObject('profile-page/ok-btn'), 0)

Mobile.tap(findTestObject('profile-page/phonenumber-btn'), 0)

Mobile.setText(findTestObject('profile-page/field'), GlobalVariable.phonenumber, 0)

Mobile.tap(findTestObject('profile-page/ok-btn'), 0)

Mobile.tap(findTestObject('profile-page/address-btn'), 0)

Mobile.setText(findTestObject('profile-page/field'), GlobalVariable.address, 0)

Mobile.tap(findTestObject('profile-page/ok-btn'), 0)

Mobile.pressBack()

Mobile.closeApplication()

