package pages.login

import geb.Page

class LogoutPage extends Page {

    static at = { title == 'OpenAM' && $('h1').text() == 'You have been logged out.'}

    static content = {
        returnToLoginButton(to: [LoginFormPage, LoginConfirmationPage])  { $(title:'Return to Login Page')  }
    }

}
