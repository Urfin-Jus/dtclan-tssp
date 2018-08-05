package modules.generic

import geb.Module

class SearchBox extends Module{

    static base = { find('div.search.form-text')}

    static content = {
        SearchField { $('input',class:'taInput search-row__input _field jsSearchInput') } }

    def enterSearchPattern(String pattern){
        SearchField.value(pattern)
    }
}
