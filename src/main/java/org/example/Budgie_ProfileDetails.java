package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Budgie_ProfileDetails {
    public static WebDriver driver;
    public Logger log= (Logger) LogManager.getLogger(Budgie_ProfileDetails.class.getName());

@Parameters({"Login","password"})
    @BeforeClass
    public void main(String Login,String password) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://216.48.191.170/budgie_test/public/index.php");
        driver.findElement(By.id("employee_id")).sendKeys(Login);
        driver.findElement(By.id("login_password")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Home")));
        driver.navigate().to("http://216.48.191.170/budgie_test/public/index.php/candidate_profile");

    }
@Test
     void BasicDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Home")));
        //Display the name and Role
        WebElement name = driver.findElement(By.xpath("//div[@class='col-sm-12 col-lg-4 order-sm-0 order-xl-1']//div//div//a"));
        WebElement role = driver.findElement(By.xpath("//div[@class='col-sm-12 col-lg-4 order-sm-0 order-xl-1']//div//div[2]"));
        System.out.println(name.getText() + " : " + role.getText());
        log.info(name.getText() + " : " + role.getText());
        //display the mail,DOB,Contact Us,Work Location
        List<WebElement> Profileheading = driver.findElements(By.xpath("//div[@class='text-center']//div//div//div//div//div//div//h6"));
        //display the emailValue,DOB Value
        WebElement email = driver.findElement(By.xpath("//div[@class='text-center']//div//div//div//div//div//div//div"));
        WebElement DOB = driver.findElement(By.xpath("//div[@class='text-center']//div//div//div//div//div[2]//div//div"));
        //display the Contact Us and location Value
        WebElement ContactUs = driver.findElement(By.xpath("//div[@class='col-sm-6 col-lg-4 order-sm-2 order-xl-2']//div//div//div//span//a"));
        WebElement location = driver.findElement(By.xpath("//div[@class='col-sm-6 col-lg-4 order-sm-2 order-xl-2']//div//div[2]//a"));
        for (WebElement BioHead : Profileheading) {
            String bio = BioHead.getText();
            System.out.print(bio + " : ");
            log.info(bio + " : ");
            if (bio.contains("Official Email")) {
                System.out.print(email.getText());
                log.info(email.getText());
            } else if (bio.contains("DOB")) {
                System.out.print(DOB.getText());
                log.info(DOB.getText());
            } else if (bio.contains("Contact Us")) {
                System.out.print(ContactUs.getText());
                log.info(ContactUs.getText());
            } else if (bio.contains("Work Location")) {
                System.out.print(location.getText());
                log.info(location.getText());
            }
            System.out.println();
        }
        if ((name.getText().contains("null")||name.getText().equalsIgnoreCase("null"))||(role.getText().contains("null")||role.getText().equalsIgnoreCase("null"))||(email.getText().contains("null")||email.getText().equalsIgnoreCase("null"))||(DOB.getText().contains("null")||DOB.getText().equalsIgnoreCase("null"))||(ContactUs.getText().contains("null")||ContactUs.getText().equalsIgnoreCase("null"))||(location.getText().contains("null")||location.getText().equalsIgnoreCase("null"))){
            log.info("================================================================");
            System.out.println("꧁༒☬\uD835\uDCDC\uD835\uDD02 \uD835\uDCDF\uD835\uDCFB\uD835\uDCF8\uD835\uDCEF\uD835\uDCF2\uD835\uDCF5\uD835\uDCEE \uD835\uDCD7\uD835\uDCEE\uD835\uDCEA\uD835\uDCED\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("꧁༒☬\uD835\uDCDC\uD835\uDD02 \uD835\uDCDF\uD835\uDCFB\uD835\uDCF8\uD835\uDCEF\uD835\uDCF2\uD835\uDCF5\uD835\uDCEE \uD835\uDCD7\uD835\uDCEE\uD835\uDCEA\uD835\uDCED\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("================================================================");
        }

        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        WebElement BasicDetails = driver.findElement(By.linkText("Basic Details"));
        System.out.println(BasicDetails.getText());
        log.info(BasicDetails.getText());
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        List<WebElement> details = driver.findElements(By.xpath("//div[@class='col-md-4']//strong"));
        List<WebElement> detailsValue = driver.findElements(By.xpath("//div[@class='col-md-4']//a"));

        int size = Math.min(details.size(), detailsValue.size());
        for (int i = 0; i < size; i++) {
            String detailText = details.get(i).getText();
            String valueText = detailsValue.get(i).getText();
            if (valueText.isEmpty()) {
                valueText = " ";
            }
            System.out.println(detailText + " " + valueText);
            log.info(detailText + " " + valueText);
            if (valueText.contains("null")||valueText.equalsIgnoreCase("null")){
                log.info("================================================================");
                System.out.println("꧁༒☬\uD835\uDCD1\uD835\uDCEA\uD835\uDCFC\uD835\uDCF2\uD835\uDCEC \uD835\uDCD3\uD835\uDCEE\uD835\uDCFD\uD835\uDCEA\uD835\uDCF2\uD835\uDCF5\uD835\uDCFC \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
                log.info("꧁༒☬\uD835\uDCD1\uD835\uDCEA\uD835\uDCFC\uD835\uDCF2\uD835\uDCEC \uD835\uDCD3\uD835\uDCEE\uD835\uDCFD\uD835\uDCEA\uD835\uDCF2\uD835\uDCF5\uD835\uDCFC \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
                log.info("================================================================");
                break;
            }
        }
    }
    @Test(dependsOnMethods = {"BasicDetails"})
    void Contact() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement contactTab = driver.findElement(By.linkText("Contact"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(contactTab).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='v-pills-messages']/nav/span")));
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        WebElement Contact = driver.findElement(By.linkText("Contact"));
        System.out.println(Contact.getText());
        log.info(Contact.getText());
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");

        WebElement phone=driver.findElement(By.xpath("(//div[@class='col-md-6'])[5]//strong"));
        WebElement phoneValue=driver.findElement(By.xpath("(//div[@class='col-md-6'])[5]//p[@id='p_num_view']"));
        String Phone=phone.getAttribute("textContent");
        String PhoneValue=phoneValue.getAttribute("textContent");
        System.out.println(Phone+" "+PhoneValue);
        log.info(Phone+" "+PhoneValue);
        WebElement secondaryphone=driver.findElement(By.xpath("(//div[@class='col-md-6'])[6]//strong"));
        WebElement secondaryValue=driver.findElement(By.xpath("(//div[@class='col-md-6'])[6]//p"));
        String SecPhone=secondaryphone.getAttribute("textContent");
        String SecPhoneValue=secondaryValue.getAttribute("textContent");
        System.out.println(SecPhone+" "+SecPhoneValue);
        log.info(SecPhone+" "+SecPhoneValue);
        WebElement email=driver.findElement(By.xpath("//*[@id='v-pills-messages']//div[3]/strong"));
        WebElement emailValue=driver.findElement(By.xpath("(//div[@class='col-md-6'])[5]//p[@id='p_num_view']"));
        String Email=email.getAttribute("textContent");
        String EmailValue=emailValue.getAttribute("textContent");
        List<WebElement> address=driver.findElements(By.xpath("//div[@class='col-3 pr-0']"));
        List<WebElement>addressValue=driver.findElements(By.xpath("//div[@class='col-8 pl-0']"));
        int size = Math.min(address.size(),addressValue.size());
        for (int i = 0; i < size; i++) {
            String detailText = address.get(i).getText();
            String valueText = addressValue.get(i).getText();
            System.out.println(detailText + " : " + valueText);
            log.info(detailText + " : " + valueText);
            if ((PhoneValue.contains("null")||PhoneValue.equalsIgnoreCase("null"))||(SecPhoneValue.contains("null")||SecPhoneValue.equalsIgnoreCase("null"))||(EmailValue.contains("null")||EmailValue.equalsIgnoreCase("null"))||(valueText.contains("null")||valueText.equalsIgnoreCase("null"))){
                log.info("================================================================");
                System.out.println("꧁༒☬\uD835\uDCD2\uD835\uDCF8\uD835\uDCF7\uD835\uDCFD\uD835\uDCEA\uD835\uDCEC\uD835\uDCFD \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
                log.info("꧁༒☬\uD835\uDCD2\uD835\uDCF8\uD835\uDCF7\uD835\uDCFD\uD835\uDCEA\uD835\uDCEC\uD835\uDCFD \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
                log.info("================================================================");
                break;
            }
        }
        System.out.println(Email+" "+EmailValue);
        log.info(Email+" "+EmailValue);
    }
    @Test(dependsOnMethods = {"Contact"})
    void WorkingInformation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement contactTab = driver.findElement(By.linkText("Working Information"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(contactTab).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='v-pills-Working-Information']/nav/span")));
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        WebElement WorkingInformation = driver.findElement(By.linkText("Working Information"));
        System.out.println(WorkingInformation.getText());
        log.info(WorkingInformation.getText());
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        List<WebElement> department=driver.findElements(By.xpath("(//div[@class='row'])[14]//strong"));
        List<WebElement>departmentValue=driver.findElements(By.xpath("(//div[@class='row'])[14]//a"));
        WebElement rfhValue=driver.findElement(By.xpath("//*[@id='v-pills-Working-Information']//div[2]/div[4]"));
        String RFHvalue=rfhValue.getText();
        WebElement email=driver.findElement(By.xpath("//*[@id='v-pills-Working-Information']//div[2]/div[5]/strong"));
        WebElement emailValue=driver.findElement(By.xpath("//*[@id='email_txt']"));
        String Email=email.getText();
        String Emailvalue=emailValue.getText();
        WebElement Esi=driver.findElement(By.xpath("//*[@id='v-pills-Working-Information']//div[2]/div[6]/strong"));
        WebElement EsiValue=driver.findElement(By.id("esi_no_txt"));
        String esi=Esi.getText();
        String esiValue=EsiValue.getText();
        int size = Math.min(department.size(),departmentValue.size());

        for (int i = 0; i < size-2; i++) {

            String detailText = department.get(i).getText();
            String valueText = departmentValue.get(i).getText();
            System.out.println(detailText + " " + valueText);
            log.info(detailText + " " + valueText);
           if ((valueText.contains("null")||valueText.equalsIgnoreCase("null"))||(RFHvalue.contains("null")||RFHvalue.equalsIgnoreCase("null"))||(Emailvalue.contains("null")||Emailvalue.equalsIgnoreCase("null"))||(esiValue.contains("null")||esiValue.equalsIgnoreCase("null"))){
               log.info("================================================================");
               System.out.println("꧁༒☬\uD835\uDCE6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF4\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCD8\uD835\uDCF7\uD835\uDCEF\uD835\uDCF8\uD835\uDCFB\uD835\uDCF6\uD835\uDCEA\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7 \uD835\uDCD7\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
               log.info("꧁༒☬\uD835\uDCE6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF4\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCD8\uD835\uDCF7\uD835\uDCEF\uD835\uDCF8\uD835\uDCFB\uD835\uDCF6\uD835\uDCEA\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7 \uD835\uDCD7\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
               log.info("================================================================");
               break;
           }
        }

        System.out.println(RFHvalue);
        log.info(RFHvalue);
        System.out.println(Email+" "+Emailvalue);
        log.info(Email+" "+Emailvalue);
        System.out.println(esi+" "+esiValue);
        log.info(esi+" "+esiValue);
    }
    @Test(dependsOnMethods = {"WorkingInformation"})
  void HRdepartment() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    WebElement contactTab = driver.findElement(By.linkText("HR Information"));
        Thread.sleep(2000);
    Actions actions = new Actions(driver);
    actions.moveToElement(contactTab).click().perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='v-pills-Information']/nav/span")));
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
        WebElement HRInformation = driver.findElement(By.linkText("HR Information"));
        System.out.println(HRInformation.getText());
        log.info(HRInformation.getText());
        System.out.println("----------------------------------------------------------------");
        log.info("----------------------------------------------------------------");
    List<WebElement> department = driver.findElements(By.xpath("(//div[@class='row'])[15]//strong"));
    List<WebElement> departmentValue = driver.findElements(By.xpath("(//div[@class='row'])[15]//a"));
    int size=Math.min(department.size(),departmentValue.size());
    for (int i = 0; i < size; i++) {
        String Dept=department.get(i).getText();
        String DeptValue=departmentValue.get(i).getText();
        System.out.println(Dept+" "+DeptValue);
        log.info(Dept+" "+DeptValue);
        if (DeptValue.contains("null")||DeptValue.equalsIgnoreCase("null")){
            log.info("================================================================");
            System.out.println("꧁༒☬\uD835\uDCD7\uD835\uDCE1 \uD835\uDCED\uD835\uDCEE\uD835\uDCF9\uD835\uDCEA\uD835\uDCFB\uD835\uDCFD\uD835\uDCF6\uD835\uDCEE\uD835\uDCF7\uD835\uDCFD \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("꧁༒☬\uD835\uDCD7\uD835\uDCE1 \uD835\uDCED\uD835\uDCEE\uD835\uDCF9\uD835\uDCEA\uD835\uDCFB\uD835\uDCFD\uD835\uDCF6\uD835\uDCEE\uD835\uDCF7\uD835\uDCFD \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("================================================================");
            break;
        }
    }
}
@Test(dependsOnMethods = {"HRdepartment"})
void AccountInfo() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    WebElement contactTab = driver.findElement(By.linkText("Account Information"));
    Actions actions = new Actions(driver);
    Thread.sleep(2000);
    actions.moveToElement(contactTab).click().perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='v-pills-Account-information']/nav/span")));
    System.out.println("----------------------------------------------------------------");
    log.info("----------------------------------------------------------------");
    WebElement Account_Information = driver.findElement(By.linkText("Account Information"));
    System.out.println(Account_Information.getText());
    log.info(Account_Information.getText());
    System.out.println("----------------------------------------------------------------");
    log.info("----------------------------------------------------------------");
    List<WebElement> account = driver.findElements(By.xpath("(//div[@class='row'])[17]//strong"));
    List<WebElement> accounttValue = driver.findElements(By.xpath("(//div[@class='row'])[17]//a"));
    int size=Math.min(account.size(),accounttValue.size());
    for (int i = 0; i < size; i++) {
        String Acc=account.get(i).getText();
        String AccValue=accounttValue.get(i).getText();
        System.out.println(Acc+" "+AccValue);
        log.info(Acc+" "+AccValue);
        if (AccValue.contains("null")||AccValue.equalsIgnoreCase("null")){
            log.info("================================================================");
            System.out.println("꧁༒☬\uD835\uDCD0\uD835\uDCEC\uD835\uDCEC\uD835\uDCF8\uD835\uDCFE\uD835\uDCF7\uD835\uDCFD \uD835\uDCD8\uD835\uDCF7\uD835\uDCEF\uD835\uDCF8\uD835\uDCFB\uD835\uDCF6\uD835\uDCEA\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7 \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("꧁༒☬\uD835\uDCD0\uD835\uDCEC\uD835\uDCEC\uD835\uDCF8\uD835\uDCFE\uD835\uDCF7\uD835\uDCFD \uD835\uDCD8\uD835\uDCF7\uD835\uDCEF\uD835\uDCF8\uD835\uDCFB\uD835\uDCF6\uD835\uDCEA\uD835\uDCFD\uD835\uDCF2\uD835\uDCF8\uD835\uDCF7 \uD835\uDCF1\uD835\uDCEA\uD835\uDCFF\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD835\uDCDD\uD835\uDCFE\uD835\uDCF5\uD835\uDCF5☬༒꧂");
            log.info("================================================================");
            break;
        }
    }
}
@AfterClass
void logout(){
    driver.navigate().to("http://216.48.191.170/budgie_test/public/index.php/logout");
}
}

