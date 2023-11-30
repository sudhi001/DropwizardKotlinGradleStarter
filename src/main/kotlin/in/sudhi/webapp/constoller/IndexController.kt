package `in`.sudhi.webapp.constoller

import com.codahale.metrics.annotation.Timed
import `in`.sudhi.webapp.model.Greetings
import java.util.*
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON


@Path("/hello")
@Produces(APPLICATION_JSON)
class IndexController(
        private val template: String,
        private val defaultName: String) {

    private val counter = AtomicLong()

    @GET
    @Timed
    fun getHello(@QueryParam("name") name: Optional<String>): Greetings {
        val value = String.format(template, name.orElse(defaultName))
        return Greetings(counter.incrementAndGet(), value)
    }

    @POST
    @Timed
    fun postHello(@Valid saying: Greetings) = Greetings(saying.id, "bye ${saying.content}")
}



