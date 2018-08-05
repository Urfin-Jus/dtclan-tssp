package modules.generic

import geb.Module

class BottomFooter extends Module{

    static base = { $('footer#footer') }
    static content = {
        innerFooter { $('div.dt-page-footer') }

    }
}
