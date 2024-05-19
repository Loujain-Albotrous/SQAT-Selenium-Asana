import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task extends PageBase {
    By createTaskLoc = new By.ByXPath("//div[@class='MyTasksWidgetContent-container']//div[@role='button']");
//    By taskMenuLoc = new By.ByXPath("//div[@class='MenuStructure Omnibutton-menu ActionMenu' and @role = 'menu']");
//    By taskOptionLoc = new By.ByXPath("//span[@class='TypographyPresentation TypographyPresentation--overflowTruncate TypographyPresentation--m LeftIconItemStructure-label']");
    //    By taskNameLoc =   new By.ByXPath("//input[@placeholder='Task name']");
    By taskNameLoc = new By.ByXPath("//textarea[@aria-label='Task Name']");

    public Task(WebDriver driver) {
        super(driver);
        HomePage homePage = new HomePage(driver);
    }

    public void createTask() {
        WebElement createTaskBtn = waitAndReturnElement(createTaskLoc);
        createTaskBtn.click();

        WebElement taskName = waitAndReturnElement(taskNameLoc);
        taskName.sendKeys("Selenium Task Created\n");
    }
}
