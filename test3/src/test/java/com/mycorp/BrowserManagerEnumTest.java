package com.mycorp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
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

}
