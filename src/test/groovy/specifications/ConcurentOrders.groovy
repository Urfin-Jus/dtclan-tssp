package specifications

import geb.Browser
import geb.spock.GebReportingSpec
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import pages.DashboardPage
import pages.login.LoginFormPage
import spock.lang.Shared

import static configuration.Properties.getTssp_base_url
import static configuration.Properties.getTssp_concurrent_account_admin_login
import static configuration.Properties.getTssp_concurrent_account_admin_password
import static configuration.Properties.tssp_main_account_admin_login
import static configuration.Properties.tssp_main_account_admin_password


class ConcurrentOrders extends GebReportingSpec {

    @Shared    ChromeDriver driver
    @Shared    ChromeDriver driver_concurrent
    @Shared    Browser browserMain_Basic
    @Shared    Browser browserConcurrent_Pro


    def setupSpec(){
        System.setProperty("webdriver.chrome.driver", "build/resources/test/WebDriverBinaries/chromedriver")
        DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        ChromeOptions options = new ChromeOptions()
        options.addArguments("--incognito")
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)

        driver =  new ChromeDriver(capabilities)

        driver_concurrent =  new ChromeDriver(capabilities)

        browserMain_Basic =  new Browser(driver: driver, baseUrl: tssp_base_url)

        browserConcurrent_Pro =  new Browser(driver: driver_concurrent, baseUrl: tssp_base_url)

    }

    def "Parallel Login Basic "(){

        when:
        LoginFormPage main_login_form = browserMain_Basic.to LoginFormPage

        then:
        (DashboardPage) main_login_form
                .clickLoginButton(tssp_main_account_admin_login,tssp_main_account_admin_password) // redirect to LoginConfirmation Page
                .clickAllowButton()
    }

    def "Parallel Login Pro "(){

        when:
        LoginFormPage concur_login_form = browserConcurrent_Pro.to LoginFormPage

        then:

        (DashboardPage) concur_login_form
                .clickLoginButton(tssp_concurrent_account_admin_login,tssp_concurrent_account_admin_password) // redirect to LoginConfirmation Page
                .clickAllowButton()
    }


    def cleanupSpec(){

        driver.quit()
        driver_concurrent.quit()
    }



}
