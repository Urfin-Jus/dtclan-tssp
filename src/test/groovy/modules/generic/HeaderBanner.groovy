package modules.generic

import geb.Module
import pages.login.LogoutPage
import pages.*

class HeaderBanner extends Module{

    static base = { find('header#banner') }

    static content = {
        //Anchors
        navigationMenuBar { find('div#p_p_id_navigationmenu_WAR_dtportalwar_INSTANCE_V000_') }
        taskProgressBar  { find('div#p_p_id_tasks_WAR_dtportalwar_INSTANCE_V000_') }
        profileBlock  { find('div#p_p_id_profilemenu_WAR_dtportalwar_INSTANCE_V000_') }


        //Views
        ProcessedOrderList { find('div.header-tasks__body') }

        //Buttons
        logoutButton(to:LogoutPage) { profileBlock.find('span.header__login_logout-icon') }

        DashboardTab(to: DashboardPage) { navigationMenuBar.find('div.dt-tabs__link', text: startsWith('Dashboard'))}

        AntivirusTab(required: false, to: AntivirusPage) { navigationMenuBar.find('div.dt-tabs__link',text: startsWith('Antivirus'))}

        VpnTab(required: false, to: VpnPage) { navigationMenuBar.find('div.dt-tabs__link',text: startsWith('Antivirus'))}

        TaskCircleIcon {taskProgressBar.find('div.tasks-icon')}
    }

    def logOutFromPortal(){
        logoutButton.click()
        return browser.page
    }

    def goToDashboard(){
        DashboardTab.click()
        return browser.page
    }

    def goToAntivirus(){
        AntivirusTab.click()
        return browser.page
    }

    def goToVPN(){
        VpnTab.click()
        return browser.page
    }

    def clickTaskCircleIcon(){
        TaskCircleIcon.click()
    }

    def isOrderListShown(){
        ProcessedOrderList.displayed
    }
}
