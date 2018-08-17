package Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {

    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    @FindBy(id="btnLogin")
    private WebElement Login;

    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    private WebElement pimTab;

    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    private WebElement addEmployee;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[1]/div/sf-decorator/div/sf-decorator[1]/div/span")
    private WebElement missingField;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement addEmployeeLogin;

    @FindBy(id = "username")
    private WebElement CreateUsername;

    @FindBy(id = "password")
    private WebElement CreatePassword;

    @FindBy(id = "confirmPassword")
    private WebElement CreateConfirmPassword;

    @FindBy(xpath = "//*[@id=\"status_inputfileddiv\"]/div/input")
    private WebElement status;

    @FindBy(xpath ="//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    private WebElement adminRole;

    @FindBy(id = "systemUserSaveBtn")
    private WebElement saveLogin;

    @FindBy(xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")
    private  WebElement employeeList;

    @FindBy(id="employee_name_quick_filter_employee_list_value")
    private  WebElement searchEmployee;

    @FindBy(id="quick_search_icon")
    private WebElement clickSearch;

    @FindBy(xpath ="//*[@id=\"employee_name_quick_filter_employee_list_dropdown\"]/div[2]")
    private WebElement searchResults;

    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
    private WebElement chooseEmployee;


    public void loginAdmin(String AdminUsername, String AdminPassword){

        username.sendKeys(AdminUsername);
        password.sendKeys(AdminPassword);
        Login.click();

    }
    public void clickPimTab() {
        pimTab.click();
    }

    public void clickAddEmployeeTab(){
       addEmployee.click();
    }

    public void addEmployee(String EmployeeName, String EmployeeMiddleName, String EmployeeLastName, String EmployeeLocation){
        firstName.sendKeys(EmployeeName);
        middleName.sendKeys(EmployeeMiddleName);
        lastName.sendKeys(EmployeeLastName);
        location.sendKeys(EmployeeLocation);
    }

    public boolean checkIfAddEmployeeComplete(){
        if(!missingField.getText().contains("Required")){
            return  true;
        }
        return false;
    }
    public void clickCreateEmployeeLogin(){
        addEmployeeLogin.click();
    }
    public void createEmployeeLogin(String username, String password, String confirmPassword, String role){
        CreateUsername.sendKeys(username);
        CreatePassword.sendKeys(password);
        CreateConfirmPassword.sendKeys(confirmPassword);
        adminRole.sendKeys(role);

    }

    public void saveEmployeeLogin() {
        saveLogin.click();

    }

        public boolean checkIfEmployeeLoginCreated(){
        if(!missingField.getText().contains("Required")){
            return  true;
        }
        return false;
    }
}
