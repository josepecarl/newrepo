package com.mycorp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.VoidDriverManager;


/**
 * Unit test for simple BrowserManagerEnumTest.
 */
public class BrowserManagerEnumTest {

    @Test
    public void shouldCheckOf() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "test" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( "perry" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( null );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        
        Assert.assertTrue( of.getBrowserManager() instanceof VoidDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof VoidDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
        
        ((RemoteWebDriver) of.getDriver()).get("http://www.google.es");
        
    }
    
    

    @Test 
    public void shouldCheckOfChrome() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "test" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( "perry" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( "chrome" );
        Assert.assertEquals( BrowserManagerEnum.CHROME, of );
        Assert.assertTrue( of.getBrowserManager() instanceof ChromeDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof ChromeDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }
    
    @Test 
    public void shouldCheckOfFireFox() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "firefox" );
        Assert.assertEquals( BrowserManagerEnum.FIREFOX, of );
        Assert.assertTrue( of.getBrowserManager() instanceof FirefoxDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }
    
    @Test 
    public void shouldCheckOfEDGE() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "edge" );
        Assert.assertEquals( BrowserManagerEnum.EDGE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof EdgeDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }
    
    @Test 
    public void shouldCheckOfIE() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "ie" );
        Assert.assertEquals( BrowserManagerEnum.IE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof InternetExplorerDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }
    
    @Test 
    public void shouldCheckOfMarionette() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "marionette" );
        Assert.assertEquals( BrowserManagerEnum.MARIONETTE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof FirefoxDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }
    
    @Test 
    public void shouldCheckOfPhanton() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "phantomjs" );
        Assert.assertEquals( BrowserManagerEnum. PHANTOMJS, of );
        Assert.assertTrue( of.getBrowserManager() instanceof PhantomJsDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }

    @Test 
    public void shouldCheckOfOpera() throws Exception {
        BrowserManagerEnum of = BrowserManagerEnum.of( "opera" );
        Assert.assertEquals( BrowserManagerEnum.OPERA, of );
        Assert.assertTrue( of.getBrowserManager() instanceof OperaDriverManager );
       // Assert.assertTrue( of.getBrowserManager( of.getBrowserManager().getDownloadedVersion() ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver() instanceof RemoteWebDriver );
    }

}
