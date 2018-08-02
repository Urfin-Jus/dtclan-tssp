package pages

import configuration.TSSPbasementPage

class VpnPage extends TSSPbasementPage{
    static url = '/vpn'

    static at = { title == 'VPN'}

    static content = {
        vpnNavigator    { portletColumn1.$('#p_p_id_vpnNavigation_WAR_dtportalwar_') }

        vpnTab  { portletColumn1.$('data-tab':'vpnTab')}

        vpnQosTab { portletColumn1.$('data-tab':'vpnQosTab') }
    }



}
