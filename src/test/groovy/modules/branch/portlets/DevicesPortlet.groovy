package modules.branch.portlets

import geb.Module
import org.openqa.selenium.By

class DevicesPortlet extends Module {

        static base = { find(By.xpath('//div[@id="p_p_id_branchdevicestable_WAR_dtportalwar_"]')) }

        static content = {

           addDeviceButton(wait: true)  { find(By.xpath('.//button[contains( @class, "jsNewDevice" )]')) }
                // New Device Form (if addDeviceButtonClicked)
                deviceName(required:false)  { find(By.xpath('.//input[@name="display-name"]')) } //{ find(By.xpath('//div[@data-inputid=".jsName"]//input')) }

                deviceIPaddress(required:false) { find(By.xpath('.//input[@name="ip-address"]')) } //{ find(By.xpath('//div[@data-inputid=".jsIpAddress"]//input')) }

                deviceMACaddress(required:false) { find(By.xpath('.//input[@name="mac-address"]')) } //{ find(By.xpath('//div[@data-inputid=".jsMac"]//input')) }

                profileDropdown(required:false) { find(By.xpath('.//input[@data-name="profile-name"]')) } //{ find(By.xpath('//div[@data-inputid=".jsProfiles"]'))  }

                addButton(required:false) { find(By.xpath('.//button[contains(@class, "jsAddDeviceButton")]')) }

                cancelAddButton(required:false) { find(By.xpath('.//button[contains(@class, "jsCancelAddButton")]')) }

           reloadButton(wait:true)  { find(By.xpath('.//button[contains(@class ,"jsReloadInventory" )]')) }

           //tableDevices  { find(By.xpath('')) }
        }




}
