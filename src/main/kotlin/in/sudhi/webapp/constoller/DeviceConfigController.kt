package `in`.sudhi.webapp.constoller

import Device
import HttpException
import com.codahale.metrics.annotation.Timed
import `in`.sudhi.webapp.model.IdValues
import `in`.sudhi.webapp.utils.ID
import java.security.KeyPair
import java.time.Instant
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response


@Path("/cfg")
@Produces(APPLICATION_JSON)
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

    @GET
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



