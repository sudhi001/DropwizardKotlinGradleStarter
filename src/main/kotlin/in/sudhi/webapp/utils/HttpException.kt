import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

class HttpException(status: Response.Status, message: String) : WebApplicationException(Response.status(status).entity(message).build())
