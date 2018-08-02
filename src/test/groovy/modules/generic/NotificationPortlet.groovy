package modules.generic

import geb.Module

class NotificationPortlet extends Module {

    static base = { $("#p_p_id_notifications_WAR_dtportalwar_INSTANCE_V000_") }

    static content = {
       //Anchors
        topCoockieNotification { find('div.jsCookieTopNotificationContainer') }

        centerPopupNotification { find('div.jsMessagePopupContainer') }

        lowPanelNotification  { find('div.jsNotificationPanelContainer') }

      //Cookies Notification
       // cookies_notification_text(required: false )  { topCoockieNotification.find("div", class:'main__pi-notification')}.text()
       confirmationButton { topCoockieNotification.find('div.jsConfirmCookies') }


      //Order Completion Notification
       inventoryUpdateNotification(required:false) { lowPanelNotification.find('div.jsNotificationInventoryUpdate')}

            completedOrders(required: false) { inventoryUpdateNotification.find('span.complete-orders-notification') }
            refreshButton(required: false)   { inventoryUpdateNotification.find('button.jsApplyUpdateButton') }


    }



}

