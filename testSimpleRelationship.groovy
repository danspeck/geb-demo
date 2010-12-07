
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
Browser.drive("http://enrollio.org") {
assert $("h3.reallynow").siblings("p").find { it.text() =~/Dangle/ }
assert $("h3.reallynow").siblings("p").find { it.text() =~/0\.2/ }
}
