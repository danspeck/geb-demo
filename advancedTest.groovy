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
        def studentsTable = $("h3", text: ~/.*Students.*/).next("table")
        def linkToWoodstockParent = studentsTable.find("tr td:first-child a", text:contains("Woodstock Jackson"))
        assert linkToWoodstockParent.size() != 0
        linkToWoodstockParent.click()
        assert title == "Contact:Woodstock Jackson"
        // TODO go back
        driver.navigate().back()

        def linkToWoodstockStudent = studentsTable.find("tr td:nth-child(2) a", text:contains("Woodstock Jackson"))
        assert linkToWoodstockStudent.size() != 0
        linkToWoodstockStudent.click()
        assert title == "Student: Woodstock Jackson"
        // driver.quit()
    }
}
catch (geb.error.DriveException dex){ 
    dex.printStackTrace() 
    System.exit(1)
}
