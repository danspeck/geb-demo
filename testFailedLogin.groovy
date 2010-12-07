
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {
$("a", text:"Login").click()
$("#loginForm").username = "badguy"
$("#loginForm").password = "badguypassword"
$("#login").click()
assert title == "Login"
assert $("*", text: ~/.*Invalid.*username.*password/).size() > 0
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
