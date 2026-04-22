rootProject.name = "demo"

include("login", "transactions", "analyticsDashboard")

project(":login").projectDir = file("login/demo")
project(":transactions").projectDir = file("transactions/demo")
project(":analyticsDashboard").projectDir = file("analyticsDashboard/demo")