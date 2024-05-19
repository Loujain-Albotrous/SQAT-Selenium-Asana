import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project extends PageBase {
    HomePage homePage;
    By newProjectLoc = new By.ByXPath("//a[@href='https://app.asana.com/0/projects/new']");
    By newProjectTxtLoc = new By.ByXPath("//div[@class='ProjectCreationFlowPicker-titles'][1]//h2");
    By createNewProjectBtnLoc = new By.ByXPath("//div[@class='TileStructure-children'][1]//div");
    By NewProjectNameLoc = new By.ByXPath("//div[@class='FormRowStructure-contents'][1]//input");
    By privacyLoc = new By.ByXPath("//div[@class='PrivacyDropdown-contents'][1]//div");
    By myWorkspaceOptionLoc = new By.ByXPath("//div[@class='LeftIconItemStructure LeftIconItemStructure--alignTop'][1]//span[2]");
    By createProjectLoc = new By.ByXPath("//div[@class='PotSetupFormStructure-submitButton'][1]//div");

    public Project(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public WebElement openCreateNewProjectPage() {
        WebElement createNewProjectBtn = waitAndReturnElement(newProjectLoc);
        createNewProjectBtn.click();
        return waitAndReturnElement(newProjectTxtLoc);
    }

    public void createNewProject() {
        openCreateNewProjectPage();

        waitAndReturnElement(createNewProjectBtnLoc).click();

        //project name form
        waitAndReturnElement(NewProjectNameLoc).sendKeys("Selenium Project\n");

        //choose privacy from a drop down list
        waitAndReturnElement(privacyLoc).click();
        waitAndReturnElement(myWorkspaceOptionLoc).click();

        //create project button click
        waitAndReturnElement(createProjectLoc).click();
    }

}
