
@Grapes([
            @Grab("org.codehaus.geb:geb-core:latest.release"),
            @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])

import geb.Browser
Browser.drive("http://enrollio.org") {
    assert title == "Help - About"
}
