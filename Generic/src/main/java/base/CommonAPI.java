package base;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;
import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;

/**
 * Created by Faruque Ahamed on 5/10/2016.
 */
public class CommonAPI {
public WebDriver driver = null;
    @Parameters({"usecloud", "userName", "accessKey", "os","browserName","browserVersion","url"})
    @beforeMethod
    public void setUp (@optional("false") boolean usecloud, @Optional ("shahidaLucky") String userName, @Optional("")
       String accessKey, @Optional ("Winsows 8") String os, @Optional("firefox") String browserName, @Optional("34")
                       String browserVersion, @Optional("http:/'www.walmart.com") String url) throws IOException {
        if (usecloud==true) {
            //run in cliud
            getCloudDriver(userName,accessKey,os,browserName,BrowserVersion);
        }
        else{
            //run in local
            getLocalDriver(browserName);

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

    }

         Public WebDriver getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Generic/browser-driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "Generic/browser-driver/IEDriver");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String userName, String accessKey, String os, String browserName,
                                    String browserVersion) throws IOException {{
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.serCapability("version",browserVersion);
        driver = new RemoteWebDriver(new Url("http://"+userName+":"+accessKey+
                                    "@ondeamand.saucelabs.com:80/wd/hub"),cap);
        return driver;
    }

    }

    @AfterMethod
    public void cleanUp() {driver.quit();}

    public void clickByCss(String locator) { driver.findElement(By.cssSelector(locator)).click();}
    public void clickOnCss(String locator) { driver.findElement(By.cssSelector(locator)).click();}


    public void clickByXpath(String locator) { driver.findElement(By.xpath(locator)).click();}
    public void typeByCss(String locator, String value) { driver.findElement(By.cssSelector(locator)).sendkeys(value);}
    public void typeByXpath(String locator, String value) {driver.findElement(By.xpath(locator)).sendkeys(value);}
    public void takeEnterKeys(String locator) { driver.findElement(By.cssSelector(locator)).sendkeys(keys.ENTER);}

    List<WebElement> list = new ArrayList<WebElement>();
    list = driver.findElements(By.id(locator));

    return list;

}


     public List<String> getListOfString(List<WebElement> list) {
         List<String> items = new ArrayList<String>();
         for (WebElement element : list) {
             items.add(element.getText());
         }
         return items;
     }

        public void selectOptionByVisibleText(WebElement element, String value) {
            Select select = new Select(element);

        }
        // Navigation



          //Navigate to next page
           public void navigateback() {driver.navigate

         //Navigate to previous page
public void navigateForward() {
driver.navigate.forward();}
