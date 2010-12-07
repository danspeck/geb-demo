
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
Browser.drive("http://enrollio.org") {
$("a", text:"Login").click()
$("#loginForm").username = "gug"
$("#loginForm").password = "groovy18"
$("#login").click()
assert $("*", text: ~/.*Welcome to Enrollio, gug!.*/).size() > 0
}
