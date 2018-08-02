package specifications

import com.google.common.base.Stopwatch
import configuration.OrderTimingSample

import spock.lang.Ignore
import spock.lang.Stepwise

import static configuration.Properties.*
import pages.*
import pages.login.LoginFormPage

import geb.spock.GebReportingSpec
import org.openqa.selenium.interactions.Actions

import spock.lang.Shared


@Stepwise
class LoginTSSP_Spec extends GebReportingSpec {

    @Shared String branch_A_site_id ='pro-branch-a-ppp-user' ; String branch_B_site_id = 'pro-branch-b-ppp-user'
   // @Shared Actions actions
    @Shared Stopwatch stopwatch
    @Shared List<OrderTimingSample> timeRecords = []

    def setupSpec(){
        browser.baseUrl = tssp_base_url
        stopwatch = Stopwatch.createUnstarted()
        //actions= new Actions(driver)
    }

    def "Login to TSSP"(){
        expect: 'Navigating to TSSP by direct domain url is redirected to Login Page of IDM'

        LoginFormPage login_form = to LoginFormPage

        and: 'Dashboard as the root page of user cabinet is shown first after successful login'

        (DashboardPage) login_form
                .clickLoginButton(tssp_concurrent_account_admin_login,tssp_concurrent_account_admin_password) // redirect to LoginConfirmation Page
                .clickAllowButton()
    }

    @Ignore
    def "Navigate to Branch A & create device with static IP manually"(){
        setup:
            browser.at(DashboardPage)
            BranchPage branch_A_page  =   browser.page(DashboardPage).branchContainers
                                                    .find {it.siteID == branch_A_site_id }
                                                    .clickBranchSettings()
            interact{ moveToElement(branch_A_page.sideBar.devicesConnectedItem).click() }
            waitFor { branch_A_page.branchDeviceTablePortlet }


        expect:
            branch_A_page.createNewDevice('branch-a-device-2','192.168.0.201','30:AE:10:B3:C9:B4')

    }

    @Ignore
    def "Create Manual Device"(){
        expect:
        browser.at(DashboardPage)
        and:
        BranchPage branch_A_page  =   browser.page(DashboardPage).branchContainers
                .find {it.siteID == branch_A_site_id }
                .clickBranchSettings()
                .clickDevicesOnSideBar()
        and:
        branch_A_page.createNewDevice('branch-a-device-2','192.168.0.201','30:AE:10:B3:C9:B4')



    }


    def "Login's Successful.No Wizard. Branch A Name Change"(){
        expect: 'Navigate to Dashboard --> Branch A General Settings'

            DashboardPage dashboard_page = to(DashboardPage)
                assert dashboard_page.dashboardContent.children().size() == 2
                assert dashboard_page.branchContainers.size() == 2
            def branch_A_container = dashboard_page.branchContainers.find {it.siteID == branch_A_site_id}
            BranchPage branch_A_page = branch_A_container.clickBranchSettings()

        and: 'Assert location is Branch Page'
            timeRecords << new OrderTimingSample(operationName: "Branch Name Change")
            branch_A_page.changeBranchName('Pro Branch A v.18', timeRecords.last())


    }


    def "Turn off Traffic Management for Branch B"(){
        expect: 'Navigate to Dashboard --> Branch B Traffic Management Settings'
            DashboardPage dashboard_page = to(DashboardPage)
                def branch_B_container = dashboard_page.branchContainers.find {it.siteID == branch_B_site_id}
                BranchPage branch_B_page = branch_B_container.clickTrafficManagement()

        and: 'Turn off Traffic Management'
            timeRecords << new OrderTimingSample(operationName: "Toggle Traffic Management Activation")
            branch_B_page.toggleTMactivationAndApply(timeRecords.last())

    }

    def cleanupSpec(){

       println("-----------------------------------------------------------------------------")
       printf("%20s %5s %5s %5s", "OPERATION", "NOTIFICATION RECEIVED", "INVENTORY UPDATED", "OVERHEAD")
       println()
       println("-----------------------------------------------------------------------------")
       timeRecords.each {
            printf("%20s %5s %5s %5s",it.operationName, it.notificationRecieved?it.notificationRecieved.getSeconds():'0' , it.inventoryUpdated?it.inventoryUpdated.getSeconds():"0" ,it.pageLoadOverhead?it.pageLoadOverhead.getSeconds():"0")
        }
       println("-----------------------------------------------------------------------------")


        driver.quit()
    }



}
