package pages.login

import configuration.Properties
import geb.Page
import pages.login.LoginConfirmationPage

import static configuration.Properties.tssp_base_url

class LoginFormPage extends Page {

    static url = Properties.tssp_base_url

    static at = {
            title == "OpenAM"
            waitFor{ loginForm.isDisplayed()}
        }


    static content = {
          loginForm { $('fieldset', class: 'row') }
          userNameField {$("#idToken1") }
          userPasswordField {$("#idToken2") }
          loginInButton(to: LoginConfirmationPage) {$("#loginButton_0") }
    }

    LoginConfirmationPage  clickLoginButton(String usr, String pswd){
        userNameField.value(usr)
        userPasswordField.value(pswd)
        loginInButton.click()

        return browser.page
    }
}