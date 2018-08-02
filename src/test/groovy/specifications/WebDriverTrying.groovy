package specifications

import geb.spock.GebReportingSpec
import groovy.json.JsonOutput
import org.openqa.selenium.Capabilities
import org.openqa.selenium.chrome.ChromeOptions
import spock.lang.Ignore

@Ignore
class WebDriverTrying extends GebReportingSpec {

    def "Get ChromeDriver Capabilities - Original at start point"(){
        expect:
        Capabilities caps = driver.getCapabilities()
        println JsonOutput.prettyPrint( JsonOutput.toJson( caps.asMap() ) )
    }

    def "Get Original ChromeDriver Options"() {
        expect:
        // JsonOutput.prettyPrint( driver.manage().asMap() )
        println  driver.manage().toString()

    }
}
