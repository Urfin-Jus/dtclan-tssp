package configuration

import geb.Page
import modules.generic.Banner
import modules.generic.Footer
import modules.generic.MainContent

class TSSPbasementPage extends Page  {

    static content = {
        banner      { module(Banner) }
        mainContent { module MainContent }
        footer { module(Footer) }

    }


}
