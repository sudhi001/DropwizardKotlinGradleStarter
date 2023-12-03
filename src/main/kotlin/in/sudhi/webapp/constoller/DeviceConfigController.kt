package `in`.sudhi.webapp.constoller

import `in`.sudhi.webapp.model.Device
import HttpException
import com.codahale.metrics.annotation.Timed
import `in`.sudhi.webapp.model.IdValues
import `in`.sudhi.webapp.utils.ID
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.security.KeyPair
import java.time.Instant
import java.util.*


@Path("/cfg")
@Produces(MediaType.APPLICATION_JSON)
class DeviceConfigController{

    @GET
    @Path("/available/countries")
    @Timed
    fun getAvailableCountries(): List<IdValues> {
        return listOf(IdValues(1,"US"), IdValues(2,"IN"))
    }

    @GET
    @Path("/{country}/available/servers")
    @Timed
    fun getAvailableServers(@PathParam("country") country:String): List<IdValues> {
        return listOf(IdValues(1,"http://localhost:8080"), IdValues(2,"http://localhost:8080"))
    }

    @POST
    @Path("/generate/device")
    @Timed
    fun postCreateDevice(): Device {
        val deviceId= ID.generateID()
        val time= Instant.now()
        val keyPair: KeyPair = ID.generateKeyPair()
            ?: throw HttpException(Response.Status.BAD_REQUEST, "Unable to generate key")
        return  Device(deviceId, keyPair.public.toString(), keyPair.private.toString(),time.toEpochMilli())
    }
}



