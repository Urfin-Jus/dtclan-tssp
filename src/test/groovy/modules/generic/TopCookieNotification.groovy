package modules.generic

import geb.Module

class TopCookieNotification extends Module {

    static base = { find("div#p_p_id_notifications_WAR_dtportalwar_INSTANCE_V000_").find('div.jsCookieTopNotificationContainer') }

    static content = {
        String cookies_notification_text = { find('div.main__pi-notification').text() }
        confirmationButton { $('div.pi-icon.jsConfirmCookies') }

    }

    def isCookieNotificationShown(){
        this.displayed
    }

    def clickConfirmationButton(){
        confirmationButton.click()
        assert !this.displayed
        return browser.page
    }
}
