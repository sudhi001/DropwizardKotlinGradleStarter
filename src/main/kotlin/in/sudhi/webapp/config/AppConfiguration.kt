package `in`.sudhi.webapp.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class AppConfiguration(
    @JsonProperty @NotEmpty val template: String="",
    @JsonProperty @NotEmpty val defaultName: String = "Stranger") : Configuration() {

    constructor() : this("", "") // needed by Jackson deserialization


}