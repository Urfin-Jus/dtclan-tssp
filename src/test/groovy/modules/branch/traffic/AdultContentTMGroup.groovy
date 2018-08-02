package modules.branch.traffic

import  geb.Module

class AdultContentTMGroup extends Module{

    static base = { find(".main-container__block.jsGroupContainer, data-id: 9148227301751037369") }

    static content = {

        groupName { find('span.title').text() }

        headerRadioButtons { find( ".radio-buttons__container ,'data-radio-name': jsGroupLRadio-category-9148227301751037369") }

            /*headerRadioButtonAllow { find("input#jsGroupLRadio-category-9148227301751037369allow") }
            headerRadioButtonLimit { find("input#jsGroupLRadio-category-9148227301751037369limit") }
            headerRadioButtonBlock { find("input#jsGroupLRadio-category-9148227301751037369blocked") }*/

        footerCustomizeButton { find('.main-container__block_footer') }

        //Sub-Groups

        drugsSubgroup { find(".block-column,'data-id': 9148477634551074447") }

        nuditySubgroup { find(".block-column,'data-id': 9148477660451075016") }

        alcoTobbacoSubgroup { find(".block-column,'data-id': 9148477659751074989") }

        violanceSubgroup { find(".block-column,'data-id': 9148477658751074946") }


    }

}
