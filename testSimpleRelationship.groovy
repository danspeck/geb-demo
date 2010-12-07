
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.0a5")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {
assert $("h3.reallynow").siblings("p").find { it.text() =~/Dangle/ }
assert $("h3.reallynow").siblings("p").find { it.text() =~/0\.2/ }
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
