package pages.prototype

import geb.Page
import modules.generic.*

class zeroLevelPortalPage extends Page{

    static content = {
        Banner  { module(HeaderBanner) }

        CookieNotificaton(required:false) { module( TopCookieNotification ) }

        MainContext { }

        OrderCompletionNotification(required:false) { module( LowOrderCompletionNotification ) }

        Footer { module(BottomFooter) }

    }

}
