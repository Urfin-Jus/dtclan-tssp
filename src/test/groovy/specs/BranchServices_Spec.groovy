package specs

import geb.spock.GebReportingSpec
import groovy.json.JsonOutput
import pages.login.KeyCloak_LoginPage
import pages.DashboardPage
import pages.DashBranchCard
import inventory.BranchEntity
import spock.lang.Shared
import spock.lang.Stepwise

import static Properties.*

@Stepwise
class BranchServices_Spec  extends GebReportingSpec {

    @Shared
        def branches = []



    def setupSpec(){
        browser.baseUrl = tssp_base_url
    }


    def "Login to TSSP"(){
        expect: 'Navigating to TSSP by direct domain url is redirected to Login Page of IDM (KeyCloak)'

        KeyCloak_LoginPage login_form = to KeyCloak_LoginPage

        and: 'Enter credentials and get to Dashboard Page'

        (DashboardPage) login_form.loginWithCredentials(account_admin_login,account_admin_password)

    }


    def "Get Branch Information and populate BranchEntities"(){
        expect:
        browser.to(DashboardPage).branchContainers.each{ it -> branches << new BranchEntity(object_id: it.nc_objectID, site_id: it.siteID, name: it.find('span.branch__header_name').text()) }
        assert branches.size() == 2
    }



    def "Print BranchEntities"(){
        expect:
        println JsonOutput.prettyPrint(JsonOutput.toJson(branches[0]))
        //println branches[1].toString()
    }

}
