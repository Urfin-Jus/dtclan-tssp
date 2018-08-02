package modules.branch.portlets

import geb.Module
import modules.branch.mutual.Sidebar
import pages.BranchPage

class BranchSettingsPortlet extends Module {

    static base = { find '#p_p_id_branchessettings_WAR_dtportalwar_' }

    static content = {

        rootContainer { find 'div.jsBranchSettingsRootContainer' }
        header {rootContainer.children().filter('div',display:'block').find('div.branch-info__header._outer').text() }
        contentName { rootContainer.children().filter('div',display:'block').find( 'div.branch-info__content_name').text() }


            branchSettingsGeneralContent { rootContainer.find( 'div',class:'jsBranchSettingsGeneral jsBranchInfoContent') }


                branchNameInputField(required:false) { branchSettingsGeneralContent.find('input.form-text__input.taInput._field-value.jsName') }
                branchPublicStaticIP(required:false) { branchSettingsGeneralContent.find('input.form-text__input.taInput._field-value.jsAddress' )}

                cancelButton(required:false) { branchSettingsGeneralContent.find('button.jsCancelButton') }
                applyButton(required:false) { branchSettingsGeneralContent.find('button.jsSubmitButton') }


           /* dhcpConfigurationContent {rootContainer > 'div.jsBranchSettingsDHCPConf.jsBranchInfoContent' }


            accessFromInternetContent { rootContainer > 'div.jsBranchSettingsAccessFromInternet.jsBranchInfoContent'}


            trafficPriorityContent { rootContainer > 'div.jsBranchSettingsTrafficPriority.jsBranchInfoContent'}


            dynDnsContent {rootContainer > 'div.jsBranchSettingsDynDns.jsBranchInfoContent.branch-info-wrapper'}*/


    }



}





