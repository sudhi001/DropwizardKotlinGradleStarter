package `in`.sudhi.webapp

import `in`.sudhi.webapp.config.AppConfiguration
import `in`.sudhi.webapp.constoller.IndexController
import io.dropwizard.Application
import io.dropwizard.setup.Environment


class MicroApplication : Application<AppConfiguration>() {

    override fun getName() = "hello-world"

    override fun run(conf: AppConfiguration, env: Environment) {
        val indexController = IndexController(conf.template, conf.defaultName)
        val healthCheck = `in`.sudhi.webapp.health.HealthCheck(conf.template)

        env.jersey().register(indexController)
        env.healthChecks().register("hcTemplate", healthCheck)
    }

}

fun main(args: Array<String>) = MicroApplication().run(*args)