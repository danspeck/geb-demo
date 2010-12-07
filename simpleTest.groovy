
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
Browser.drive("http://enrollio.org") {  
      assert title == "Help - About"
      // Un-comment driver.close() to close the browser window
      // driver.close()  
      assert $("a", text:"Loooogin").size() == 0
      assert $("a", text:"Login").size() == 1
}
