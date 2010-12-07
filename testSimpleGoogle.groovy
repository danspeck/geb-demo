@Grapes([
@Grab("org.codehaus.geb:geb-core:latest.release"),
@Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
try {
    Browser.drive("http://google.com") {
        assert title == "Google"
        $("a").click()
        assert title != "Google"
    }
} catch (geb.error.DriveException dex) { 
    def cause=dex.getCause() 
    cause=org.codehaus.groovy.runtime.StackTraceUtils.sanitize(cause) 
    cause.printStackTrace() System.exit(1) 
} 
