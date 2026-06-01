
tasks.register("setup") {
    dependsOn(
        ":login:shadowJar",
        ":analyticsDashboard:shadowJar",
        ":transactions:shadowJar",
        ":precompile:run"
    )
}
project(":precompile").afterEvaluate {
    tasks.named("run") {
        mustRunAfter(
            ":login:shadowJar",
            ":analyticsDashboard:shadowJar",
            ":transactions:shadowJar"
        )
    }
}