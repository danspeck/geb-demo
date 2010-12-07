
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.*
class LoginPage extends Page {
    static url = "http://enrollio.org/login"
    static at = { title == "Login" }
    static content = {
        usernameField { $("input[name='username']") }
        passwordField { $("input[name='password']") }
        loginButton{ $("#login") }
        errorsMessage { $("div.errors").text() }
    }
}
 
Browser.drive(LoginPage) {
        usernameField.value("badguy")
        passwordField.value("badguypassword")
        loginButton.click()
        assert at(LoginPage)
        assert errorsMessage =~ /(?i)invALID uSERNAME.*password/
        assert errorsMessage =~ /Invalid username.*password/
}
