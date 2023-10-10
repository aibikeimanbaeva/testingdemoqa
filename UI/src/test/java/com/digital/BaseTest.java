package com.digital;

import com.digital.driver.Driver;
import com.digital.pages.*;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    public DraggablePage draggablePage;
    public DroppablePage droppablePage;
    public ResizblePage resizblePage;
    public SelectablePage selectablePage;
    public SortablePage sortablePage;

    public SelectMenuPage selectMenuPage;

    public AutoCompletePage autoCompletePage;
    public AccordianPage accordianPage;

    public ModalDialogsPage modalDialogsPage;

    public WebDriver driver;

    public WebTablesPage webTablesPage;
    public AlertPage alertsPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public ButtonPage buttonPage;
    public CheckBoxPage checkBoxPage;
    public FramePage framePage;

    public LinksPage linksPage;

    public PracticeFormPage practiceFormPage;
    public FakeDataProvider fakeDataProvider;

    public RadioButtonPage radioButtonPage;
    public RegisterPage loginPage;

    public TextBoxPage textBoxPage;

    public UploadFilePage uploadFilePage;

    public BrowserWindowPage browserWindowPage;

    public NestedFramesPage nestedFramesPage;

    public SliderPage sliderPage;

    public ProgressBarPage progressBarPage;
    public TabsPage tabsPage;

    public ToolTipsPage toolTipsPage;

    public MenuPage menuPage;
    public DatePickerPage datePickerPage;

    @BeforeClass(alwaysRun = true)
    public void setUpBrowser() {
        driver = Driver.getDriver();
        selectMenuPage = new SelectMenuPage();
        alertsPage = new AlertPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        buttonPage = new ButtonPage();
        checkBoxPage = new CheckBoxPage();
        framePage = new FramePage();
        linksPage = new LinksPage();
        practiceFormPage = new PracticeFormPage();
        fakeDataProvider = new FakeDataProvider();
        radioButtonPage = new RadioButtonPage();
        loginPage = new RegisterPage();
        textBoxPage = new TextBoxPage();
        uploadFilePage = new UploadFilePage();
        webTablesPage = new WebTablesPage();
        browserWindowPage = new BrowserWindowPage();
        nestedFramesPage = new NestedFramesPage();
        modalDialogsPage = new ModalDialogsPage();
        accordianPage = new AccordianPage();
        autoCompletePage = new AutoCompletePage();
        sliderPage = new SliderPage();
        progressBarPage = new ProgressBarPage();
        tabsPage = new TabsPage();
        toolTipsPage = new ToolTipsPage();
        menuPage = new MenuPage();
        sortablePage = new SortablePage();
        selectablePage = new SelectablePage();
        resizblePage = new ResizblePage();
        droppablePage = new DroppablePage();
        draggablePage = new DraggablePage();
        datePickerPage = new DatePickerPage();

    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        Driver.closeDriver();
//    }

}
