package pages

import Stopwatch
import Page

import modules.branch.mutual.*
import modules.branch.portlets.*
import modules.branch.traffic.*
import NotificationPortlet
import OrderTimingSample


class BranchPage extends Page{

    /*static at = {
        title == 'Branch'
        waitFor(40) {
            [upperColumn1,centerColumn2,centerColumn3,lowColumn4].every{it.displayed}
        }
    }

    static content = {

        notificationPortlet  { module NotificationPortlet }


        //Anchors
        upperColumn1  { $('div#column-1')}
        centerColumn2 { $('div#column-2')}
        centerColumn3 { $('div#column-3')}
        lowColumn4    { $('div#column-4')}


        //PERSISTENT ELEMENTS
            //usage statistic tab
            usageStatTab(wait:true){ upperColumn1.find('.main-section__header_nav._tabs .nav__item').filter( text:'Usage statistics')}


            //active view tab
            actualViewTab(wait:true){ upperColumn1.find('.main-section__header_nav._tabs .nav__item').filter(text: 'Actual view') }

            //branch status container
            branchInformationContainer(wait:true) { centerColumn2.module(BranchCard) }

            sideBar(wait:true){ centerColumn2.module Sidebar }

        //DYNAMIC PARTS

            // GENERAL PORTLET
            branchSettingsPortlet(required:false) { centerColumn3.module(BranchSettingsPortlet) }

            //DEVICES PORTLET
            assessDeviceFromInternetPortlet(required:false)  { $('div#p_p_id_accessDeviceFromInternet_WAR_dtportalwar_') }

            //TRAFFIC MANAGEMENT PORTLET
            trafficManagementPortlet(required:false) { module TrafficManagementPortlet  }

            //CONNECTED DEVICES PORTLET
            branchDeviceTablePortlet(required:false) { module DevicesPortlet }




    }

    //SideBar
    BranchPage clickDevicesOnSideBar(){

        waitFor { sideBar.devicesConnectedItem }
            sideBar.devicesConnectedItem.click()
        waitFor { branchDeviceTablePortlet }

        return (BranchPage) browser.page
    }



    //Devices
    def createNewDevice(String name, String ipAddress, String MACaddress){

        waitFor { branchDeviceTablePortlet.addDeviceButton }
            branchDeviceTablePortlet.addDeviceButton.click()

        waitFor { branchDeviceTablePortlet.deviceName
            branchDeviceTablePortlet.deviceIPaddress
            branchDeviceTablePortlet.deviceMACaddress
            branchDeviceTablePortlet.addButton }

            branchDeviceTablePortlet.deviceName.value(name)
            branchDeviceTablePortlet.deviceIPaddress.value(ipAddress)
            branchDeviceTablePortlet.deviceMACaddress.value(MACaddress)
            branchDeviceTablePortlet.addButton.click()


        waitFor(60) { notificationPortlet.inventoryUpdateNotification.displayed }
            notificationPortlet.refreshButton.click()

        return  browser.page(BranchPage)
    }


    //General Settings
    def changeBranchName(String new_name, OrderTimingSample timeSample){
        def stopwatch = Stopwatch.createStarted()
        waitFor { branchSettingsPortlet.branchSettingsGeneralContent.displayed }
        timeSample.pageLoadOverhead = stopwatch.stop().elapsed()

        if(!(branchSettingsPortlet.branchNameInputField.value() == new_name)){
            branchSettingsPortlet.branchNameInputField.value(new_name)

            waitFor { branchSettingsPortlet.applyButton.displayed }; stopwatch.start()
            branchSettingsPortlet.applyButton.click()

            waitFor(60) { notificationPortlet.inventoryUpdateNotification.displayed }
            timeSample.notificationRecieved = stopwatch.stop().elapsed(); stopwatch.start()
            notificationPortlet.refreshButton.click()

            waitFor{ branchSettingsPortlet }
            timeSample.inventoryUpdated = stopwatch.stop().elapsed()

            return browser.page
        }
    }

    //Traffic Management
    def toggleTMactivationAndApply(OrderTimingSample timeSample){
        def stopwatch = Stopwatch.createStarted()
        waitFor {trafficManagementPortlet.switcher}
        timeSample.pageLoadOverhead = stopwatch.stop().elapsed()

        trafficManagementPortlet.switcher.click()
            waitFor { trafficManagementPortlet.warningNotification.displayed
                trafficManagementPortlet.applyButton.displayed }

            trafficManagementPortlet.warningNotification.click()
            stopwatch.start()
            trafficManagementPortlet.applyButton.click()

            waitFor(60) { notificationPortlet.inventoryUpdateNotification.displayed }
            timeSample.notificationRecieved = stopwatch.stop().elapsed(); stopwatch.start()
            notificationPortlet.refreshButton.click()

            waitFor{ trafficManagementPortlet }
            timeSample.inventoryUpdated = stopwatch.stop().elapsed()
        return browser.page
    }
*/


}


    //Verify 'At' Section



