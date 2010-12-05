
@Grapes([
            @Grab("org.codehaus.geb:geb-core:latest.release"),
            @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])

import geb.Browser
Browser.drive("http://enrollio.org") {
    $("input", name: "q").value("wikipedia")
    $("input", value: "Search").click()
    assert title.endsWith("Google Search")
    assert $("li.g", 0).find("a.l").text() == "Wikipedia"
}
