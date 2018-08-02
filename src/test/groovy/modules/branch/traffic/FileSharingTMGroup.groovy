package modules.branch.traffic

import geb.Module

class FileSharingTMGroup extends Module{

    static base = { find(".main-container__block.jsGroupContainer, 'data-id':'9148227308051037842'") }

    static content = {

        groupName { find('span.title').text() }

        headerRadioButtons { find( ".radio-buttons__container , data-radio-name: jsGroupLRadio-category-9148227308051037842") }

            /*headerRadioButtonAllow { find("input#jsGroupLRadio-category-9148227301751037369allow") }
            headerRadioButtonLimit { find("input#jsGroupLRadio-category-9148227301751037369limit") }
            headerRadioButtonBlock { find("input#jsGroupLRadio-category-9148227301751037369blocked") }*/

        footerCustomizeButton { find('.main-container__block_footer') }

        //Sub-Groups

        cloudStorageSubgroup { find(".block-column,'data-id': 9148468996551179112") }

        torrentsSubgroup { find(".block-column,'data-id': 9148468992751178967") }

        p2pSubgroup { find(".block-column,'data-id': 9148468995151179058") }

    }

}
