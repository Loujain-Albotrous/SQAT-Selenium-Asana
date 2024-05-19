import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HomePage extends PageBase {
    By createTaskLoc = new By.ByXPath("//div[@class='MyTasksWidgetContent-container']//div[@role='button']");
    By taskMenuLoc = new By.ByXPath("//div[@class='MenuStructure Omnibutton-menu ActionMenu' and @role = 'menu']");
    By taskOptionLoc = new By.ByXPath("//span[@class='TypographyPresentation TypographyPresentation--overflowTruncate TypographyPresentation--m LeftIconItemStructure-label']");
    By taskNameLoc = new By.ByXPath("//textarea[@aria-label='Task Name']");

    By srcLoc = new By.ByXPath("//div[@class='ThemeableCardPresentation--isValid ThemeableCardPresentation ThemeableInteractiveCardPresentation--isNotSelected ThemeableInteractiveCardPresentation--isEnabled ThemeableInteractiveCardPresentation ThemeableDraggableCardPresentation--isNotClickable ThemeableDraggableCardPresentation--default ThemeableDraggableCardPresentation DraggableCard HomeCard PeopleGridWidget']");
    By destLoc = new By.ByXPath("//div[@class='CustomizableHomePage-widget CustomizableHomePage-widgetSize--small CustomizableHomePage-widgetSize--smallDomainUserHomeGoalsWidget SortableList-sortableItemContainer']");

    By menuBtnLoc =   new By.ByXPath("//div[@class='GlobalTopbarStructure-rightChildren GlobalTopbarStructure-noDrag'][1]//div[2]");
    By profileBtnLoc =   new By.ByXPath("//div[@class='GlobalTopbarUserMenu'][1]//div[1]//div[5]");
//    By picUploadBtnLoc =   new By.ByXPath("//input[@class='AvatarPhotoUpload-hiddenFileInput']");
    By picUploadBtnLoc =   new By.ByXPath("//div[@role='button' and @aria-label='Upload new photo']");


    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        super(driver);
        //   this.driver.get("https://app.asana.com/0/home/1207335206141552");
        LoginPage loginPage = new LoginPage(driver);
        this.driver = loginPage.userLogin();
    }




    public void createTask(String taskName){
        waitAndReturnElement(createTaskLoc).click();
        waitAndReturnElement(taskMenuLoc).click();
        waitAndReturnElement(taskOptionLoc).click();
        waitAndReturnElement(taskNameLoc).sendKeys(taskName);
    }

    public void dragAndDrop(){
        Actions actions = new Actions(driver);
        WebElement src = waitAndReturnElement(srcLoc);

        WebElement dest = waitAndReturnElement(destLoc);
        actions.dragAndDrop(src,dest).build().perform();

    }



}
