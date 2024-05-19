import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;


public class SelenuimTest {

    WebDriver driver;
    private WebDriverWait wait;

    By userSettingsLoc =   new By.ByXPath("//div[@aria-label='User settings']");
    By menuBtnLoc =   new By.ByXPath("//div[@class='GlobalTopbarStructure-rightChildren GlobalTopbarStructure-noDrag'][1]//div[2]");
//    By menuBtnLoc =   new By.ByXPath("//div[@role='button' and @aria-label='User settings']");
    By profileBtnLoc =   new By.ByXPath("//span[contains(text(),'Profile')]");
    By editProfileLoc =   new By.ByXPath("//div[@role='button' and contains(text(),'Edit profile')]");
    By displayBtnLoc =   new By.ByXPath("//div[@role='dialog']//div[@aria-label='Settings']//div[7]");


    By taskdrpLoc =   new By.ByXPath("//div[@class='PrimarySplitDropdownMenuButtonA11y AddTaskDropdownButton']//div[2]");
    By myTasksBtnLoc =   new By.ByXPath("//span[contains(text(),'My tasks')]");


    By srcLoc = new By.ByXPath("//div[@class='PeopleGridWidgetContent']");
    By destLoc = new By.ByXPath("//div[@class='CustomizableHomePage-widget CustomizableHomePage-widgetSize--small CustomizableHomePage-widgetSize--smallDomainUserHomeGoalsWidget SortableList-sortableItemContainer']");

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Loujain\\Desktop\\Apps\\EdgeDriver\\msedgedriver.exe");
        driver = new EdgeDriver();
        this.wait = new WebDriverWait(driver, 30);
    }
    //user log in test with correct credentials successfully
    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        String res =  loginPage.userLoginE().getText();
        Assert.assertTrue(  res.equals("Good afternoon, Loujain")||
                        res.equals("Good evening, Loujain")||
                        res.equals("Good morning, Loujain")
                );
    }

    //user log out successfully
    @Test
    public void successfulLogoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        String res = loginPage.userLogOut().getText();
        Assert.assertTrue( res.equals("To get started, please sign in"));
    }

    //read page title
    @Test
    public  void getLoginPageTitle() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue((loginPage.getPageTitle().equals("Log in - Asana")));
    }
// @Test
//    public  void testHomePage() {
//     this.driver.get("https://app.asana.com/0/home/1207335206141552");
//     driver.manage().window().maximize();
//     LoginPage loginPage = new LoginPage(driver);
//     WebDriver wdr =  loginPage.userLogin();
//     this.wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtnLoc));
//        WebElement menuBtn = this.driver.findElement(menuBtnLoc);
//        menuBtn.click();
//
//        this.wait.until(ExpectedConditions.visibilityOfElementLocated(profileBtnLoc));
//        WebElement profileBtn = this.driver.findElement(profileBtnLoc);
//        profileBtn.click();
//
//        this.wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileLoc));
//        WebElement editProfileBtn = this.driver.findElement(editProfileLoc);
//        editProfileBtn.click();
//
//        Set<String> handles = driver.getWindowHandles();
//        String currentHandle = driver.getWindowHandle();
//        System.out.println(handles.size());
//        for (String handle : handles) {
//            System.out.println("i am in "+handle);
//            System.out.println("i am in "+currentHandle);
//
//            if (!handle.equals(currentHandle)) {
//                driver.switchTo().window(handle);
//            }
//        }
//     System.out.println(driver.getWindowHandle());
//        this.wait.until(ExpectedConditions.visibilityOfElementLocated(displayBtnLoc));
//        WebElement displayBtn = this.driver.findElement(displayBtnLoc);
//        displayBtn.click();
//
//        this.wait.until(ExpectedConditions.visibilityOfElementLocated(lgInTxtLoc));
////     Assert.assertTrue(homeTxt != null);
//
//    }
    @Test
   public void createTaskTest() throws InterruptedException {
       Task task = new Task(driver);
       task.createTask();
   }
    //static page test
@Test
   public void openNewProjectTest() throws InterruptedException {
       Project project = new Project(driver);
       String res = project.openCreateNewProjectPage().getText();
       Assert.assertTrue(res.equals("Create a new project"));
   }
//send form with user
   @Test
   public void createNewProjectTest() throws InterruptedException {
       Project project = new Project(driver);
       project.createNewProject();
//       Assert.assertTrue(homePage.openCreateNewProjectPage() != null);
   }

    @Test
    public  void dragAndDropTest() {
        HomePage homePage = new HomePage(driver);
//        WebElement src = waitAndReturnElement(srcLoc);
//
//        WebElement dest = waitAndReturnElement(destLoc);
//
//        Point srcOldLocation = src.getLocation();
//        Point destOldLocation = dest.getLocation();


        homePage.dragAndDrop();

//        src = waitAndReturnElement(srcLoc);
//        dest = waitAndReturnElement(destLoc);
//
//        Point srcNewLocation = src.getLocation();
//        Point destNewLocation = dest.getLocation();
//
//        Assert.assertEquals(destNewLocation ,srcOldLocation );
//        Assert.assertEquals(srcNewLocation, destOldLocation);
    }



    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
