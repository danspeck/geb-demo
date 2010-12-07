
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
Browser.drive("http://enrollio.org") {
assert $("h3", class: "reallynow", text: "Thanks").size() == 1
assert $("h3.reallynow", text: "Thanks").size() == 1
}
