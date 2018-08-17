package pages

import pages.prototype.zeroLevelPortalPage

class VpnPage extends zeroLevelPortalPage{
    static url = '/vpn'

    static at = { title == 'VPN'}

    static content = {
        vpnNavigator(required:false)    { portletColumn1.$('#p_p_id_vpnNavigation_WAR_dtportalwar_') }

        vpnTab(required: false)  { portletColumn1.$('data-tab':'vpnTab')}

        vpnQosTab(required: false) { portletColumn1.$('data-tab':'vpnQosTab') }
    }



}
