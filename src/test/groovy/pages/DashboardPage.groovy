package pages

import geb.Module
import geb.Page
import pages.prototype.zeroLevelPortalPage

class DashboardPage  extends zeroLevelPortalPage{
    static url = '/dashboard'

    static at = {
        waitFor(40){ dashboardContent}
        title == 'Dashboard'
        dashboardName == 'Branches'
    }

    static content = {
        //Anchors

        dashboardName { branchDashboard.find('.dashboard__name').text() }

        branchDashboard  { $('div#p_p_id_branchDashboard_WAR_dtportalwar_') }
            dashboardContent {branchDashboard.find('.dashboard__content')}
                branchContainers(required: false)  {  dashboardContent.find('.branch-container').moduleList( DashBranchCard )  }

        wizardPopup { $('div#p_p_id_profileConfiguration_WAR_dtportalwar_').$('.jsWizardPopup') }




    }

}



class DashBranchCard extends Module {

    static content = {
        //Parameters
        siteID { getAttribute('data-sessionlogin') }

        nc_objectID { getAttribute('data-id') }

        branchName { find('.branch__header_name').text() }

        //Available Services
        branchSettings { find('span.service__label', text: startsWith('Branch settings')) }

        trafficManagement { find('span.service__label', text: startsWith('Traffic Management')) }

        vpn { find('span.service__label', text: startsWith('VPN')) }

        wifiSettings { find('span.service__label', text: startsWith('Wi-Fi settings')) }

        //Profiles
        defaultProfile(required: false) {
            find('div.profile').has('span', class: 'profile__name', text: startsWith('Default'))
        }

        secondProfile(required: false) { find('div.profile', title: 'Create new profile for this branch')[0] }

        thirdProfile(required: false) { find('div.profile', title: 'Create new profile for this branch')[1] }


    }


    Page clickBranchSettings() {
        branchSettings.click()
        return browser.page
    }

    Page clickTrafficManagement() {
        trafficManagement.click()
        return browser.page
    }

}