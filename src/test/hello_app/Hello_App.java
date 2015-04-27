package test.hello_app;

import static org.junit.Assert.*;

import org.junit.Test;


//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
*
*
*/
public class Hello_App {
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\pallavi.snehal\\workspace\\project2";
  protected Client client = null;

  @Before
  public void setUp(){
      client = new Client(host, port, true);
      client.setProjectBaseDirectory(projectBaseDirectory);
      client.setReporter("xml", "reports", "Hello_App");
  }

  @Test
  public void testHello_App(){
      client.setDevice("adb:GT-I9500");
      if(client.install("com.example.hello_app/.MainActivity", true, false)){
          // If statement
      }
      client.verifyElementFound("NATIVE", "xpath=//*[@text='Apps']", 0);
      client.click("NATIVE", "xpath=//*[@text='Apps']", 0, 1);
      client.verifyElementFound("NATIVE", "xpath=//*[@text='Hello_App']", 0);
      client.click("NATIVE", "xpath=//*[@text='Hello_App']", 0, 1);
      client.verifyElementFound("NATIVE", "xpath=//*[@text='Hello world!']", 0);
  }

  @After
  public void tearDown(){
      client.generateReport(true);
  }
}
