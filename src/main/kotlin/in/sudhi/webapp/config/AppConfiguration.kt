package `in`.sudhi.webapp.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.core.Configuration
import io.dropwizard.db.DataSourceFactory
import jakarta.validation.constraints.NotEmpty

class AppConfiguration(
    @JsonProperty @NotEmpty val template: String="",
    @JsonProperty @NotEmpty val defaultName: String = "Stranger") : Configuration() {

    constructor() : this("", "") // needed by Jackson deserialization

    // Database configuration
    @JsonProperty("database")
    var database: DataSourceFactory = DataSourceFactory()



}