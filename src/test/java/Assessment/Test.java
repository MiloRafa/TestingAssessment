package Assessment;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Test {
    private WebDriver driver;
    private static ExtentReports report;
    public ExtentTest test;

    Index page;
    String AdminUsername;
    String AdminPassword;

    String EmployeeName;
    String EmployeeMiddleName;
    String EmployeeLastName;
    String EmployeeLocation;

    String username;
    String password;
    String confirmPassword;
    String role;



    @Before
    public void setUp() throws Exception {
        report = new
                ExtentReports("C:\\Users\\Admin\\Desktop\\TestingAssessment\\Reports.html");

        //set properties of driver
        System.setProperty("webdriver.chrome.driver", "C:\\Development\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //timeout driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //maximise window
        driver.manage().window().maximize();

        page = PageFactory.initElements(driver, Index.class);

        driver.get(Constant.url);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        report.endTest(test);
        report.flush();

    }


    @Given("^the login page$")
    public void the_login_page() throws Throwable {
        driver.get(Constant.url);


    }

    @When("^I login$")
    public void i_login() throws Throwable {
        test = report.startTest("Admin Logged in");

        AdminUsername ="Admin";
        AdminPassword ="AdminAdmin";
        page.loginAdmin(AdminUsername,AdminPassword);

        test.log(LogStatus.PASS,"Admin logged in successfully");

    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() throws Throwable {
        test = report.startTest("PIM tab selected");

        driver.get(Constant.dashboard);
        page.clickPimTab();

        test.log(LogStatus.PASS,"PIM tab selected successfully");

    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws Throwable {
        test = report.startTest("Employee tab selected");
        driver.get(Constant.dashboard);
        page.clickAddEmployeeTab();
        test.log(LogStatus.PASS,"Employee tab selected successfully");


    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() throws Throwable {
        test = report.startTest("Employee details added");

        EmployeeName = "Maryam";
        EmployeeMiddleName = "Rafa";
        EmployeeLastName = "Anwar";
        EmployeeLocation = "Australian Regional HQ";

        page.addEmployee(EmployeeName, EmployeeMiddleName,EmployeeLastName, EmployeeLocation);

        if(page.checkIfAddEmployeeComplete()) {
            test.log(LogStatus.PASS,"Employee details entered");
        }
        else{
            test.log(LogStatus.FAIL, "Employee details not entered");
        }
        TestCase.assertTrue(page.checkIfAddEmployeeComplete());


    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws Throwable {
        test = report.startTest("Choose to create login for employee");

        page.clickCreateEmployeeLogin();

        test.log(LogStatus.PASS,"Choose to create employee login successfully");


    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws Throwable {
        test = report.startTest("Employee Login details entered");

        username = "helloEm";
        password = "Pa$$w0rd";
        confirmPassword = "Pa$$w0rd";
        role = "Global Admin";

        page.createEmployeeLogin(username, password, confirmPassword, role);
        test.log(LogStatus.PASS,"Employee login detailed entered successfully");




    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        test = report.startTest("Employee Login created");
        page.saveEmployeeLogin();
        page.checkIfEmployeeLoginCreated();

        test.log(LogStatus.PASS,"Employee login created successfully");
        TestCase.assertTrue(page.checkIfEmployeeLoginCreated());

    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws Throwable {
        test = report.startTest("Search for employee");


    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        test = report.startTest("Select Employee");


    }


}
