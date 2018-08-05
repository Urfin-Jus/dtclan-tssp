package pages.prototype

import geb.Module


class BranchLevelPortalPage extends zeroLevelPortalPage {

    static content = {
        //Anchors
        upperColumn1  { $('div#column-1')}
        centerColumn2 { $('div#column-2')}
        centerColumn3 { $('div#column-3')}
        lowColumn4    { $('div#column-4')}

        //usage statistic tab
        usageStatTab  { upperColumn1.$('div.main-section__header_nav._tabs .nav__item').filter( text:'Usage statistics')}

        //active view tab
        actualViewTab { upperColumn1.$('div.main-section__header_nav._tabs .nav__item').filter(text: 'Actual view') }

        //branch card with status
        branchInformationContainer { centerColumn2.module( BranchCard ) }

        sideBar{ centerColumn2.module( Sidebar ) }

    }

}

class Sidebar extends Module{

    static base = { find('div.sidebar')}

    static content = {
        //SlideBar: Devices, Branch Settings, Services

        devicesConnectedItem { $('div', 'data-type': "devices") }  //find('div.sidebar-group.sidebar-group-item.jsMenuGroupItm') }

        BranchSettingsItem { $('div','data-type':"settings") }
            ItemGeneral { $('a','data-type': 'general') }
            ItemDhcpSettings { $('a','data-type': 'dhcpConfiguration') }
            ItemAccessFromInternet { $('a','data-type': 'accessFromInternet') }
            ItemProfilePriority { $('a','data-type': 'trafficPriority') }
            ItemDynDNS { $('a','data-type': 'dynDns') }
            ItemAntispam { $('a','data-type': 'antispamService') }

        servicesMenuItem  { $('div','data-type': "services" )}
            ItemWiFi { $('a','data-type':"wifiManagement")}
            ItemVPN { $( 'a','data-type':"wifiManagement") }


    }
}


class BranchCard extends Module{

    static base = { $('div.dashboard__content.jsBranchCard') }

    static content = {
        BranchName  { $('div.branch__header_name.jsBranchName').text() }

        BranchStatus { $('span.status-value.jsStatusText').text() }

        BranchProfileList { $('div.jsProfile.dt-tabs__item') }

        ItemAdultContent { $('div','data-type':"9148227301751037369") }
        ItemFileSharing { $('div','data-type':"9148227308051037842") }
        ItemGaming { $('div','data-type':"9148227306351037637") }
        ItemMultimedia { $('div','data-type':"9148227299151037176") }
        ItemSocialMedia { $('div','data-type':"9148227296151037037") }
        ItemGambling { $('div','data-type':"9148227303751037508") }

    }

    def getProfileCount(){ BranchProfileList.size() }

    def getBranchStatus(){ BranchStatus }

    def getBranchName() { BranchName }

}