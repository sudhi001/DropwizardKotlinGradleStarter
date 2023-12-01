package `in`.sudhi.webapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length


class IdValues(
    @JsonProperty val id: Long = 0,
    @JsonProperty @field:Length(max = 3) val value: String = "") {

    constructor() : this(0, "") // needed by Jackson deserialization
}
