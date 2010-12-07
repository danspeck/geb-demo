
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {  
      assert title == "Help - About"
      // Un-comment driver.close() to close the browser window
      // driver.close()  
      assert $("a", text:"Loooogin").size() == 0
      assert $("a", text:"Login").size() == 1
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
