import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
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
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('dataFile').getValue(1, 1))

WebUI.setText(findTestObject('Object Repository/Администрирование/input_Enter_workspace'), findTestData('dataFile').getValue(
        4, 1))

WebUI.setText(findTestObject('Object Repository/Администрирование/input_Enter_email'), findTestData('dataFile').getValue(
        3, 1))

WebUI.setText(findTestObject('Администрирование/пароль'), findTestData('dataFile').getValue(3, 2))

WebUI.click(findTestObject('Object Repository/Администрирование/войти'))

WebUI.click(findTestObject('Object Repository/Администрирование/Администратирование'))

def user = NewUser()

WebUI.closeBrowser() //Пароль клиента

static def NewUser() {
    for (int i = 0; i < 355; ++i) {
        WebUI.click(findTestObject('Object Repository/Администрирование/кнопка новый пользователь'))

        'имя'
        WebUI.setText(findTestObject('Object Repository/Администрирование/Имя'), findTestData('dataFile').getValue(2, 8 + 
                i))

        'отчество'
        String middleName = findTestData('dataFile').getValue(3, 8 + i)

        println(middleName)

        def setMiddleName = middleName.replaceAll('\\s+', '')

        WebUI.setText(findTestObject('Администрирование/Отчество'), setMiddleName)

        'фамилия'
        WebUI.setText(findTestObject('Object Repository/Администрирование/Фамилия'), findTestData('dataFile').getValue(1, 
                8 + i))

        'должность'
        WebUI.setText(findTestObject('Object Repository/Администрирование/Должность'), findTestData('dataFile').getValue(
                5, 8 + i))

        'мобильный телефон'
        WebUI.setText(findTestObject('Администрирование/моб.телефон'), findTestData('dataFile').getValue(6, 8 + i))

        'внутрений телефон'
        WebUI.setText(findTestObject('Администрирование/Внутрений телефон'), findTestData('dataFile').getValue(7, 8 + i))

        'майл'
        WebUI.setText(findTestObject('Object Repository/Администрирование/почта'), findTestData('dataFile').getValue(4, 8 + 
                i))

        WebUI.setText(findTestObject('Администрирование/пароль'), findTestData('dataFile').getValue(8, 8 + i))

        WebUI.setText(findTestObject('Администрирование/подтверждение пароля'), findTestData('dataFile').getValue(8, 8 + 
                i))

        WebUI.click(findTestObject('Администрирование/кнопка создать'))

        WebUI.click(findTestObject('Администрирование/close'))

        WebUI.scrollToElement(findTestObject('Администрирование/скролл'), 30)
    }
}

