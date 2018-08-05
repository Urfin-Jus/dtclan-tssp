package pages

import TSSPbasementPage
import Search
import BranchContainer

class DashboardPage  extends TSSPbasementPage{
    static url = '/dashboard'

    static at = {
        waitFor(40){ dashboardContent}
        title == 'Dashboard'
        dashboardName == 'Branches'
    }

    static content = {

        branchDashboard  { $('div#p_p_id_branchDashboard_WAR_dtportalwar_') }
            dashboardContent {branchDashboard.find('.dashboard__content')}
                branchContainers(required: false)  {  dashboardContent.find('.branch-container').moduleList( BranchContainer )  }

        wizardPopup { $('div#p_p_id_profileConfiguration_WAR_dtportalwar_').$('.jsWizardPopup') }

        dashboardName { branchDashboard.find('.dashboard__name').text() }


    }

}
