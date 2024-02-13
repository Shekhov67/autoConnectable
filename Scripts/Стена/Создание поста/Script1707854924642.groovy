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

WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('dataFile').getValue(1, 1))

WebUI.setText(findTestObject('Object Repository/Администрирование/input_Enter_workspace'), findTestData('dataFile').getValue(
        4, 1))

WebUI.setText(findTestObject('Object Repository/Администрирование/input_Enter_email'), findTestData('dataFile').getValue(
        3, 1))

WebUI.setText(findTestObject('Администрирование/пароль'), findTestData('dataFile').getValue(3, 2))

WebUI.click(findTestObject('Object Repository/Администрирование/войти'))

WebUI.click(findTestObject('Стена/Раздел Стена'))

def newsCompany = NewsCompany()

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

static def NewsCompany() {
    for (int i = 0; i < 11; i++) {
        WebUI.click(findTestObject('Стена/Вкладка новости компании'))

        WebUI.click(findTestObject('Стена/Поле ввода для поста'))

        WebUI.setText(findTestObject('Стена/Поле ввода для поста'), 'AutoTest' + i)

        WebUI.check(findTestObject('Стена/чек-бокс'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Стена/Кнопка Опубликовать'))

        //String news = WebUI.getText(findTestObject('Стена/Созданный пост')).substring('AutoTest', i)
		//println(news)
    }
}

