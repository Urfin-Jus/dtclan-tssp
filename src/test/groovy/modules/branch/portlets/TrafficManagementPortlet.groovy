package modules.branch.portlets

import geb.Module
import geb.module.Checkbox
import modules.generic.ServiceActivationSlider
import org.openqa.selenium.By


class TrafficManagementPortlet extends Module {
    //static base = { find('.branch-info.traffic-management') }

    static base = { find(By.xpath('//div[@id="p_p_id_trafficManagement_WAR_dtportalwar_"]')) }

    static content = {
        //Anchors
        header { find('div.branch-info__header') }

        //activationSlider { }
        //switcher(wait:true) { find('div.jsSwitchActive.switcher__outer.service-activation') }
        //switcher(wait:true) { find('input.switcher__input') } //.find('input.switcher__input',type:'checkbox')}//.module(Checkbox)  }
        //switcher(wait:true) { find('input', class:'switcher__input taCheck')}

        switcher(wait: true) { find(By.xpath('.//div[contains(@class,"jsSwitchActives"]')) }

        //activationSlider { module( ServiceActivationSlider ) }

        trafficManagementContent(wait:true) { find('.branch-info__content') }

        safetyLevelContainer { find('.main-container') }

        bandwidthLimitationContainer {find('.main__info-blocks-container') }

        //Traffic Management Groups

            adultContentGroup  { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227301751037369'") }

            fileSharingGroup   { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227308051037842'") }

            gamingGroup        { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227306351037637'") }

            multimediaGroup    { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227299151037176'") }

            messagingGroup     { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227296151037037'") }

            bettingGroup       { trafficManagementContent.find(".main-container__block.jsGroupContainer, 'data-id':'9148227303751037508'") }



        //Buttons
            cancelButton { trafficManagementContent.find(".branch-info__footer").find(By.xpath('//div[@id="p_p_id_trafficManagement_WAR_dtportalwar_"]//button[contains( @class,"jsCancel" )]//span')) }

            applyButton { trafficManagementContent.find(".branch-info__footer").find(By.xpath('//div[@id="p_p_id_trafficManagement_WAR_dtportalwar_"]//button[contains( @class,"jsApply" )]//span')) }



        warningNotification(required: false) { trafficManagementContent.find('.notification-bottom.warning') }

    }




}
