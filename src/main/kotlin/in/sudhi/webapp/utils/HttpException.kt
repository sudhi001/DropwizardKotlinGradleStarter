import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.Response
class HttpException(status: Response.Status, message: String) : WebApplicationException(Response.status(status).entity(message).build())
