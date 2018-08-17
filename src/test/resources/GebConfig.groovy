//import com.aoe.gebspockreports.GebReportingListener
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.logging.*
import java.util.logging.Level

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions




waiting {
	timeout = 20
    retryInterval = 0.1
    includeCauseInMessage = true
    atCheckWaiting = true
    baseNavigatorWaiting = true
}

driver = {
    System.setProperty("webdriver.chrome.driver", "build/resources/test/WebDriverBinaries/chromedriver")
    System.setProperty("webdriver.chrome.logfile", "$reportsDir/chromedriver.log")
    //System.setProperty("webdriver.chrome.verboseLogging", "true")
    //System.setProperty("tssp.performance.loggfile","$reportsDir/chromedriver-performance.log")

    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions options = new ChromeOptions()
        options.addArguments("--incognito")

    LoggingPreferences logPrefs = new LoggingPreferences()
        logPrefs.enable(LogType.BROWSER, Level.ALL)

    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs)

    new ChromeDriver(capabilities)

   // new ChromeDriver()
}

//baseUrl = "http://tssp-route-dtag-tssp.deploy22.openshift.sdntest.netcracker.com"

//reportingListener = new GebReportingListener()
reportsDir = "build/reports/geb-reports"
