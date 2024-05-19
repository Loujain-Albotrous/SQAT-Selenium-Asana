import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
    By lgoutBtnLoc = new By.ByXPath("//span[contains(text(),'Log out')]");
    By sgnTxtLoc = new By.ByXPath("//div[@class='LoginCardLayout-card--content'][1]//span");
    By lgInTxtLoc = new By.ByXPath("//div[@class='HomePageContent-content'][1]//span[2]");
    By privacyBtnLoc = new By.ById("onetrust-accept-btn-handler");
    By userNameLoc = new By.ByName("e");
    By passwordLoc = new By.ByName("p");
    By userSettingsLoc = new By.ByXPath("//div[@aria-label='User settings']");

    public  LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://app.asana.com/-/login");
    }

    public  LoginPage() {}
    private void privacyMsgApprove(){
        WebElement privacyBtn = waitAndReturnElement(privacyBtnLoc);
        privacyBtn.click();
    }

    public void fillLoginInfo() {
        WebElement userName = waitAndReturnElement(userNameLoc);
        userName.sendKeys("loujainalbotrous@gmail.com\n");

        WebElement password = waitAndReturnElement(passwordLoc);
        password.sendKeys("loujain@1998\n");
    }
    public WebDriver userLogin(){

        privacyMsgApprove();

        fillLoginInfo();
        return  this.driver;
    }
    public WebElement userLoginE(){

        privacyMsgApprove();

        fillLoginInfo();

        return  waitAndReturnElement(lgInTxtLoc);
    }


    public  WebElement userLogOut(){
        privacyMsgApprove();

        fillLoginInfo();


        WebElement userSettingsBtn = waitAndReturnElement(userSettingsLoc);

        userSettingsBtn.click();

        WebElement logoutBtn = waitAndReturnElement(lgoutBtnLoc);
        logoutBtn.click();

       return waitAndReturnElement(sgnTxtLoc);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
