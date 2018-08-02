package pages.erroneous

import geb.Page

class ServiceNotAvailablePage  extends Page {

    static url = "/login-failed?status=serviceUnavailable"
    static at = { title == "Login Failed" && errorMessage.text() == "Service is not available, please try again later." }

    static content = {
        errorMessage  { $('span', class:'main-error__msg') }
        retryButton(to:ServiceNotAvailablePage, toWait: true)  {$('button', type: '"button') }
    }

    ServiceNotAvailablePage clickRetryButton(){
        retryButton.click()
        return browser.page
    }


}
