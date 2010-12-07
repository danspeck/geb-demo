
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {
$("a", text:"Login").click()
$("#loginForm").username = "gug"
$("#loginForm").password = "groovy18"
$("#login").click()
assert $("*", text: ~/.*Welcome to Enrollio, gug!.*/).size() > 0
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
