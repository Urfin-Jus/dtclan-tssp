package modules.branch.mutual

import geb.Module
import org.openqa.selenium.By

class Sidebar extends Module{
    static base = { $('div.sidebar')}

    static content = {
        //SlideBar: Devices, Branch Settings, Services

        devicesConnectedItem { find(By.xpath('//div[@data-event-name="showBranchDevices"]')) }  //find('div.sidebar-group.sidebar-group-item.jsMenuGroupItm') }

        //Branch Settings Menu: DCHP Setting, Access from Internet, Profile Priority, DynDNS, Antispam
        branchSettingsMenuItem { find('div.sidebar-group__name.jsItemGroup.taControl.jssettings') }
        generalSidebarGroupItem { branchSettingsMenuItem.next().find('a',text: 'General') }
        dhcpSettingsGroupItem { branchSettingsMenuItem.next().find('a',text: 'DHCP settings') }
        accessFromInternetGroupItem { branchSettingsMenuItem.next().find('a',text: 'Access from internet') }
        profilePriorityGroupItem { branchSettingsMenuItem.next().find('a',text: 'Profile priority') }
        dynDNS { branchSettingsMenuItem.next().find('a',text: 'DynDNS') }
        antispam { branchSettingsMenuItem.next().find('a',text: 'Antispam') }


        //Services Menu
        servicesMenuItem  { find('div.div.sidebar-group__name.jsItemGroup.taControl.jsservices')}



    }


}
