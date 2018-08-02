package pages.login

import geb.Page
import pages.DashboardPage
import pages.erroneous.ServiceNotAvailablePage

class LoginConfirmationPage extends Page {
    static at = {
        title == "OpenAM"
        //title == "OAuth2 Authorization Server"
        waitFor { allowButton.isDisplayed() }
    }

    static content = {
        allowButton(to: [DashboardPage, ServiceNotAvailablePage], toWait: true ) { $('button', value: 'allow') }
    }

    DashboardPage clickAllowButton(){
        allowButton.click()
        return browser.page
    }

}