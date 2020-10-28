package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.ExcelDataObjects;
import com.tsoft.bot.frontend.pages.objects.OutputMessagesObjects;
import com.tsoft.bot.frontend.pages.objects.LoginObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.junit.Assert;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.base.BaseClass.stepFail;
import static com.tsoft.bot.frontend.base.BaseClass.stepPass;
import static com.tsoft.bot.frontend.steps.component.common.CommonComponents.loadBrowser;

public class LogInPages {

    OutputMessagesObjects outputMessagesObjects = new OutputMessagesObjects();
    LoginObjects pucharseMethodObjects = new LoginObjects();
    ExcelDataObjects excelDataObjects = new ExcelDataObjects();
    public WebDriver driver;
    String step = "";

    static GenerateWord generateWord = new GenerateWord();

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(excelDataObjects.EXCEL_FILE, excelDataObjects.EXCEL_SHEET3);
    }

    public LogInPages() {
        this.driver = Hook.getDriver();
    }

    public void enterWeb(String testCase) throws Throwable {
        try {
            int values = Integer.parseInt(testCase) - 1;
            String url = getData().get(values).get(excelDataObjects.COLUMN_URL_PROD);
            loadBrowser(driver, url);

            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            if (driver.findElements(pucharseMethodObjects.BannerModal).size()!=0) {
                Thread.sleep(2000);
                driver.findElement(pucharseMethodObjects.BtnCloseBanner).click();
            }

            if (driver.findElements(pucharseMethodObjects.TextModalPromotions).size()!=0) {
                Thread.sleep(2000);
                driver.findElement(pucharseMethodObjects.BtnCancelPromotions).click();
            }

            stepPass(driver, step);

        } catch (NoSuchWindowException | NoSuchSessionException e) {
            stepFail(driver, outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.addImageToWord(driver);
            driver.close();
            throw e;
        } catch (Throwable t) {
            stepFail(driver, outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.addImageToWord(driver);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void logIn(String testCase) throws Throwable {
        try {
            int values = Integer.parseInt(testCase) - 1;
            String email = getData().get(values).get(excelDataObjects.COLUMN_EMAIL_REPEAT);
            String password = getData().get(values).get(excelDataObjects.COLUMN_PASSWORD);

            driver.findElement(pucharseMethodObjects.BtnLogInUser).click();
            driver.findElement(pucharseMethodObjects.LinkTextLogIn).click();
            Thread.sleep(1000);
            driver.findElement(pucharseMethodObjects.BtnLogInPlazaProd).click();
            Thread.sleep(2000);
            driver.findElement(pucharseMethodObjects.InputEmail).sendKeys(email);
            driver.findElement(pucharseMethodObjects.InputPassword).sendKeys(password);
            generateWord.sendText(outputMessagesObjects.TitleMessageLogIn);
            generateWord.addImageToWord(driver);
            generateWord.sendBreak();
            driver.findElement(pucharseMethodObjects.BtnModalLogIn).click();
            Thread.sleep(3000);


        } catch (NoSuchWindowException | NoSuchSessionException e) {
            stepFail(driver, outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.addImageToWord(driver);
            driver.close();
            throw e;
        } catch (Throwable t) {
            stepFail(driver, outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.addImageToWord(driver);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

    public void validateLogIn() throws Throwable {
        try {

            driver.findElement(pucharseMethodObjects.IconPerfUser).click();

            Assert.assertTrue(pucharseMethodObjects.TextLogOut, driver.findElement(pucharseMethodObjects.ValidateTextLogOut).isDisplayed());
            generateWord.sendText(outputMessagesObjects.TitleUserMessageLogIn);
            generateWord.addImageToWord(driver);
            generateWord.sendBreak();
            Thread.sleep(35000);


        } catch (NoSuchWindowException | NoSuchSessionException e) {
            stepFail(driver, outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageError + step + outputMessagesObjects.MessageErrorEnd + e.getMessage());
            generateWord.addImageToWord(driver);
            driver.close();
            throw e;
        } catch (Throwable t) {
            stepFail(driver, outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.sendText(outputMessagesObjects.MessageErrorStep + step + outputMessagesObjects.MessageErrorEnd + t.getMessage());
            generateWord.addImageToWord(driver);
            driver.navigate().refresh();
            driver.close();
            throw t;
        }
    }

}
