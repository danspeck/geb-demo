
@Grapes([
              @Grab("org.codehaus.geb:geb-core:latest.release"),
              @Grab("org.seleniumhq.selenium:selenium-firefox-driver:latest.release")
])
import geb.Browser
try {
    Browser.drive("http://enrollio.org") {
$("a", text:"Login").click()
$("#loginForm").username = "gug"
$("#loginForm").password = "groovy18"
$("#login").click()
assert $("*", text: ~/.*Welcome to Enrollio, gug!.*/).size() > 0
$("a", text:"Students").click()

def linkToWoodstockParent = $("tr td:first-child a", text:contains("Woodstock Jackson"))
assert parentLink.size() != 0
parentLink.click()
assert title == "Contact:Woodstock Jackson"
driver.navigate().back()

def linkToWoodstockStudent = $("tr td:nth-child(2) a", text:contains("Woodstock Jackson"))
assert studentLink.size() != 0
studentLink.click()
assert title == "Student: Woodstock Jackson"
}
}
catch (geb.error.DriveException dex) { 
    dex.printStackTrace() 
    System.exit(1)
}
