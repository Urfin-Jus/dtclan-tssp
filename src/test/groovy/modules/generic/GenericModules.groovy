package modules.generic

import geb.Module
import pages.DashboardPage
import pages.VpnPage
import pages.login.LogoutPage
import pages.AntivirusPage
import geb.module.Checkbox

class Banner extends Module{
    static base = { $('#banner') }

    static content = {
        navigationBar { $(class:'dt-portal-block-navigation') }
        taskProgress  { $(class:'dt-portal-block-task') }
        profileBlock  { $(class:'dt-portal-block-profile') }

        logoutButton(to:LogoutPage) { profileBlock.$(href:'/c/portal/logout') }

        toDashboardTab(to: DashboardPage) { navigationBar.$(class:'dt-tabs__link taLabel',text: startsWith('Dashboard'))}

        toAntivirusTab(required: false, to: AntivirusPage) { navigationBar.$(class:'dt-tabs__link taLabel',text: startsWith('Antivirus'))}

        toVpnTab(required: false, to: VpnPage) { navigationBar.$(class:'dt-tabs__link taLabel',text: startsWith('Antivirus'))}

    }
}

class MainContent extends Module{
    static base = { $('#main-content') }

    static content = {

        portletColumn1 { $('#column-1') }
        portletColumn2 { $('#column-2') }

        breadscrumbsNavigator { portletColumn1.$('#p_p_id_breadcrumbs_WAR_dtportalwar_') }

    }

}

class Footer extends Module{
    static base = { $('#footer') }
    static content = {
       innerFooter { $(class:'dt-page-footer') }

    }
}

class Search extends Module {

   static base = { $(class:'search form-text _inline-block _small')}

   static content = {

        searchField { $('input',class:'taInput search-row__input _field jsSearchInput') }

   }
}


class ServiceActivationSlider extends Module {
    static base = { find('.switcher__outer.service-activation')}

    static content = {
        switcher { find('label.switcher  ')}

        checkbox { switcher.find('input.switcher__input',type:'checkbox').module(Checkbox) }

        checked   { checkbox.checked }
        unchecked { checkbox.unchecked }
    }

    def turnON(){
        if(checkbox.unchecked) switcher.click()
        else return true

    }

    def turnOFF(){
        if(checkbox.checked) switcher.click()
        else return true
    }


}