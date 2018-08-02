package modules.dashboard

import geb.Module


class WizardPopUp extends Module{

    static base = {  $('div',class:'popup__background jsWizardPopup _wiz open') }

    static content = {
        //Mutual for all steps
        wizardPopUpContainer { $('div',class: 'jsWizardPopupContainer popup-container') }

        stepContainer { $('div', class:'step__container') }
        wizardCloseButton { $('div',class:'popup__header-close jsClosePopup') }
        stepContent { $('div',class:'jsStepContent popup__content _noscroll') }
        nextButton { $('button',class: 'taButton button fill-blue jsNext') }


        //Tab#0 Introduction
        //Tab#1 General
        profileName(required:false) {$('input',class:'form-text__input taInput _field _switch taEditInfo jsNameInput parsley-success') }
        profilePictureSelector(required: false) { $('div',class:'js-uxRadioButton radio__inner-container ') }

        //Tab#2 Profile Priority  (simple next so far)
        //Tab#3 Safety Level (simple next so far)



    }


    WizardPopUp clickNextButton(){
        nextButton.click()
        waitFor{ wizardPopUpContainer.isDisplayed() }
        return this
    }


}
