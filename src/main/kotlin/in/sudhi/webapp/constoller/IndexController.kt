package `in`.sudhi.webapp.constoller

import com.codahale.metrics.annotation.Timed
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import java.util.*


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class IndexController( private val template: String, private val defaultName: String) {


    @GET
    @Timed
    fun getHello(@QueryParam("name") name: Optional<String>): Map<String,String> {
        val value = String.format(template, name.orElse(defaultName))
        return mapOf("data" to value)
    }

}



