package modules.generic

import geb.Module

class CookiesUsageNotification extends Module {

    static base = { $("div#p_p_id_notifications_WAR_dtportalwar_INSTANCE_V000_") }

    static content = {
       String cookies_notification_text = { $("div", class:'main__pi-notification')}.text()
       confirmationButton { $('div',class:'pi-icon jsConfirmCookies') }

    }

    def clickConfirmationButton(){
        confirmationButton.click()
        assert !this.displayed
        return browser.page
    }

}

