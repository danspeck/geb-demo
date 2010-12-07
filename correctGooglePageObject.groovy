
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.*

class LoginPage extends Page {
    static url = "http://enrollio.org/login"
    static content = {
        usernameField { $("input[name='username']").value() }
    }
    
}
 
class GoogleHomePage extends Page {
    static url = "http://google.com"
    static at = { title == "Google" }
    static content = {
        searchField { $("input[name=q]") }
        // searchButton(to: GoogleResultsPage) { $("input[value=Google Search]") }
    }
}
 
// Now the script
Browser.drive(GoogleHomePage) {
    searchField.value("Chuck Norris")
    // searchButton.click()
    // assert at(GoogleResultsPage)
    // assert resultLink(0).text() ==~ /Chuck/
}
