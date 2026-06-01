
tasks.register("setup") {
    dependsOn(
        ":login:shadowJar",
        ":analyticsDashboard:shadowJar",
        ":transactions:shadowJar",
        ":precompile:run"
    )
    tasks.getByPath(":precompile:run").mustRunAfter(
        ":login:shadowJar",
        ":analyticsDashboard:shadowJar",
        ":transactions:shadowJar"
    )
}