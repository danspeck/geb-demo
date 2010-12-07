
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {
assert $("h3", class: "reallynow", text: "Thanks").size() == 1
assert $("h3.reallynow", text: "Thanks").size() == 1
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
