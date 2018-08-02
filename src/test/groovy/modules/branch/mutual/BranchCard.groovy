package modules.branch.mutual

import geb.Module

class BranchCard  extends Module {

    static base = { find('div.dashboard__content.jsBranchCard') }

    static content = {

        branchCardHeader { $('.branch__header')}

        branchBodyStatus { $('div > div > div.branch__body.jsBranchBody > div.branch__body_status') }

        branchBodyProfiles { $('div > div > div.branch__body.jsBranchBody > div.branch__profiles') }

        WebFilteringMenu  { $('div > div > div.jsWebfilteringMenu.web-filtering__menu') }



    }

}