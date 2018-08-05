package modules.generic

import geb.Module

class LowOrderCompletionNotification extends Module {

    static base = { find("div#p_p_id_notifications_WAR_dtportalwar_INSTANCE_V000_").find('div.jsNotificationInventoryUpdate') }

    static content = {
        completedOrders(required: false) { find('span.complete-orders-notification') }
        refreshButton(required: false)   { find('button.jsApplyUpdateButton') }
    }

    def refreshInventory(){
        refreshButton.click()
    }



}
