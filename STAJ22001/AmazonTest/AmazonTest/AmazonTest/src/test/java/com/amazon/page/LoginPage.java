package com.amazon.page;

import com.amazon.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super( driver );
    }
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
    public void inputEmail(String emailText){
        Utils.waitForElementToBeClickable( driver,emailInput ).sendKeys( emailText );
    }

    public void clickContinueButton(){
        Utils.waitForElementToBeClickable( driver,continueButton ).click();
    }

    public String emptyEmailMessage(){
        return Utils.waitForElementToBeVisible( driver,emailMessage ).getText();
    }
    public void inputPassword(String password){
        Utils.waitForElementToBeVisible( driver,passwordInput).sendKeys( password );
    }
    public String wrongEmailMessage(){
        return Utils.waitForElementToBeVisible( driver,wrongEmailMessage ).getText();
    }
    public String emptyPasswordMessage(){
        return Utils.waitForElementToBeVisible( driver,emptyPasswordMessage ).getText();
    }
    public String wrongPasswordMessage(){
        return Utils.waitForElementToBeVisible( driver,wrongPasswordMessage ).getText();
    }
    public void clearEmailInput(){
        Utils.waitForElementToBeVisible( driver,emailInput ).clear();
    }

    public void clearPasswordInput(){
        Utils.waitForElementToBeVisible( driver,passwordInput ).clear();
    }
    public void clickLoginButton(){
        Utils.waitForElementToBeClickable( driver,loginButton ).click();
    }


}
