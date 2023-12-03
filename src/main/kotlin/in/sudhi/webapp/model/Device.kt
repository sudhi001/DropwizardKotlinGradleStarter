package `in`.sudhi.webapp.model

import com.fasterxml.jackson.annotation.JsonProperty

class Device(
    @JsonProperty val deviceId: String = "",
    @JsonProperty val nonSec: String = "",
    @JsonProperty val secure: String = "",
    @JsonProperty val time: Long = 0) {
    constructor() : this("", "","",0) // needed by Jackson deserialization
}
