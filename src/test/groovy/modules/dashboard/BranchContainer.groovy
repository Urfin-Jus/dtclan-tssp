package modules.dashboard

import geb.Module
import pages.BranchPage

class BranchContainer extends Module{

    static content = {
        //Parameters
        siteID { getAttribute('data-sessionlogin') }

        nc_objectID { getAttribute('data-id')}
        
        branchName        { find('.branch__header_name').text() }


        //Available Services
        branchSettings(to: BranchPage)    { find('span.service__label', text: startsWith('Branch settings'))  }

        trafficManagement(to: BranchPage) { find('span.service__label', text: startsWith('Traffic Management'))  }

        vpn(required: false)               { find('span.service__label', text: startsWith('VPN'))  }

        wifiSettings      { find('span.service__label', text: startsWith('Wi-Fi settings'))  }


        //Profiles
        defaultProfile(required: false)    { find('div.profile').has('span', class:'profile__name', text: startsWith('Default')) }

        secondProfile(required: false)     { find('div.profile', title: 'Create new profile for this branch')[0] }

        thirdProfile(required: false)      { find('div.profile', title: 'Create new profile for this branch')[1] }




    }


    BranchPage clickBranchSettings(){
        branchSettings.click()
        return browser.page
    }

    BranchPage clickTrafficManagement(){
        trafficManagement.click()
        return browser.page
    }




}