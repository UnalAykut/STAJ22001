
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AmazonTest {
    private WebDriver driver;
    private Assertion assertion = new Assertion();
    private String expectedData;
    private String actualData;
    private String email = "";
    private String password = "";
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;
    @FindBy(id = "nav-search-submit-button")
    private WebElement submitButton;
    @FindBy(id = "nav-link-accountList")
    private WebElement loginAccountListButton;
    @FindBy(id = "nav-cart")
    private WebElement cartButton;
    @FindBy(id = "searchDropdownBox")
    private WebElement categoryDropdown;
    @FindBy(id = "sp-cc-accept")
    private WebElement acceptCookie;
    @FindBy(id = "ap_email")
    private WebElement emailInput;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "auth-email-missing-alert")
    private WebElement emailMessage;
    @FindBy(css = "body.auth-no-skin.ap-locale-tr_TR.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-section.a-padding-medium.auth-workflow:nth-child(2) div.a-section:nth-child(2) div.a-section div.a-section.a-spacing-base.auth-pagelet-container:nth-child(1) div.a-section div.a-box.a-alert.a-alert-error.auth-server-side-message-box.a-spacing-base:nth-child(1) div.a-box-inner.a-alert-container div.a-alert-content ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-none li:nth-child(1) > span.a-list-item")
    private WebElement wrongEmailMessage;
    @FindBy(id = "ap_password")
    private WebElement passwordInput;
    @FindBy(id = "signInSubmit")
    private WebElement loginButton;
    @FindBy(css = "body.auth-no-skin.ap-locale-tr_TR.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-section.a-padding-medium.auth-workflow:nth-child(2) div.a-section:nth-child(2) div.a-section div.a-section.auth-pagelet-container:nth-child(2) div.a-section.a-spacing-base div.a-box:nth-child(2) div.a-box-inner.a-padding-extra-large form.auth-validate-form.auth-real-time-validation.a-spacing-none div.a-section:nth-child(7) div.a-section.a-spacing-large:nth-child(3) div.a-box.a-alert-inline.a-alert-inline-error.auth-inlined-error-message.a-spacing-top-mini:nth-child(4) div.a-box-inner.a-alert-container > div.a-alert-content")
    private WebElement emptyPasswordMessage;
    @FindBy(css = "body.auth-no-skin.ap-locale-tr_TR.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-section.a-padding-medium.auth-workflow:nth-child(2) div.a-section:nth-child(2) div.a-section div.a-section.a-spacing-base.auth-pagelet-container:nth-child(1) div.a-section div.a-box.a-alert.a-alert-error.auth-server-side-message-box.a-spacing-base:nth-child(1) div.a-box-inner.a-alert-container div.a-alert-content ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-none li:nth-child(1) > span.a-list-item")
    private WebElement wrongPasswordMessage;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
    @Test(priority = 0)
    public void emptyEmailLoginTest() throws InterruptedException {
        expectedData = "E-posta adresinizi veya cep telefonu numaranızı girin";
        loginAccountListButton.click();
        emailInput.sendKeys(email);
        continueButton.click();
        actualData = emailMessage.getText();
        driver.navigate().refresh();
        assertion.assertEquals(actualData, expectedData);
    }
    @Test(priority = 1)
    public void wrongEmailLoginTest() throws InterruptedException {
        expectedData = "Bu e-posta adresiyle bir hesap bulamıyoruz";
        email = "asafa@gmail.com";
        emailInput.sendKeys(email);
        continueButton.click();
        actualData = wrongEmailMessage.getText();
        assertion.assertEquals(actualData, expectedData);
        emailInput.clear();
    }
    @Test(priority = 2)
    public void trueEmailLoginTest() throws InterruptedException {
        expectedData = "Bu e-posta adresiyle bir hesap bulamıyoruz";
        email = ""; // kendi emailinizi girip deneyebilirsiniz
        emailInput.sendKeys(email);
        continueButton.click();
    }
    @Test(priority = 3)
    public void emptyPasswordLoginTest() throws InterruptedException {
        expectedData = "Şifrenizi girin";
        passwordInput.sendKeys(password);
        loginButton.click();
        actualData = emptyPasswordMessage.getText();
        assertion.assertEquals(actualData, expectedData);
        driver.navigate().refresh();
    }
    @Test(priority = 4)
    public void wrongPasswordLoginTest() throws InterruptedException {
        expectedData = "Şifreniz yanlış";
        password = "asasdasa@?0";
        passwordInput.sendKeys(password);
        loginButton.click();
        actualData = wrongPasswordMessage.getText();
        assertion.assertEquals(actualData, expectedData);
        passwordInput.clear();
    }
    @Test(priority = 5)
    public void trueLoginTest() throws InterruptedException {
        password = ""; // kendi şifrenizi girip deneyebilirsiniz
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    // Tarayıcıyı kapatmak için kullanabilirsiniz
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

