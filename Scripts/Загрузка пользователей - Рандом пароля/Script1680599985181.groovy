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

WebUI.setText(findTestObject('Object Repository/Page_Connectable/input_Enter_workspace'), findTestData('dataFile').getValue(
        4, 1))

WebUI.setText(findTestObject('Object Repository/Page_Connectable/input_Enter_email'), findTestData('dataFile').getValue(
        3, 1))

WebUI.setText(findTestObject('Page_Connectable/пароль'), findTestData('dataFile').getValue(3, 2))

WebUI.click(findTestObject('Object Repository/Page_Connectable/войти'))

WebUI.click(findTestObject('Object Repository/Page_Connectable/Администратирование'))

def user = NewUser()

WebUI.closeBrowser()

static def NewUser() {
    for (int i = 0; i < 2; ++i) {
        WebUI.click(findTestObject('Object Repository/Page_Connectable/кнопка новый пользователь'))

        'имя'
        WebUI.setText(findTestObject('Object Repository/Page_Connectable/Имя'), findTestData('dataFile').getValue(2, 8 + 
                i))

        'отчество'
        String middleName = findTestData('dataFile').getValue(3, 8 + i)

        println(middleName)

        def setMiddleName = middleName.replaceAll('\\s+', '')

        WebUI.setText(findTestObject('Page_Connectable/Отчество'), setMiddleName)

        'фамилия'
        WebUI.setText(findTestObject('Object Repository/Page_Connectable/Фамилия'), findTestData('dataFile').getValue(1, 
                8 + i))

        'должность'
        WebUI.setText(findTestObject('Object Repository/Page_Connectable/Должность'), findTestData('dataFile').getValue(
                5, 8 + i))

        'мобильный телефон'
        WebUI.setText(findTestObject('Page_Connectable/моб.телефон'), findTestData('dataFile').getValue(6, 8 + i))

        'внутрений телефон\r\n'
        WebUI.setText(findTestObject('Page_Connectable/Внутрений телефон'), findTestData('dataFile').getValue(7, 8 + i))

        'майл'
        WebUI.setText(findTestObject('Object Repository/Page_Connectable/почта'), findTestData('dataFile').getValue(4, 8 + 
                i))

		final int[] genPassword = new Random().ints(0,9).distinct().limit(6).toArray();
		
		//int genPassword = Math.random()*9;
		
		println(genPassword)
		
		def pass = genPassword.join("");
		
		println(pass)
		
        WebUI.setText(findTestObject('Object Repository/Page_Connectable/подтверждение пароля'), pass)

        WebUI.setText(findTestObject('Object Repository/Page_Connectable/пароль'), pass)

        WebUI.click(findTestObject('Page_Connectable/кнопка создать'))

        WebUI.click(findTestObject('Page_Connectable/close'))

        WebUI.scrollToElement(findTestObject('Page_Connectable/скролл'), 30)
    }
}

