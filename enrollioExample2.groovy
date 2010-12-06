
@Grapes([
             @Grab("org.codehaus.geb:geb-core:latest.release"),
             @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
 ])

import geb.Browser
Browser.drive("http://enrollio.org") {
    assert title == "Help - About"
    // Simple testing for presence of an element.
    // Jquery selectors bring back a list of matches
    assert $("a", text:"Loooogin").size() == 0
    assert $("a", text:"Login").size() == 1
    assert $("h3", class: "reallynow", text: "Thanks").size() == 1
    assert $("h3.reallynow", text: "Thanks").size() == 1
    assert $("h3.reallynow").siblings("p").find { it.text =~/Dangle/)
}
