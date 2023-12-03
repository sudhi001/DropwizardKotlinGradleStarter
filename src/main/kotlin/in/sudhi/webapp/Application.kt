package `in`.sudhi.webapp

import `in`.sudhi.webapp.config.AppConfiguration
import `in`.sudhi.webapp.constoller.DeviceConfigController
import `in`.sudhi.webapp.constoller.IndexController
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Environment


class MicroApplication : Application<AppConfiguration>() {

    override fun getName() = "hello-world"




    override fun run(conf: AppConfiguration, env: Environment) {
        val dataSource = conf.database.build(env.metrics(), "database")

        val indexController = IndexController(conf.template, conf.defaultName)
        val deviceConfigController = DeviceConfigController()
        val healthCheck = `in`.sudhi.webapp.health.HealthCheck(conf.template)

        env.jersey().register(indexController)
        env.jersey().register(deviceConfigController)
        env.healthChecks().register("hcTemplate", healthCheck)
    }

}

fun main(args: Array<String>) = MicroApplication().run(*args)