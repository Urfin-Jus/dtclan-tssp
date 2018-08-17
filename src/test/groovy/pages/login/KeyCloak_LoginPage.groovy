package pages.login

import geb.Page
import pages.DashboardPage

import static specs.Properties.*

class KeyCloak_LoginPage extends Page {

    static url = tssp_base_url

    static at = {
            title.contains("Log in to SIT")
        }

    static content = {

          userNameField {$("input#username") }
          userPasswordField {$("input#password") }
          loginInButton(to: DashboardPage) {$("input#kc-login") }
    }

    Page loginWithCredentials(String usr, String pswd){
        userNameField.value(usr)
        userPasswordField.value(pswd)
        loginInButton.click()

        return browser.page
    }
}