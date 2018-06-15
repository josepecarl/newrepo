package com.mycorp;

        				 import java.util.Map;

        				 import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.openqa.selenium.Capabilities;
        				 import org.openqa.selenium.Platform;
        				 import org.openqa.selenium.WebDriver;
        				 import org.openqa.selenium.chrome.ChromeDriver;
        				 import org.openqa.selenium.edge.EdgeDriver;
        				 import org.openqa.selenium.firefox.FirefoxDriver;
        				 import org.openqa.selenium.ie.InternetExplorerDriver;
        				 import org.openqa.selenium.opera.OperaDriver;
        				 import org.openqa.selenium.phantomjs.PhantomJSDriver;
        				 import org.openqa.selenium.remote.BrowserType;
        				 import org.openqa.selenium.remote.DesiredCapabilities;
        				 import org.openqa.selenium.remote.RemoteWebDriver;
        				 import org.openqa.selenium.remote.Response;

        				 import io.github.bonigarcia.wdm.BrowserManager;
        				 import io.github.bonigarcia.wdm.ChromeDriverManager;
        				 import io.github.bonigarcia.wdm.EdgeDriverManager;
        				 import io.github.bonigarcia.wdm.FirefoxDriverManager;
        				 import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
        				 import io.github.bonigarcia.wdm.OperaDriverManager;
        				 import io.github.bonigarcia.wdm.PhantomJsDriverManager;
        				 import io.github.bonigarcia.wdm.VoidDriverManager;


        				 public enum BrowserManagerEnum {

        				     CHROME( "chrome" ),
        				     FIREFOX( "firefox" ),
        				     EDGE( "edge" ),
        				     IE( "ie" ),
        				     MARIONETTE( "marionette" ),
        				     OPERA( "opera" ),
        				     PHANTOMJS( "phantomjs" ),
        				     NONE( "test" );

        				     private final String browserName;

        				     private BrowserManagerEnum( final String browserName ) {
        				         this.browserName = browserName;
        				     }

        				     public static BrowserManagerEnum of( final String browserName ) {
        				         final String lBrowserName = StringUtils.lowerCase( browserName );
        				         for( final BrowserManagerEnum browser : BrowserManagerEnum.values() ) {
        				             if( browser.browserName.equals( lBrowserName ) ) {
        				                 return browser;
        				             }
        				         }
        				         return NONE;
        				     }

        				     public BrowserManager getBrowserManager() {
        				         switch( this ) {
        				     
        				         case CHROME:        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                				  					 return ChromeDriverManager.getInstance().version( "2.24" );
        				         case FIREFOX:       //System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        				         						
        				        	 				 return FirefoxDriverManager.getInstance();
        				         case EDGE:          System.setProperty("webdriver.edge.driver", "src/main/resources/MicrosoftWebDriver.exe");
        				        	 				 return EdgeDriverManager.getInstance();
        				         case IE:            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
        				        	 				 return InternetExplorerDriverManager.getInstance();
        				         case MARIONETTE:    return FirefoxDriverManager.getInstance();
        				         case OPERA:         return OperaDriverManager.getInstance();
        				         case PHANTOMJS:     return PhantomJsDriverManager.getInstance();
        				         case NONE: default: return VoidDriverManager.getInstance().version( "1" );
        				         }
        				     }

        				     public BrowserManager getBrowserManager( final String version ) {
        				         return getBrowserManager().version( version );
        				     }

        				     public WebDriver getDriver() {
        				         switch( this ) {
        				         case CHROME:     return new ChromeDriver();
        				         case FIREFOX:    return Mockito.mock(FirefoxDriver.class);
        				         case EDGE:       return new EdgeDriver();
        				         case IE:         DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        				         				  capability.setCapability("ignoreZoomSetting", true);
        				         				  capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
        				        	 			  return new InternetExplorerDriver(capability);
        				         case MARIONETTE: return new FirefoxDriver();
        				         case OPERA:      return new OperaDriver();
        				         case PHANTOMJS:  return new PhantomJSDriver();
        				         case NONE: default:
        				             final DesiredCapabilities dc = new DesiredCapabilities( BrowserType.MOCK, "mock-version", Platform.ANY );
        				             final RemoteWebDriver mock = new RemoteWebDriver( dc ) {
        				                 /**
        				                  * {@inheritDoc}
        				                  *
        				                  * @see RemoteWebDriver#execute(String, Map)
        				                  */
        				                 @Override
        				                 protected Response execute( final String driverCommand, final Map< String, ? > parameters ) {
        				                     return new Response();
        				                 }

        				                 /**
        				                  * {@inheritDoc}
        				                  *
        				                  * @see RemoteWebDriver#startSession(Capabilities, Capabilities)
        				                  */
        				                 @Override
        				                 protected void startSession( final Capabilities desiredCapabilities, final Capabilities requiredCapabilities ) {
        				                     setSessionId( "mock" );
        				                 }
        				             };
        				             return mock;
        				         }
        				     }

        				 }
