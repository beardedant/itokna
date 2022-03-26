package ru.beardedant.itokna.restfull

import org.springframework.stereotype.Component
import ru.beardedant.itokna.domain.FireBirdRepoImpl
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("greet/{name}")
class GreetResource {

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    fun greet(@PathParam("name") name: String): Response = Response.ok(name).build()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun dbConnectTest(@PathParam("name") name: String): Response {
        val connect = FireBirdRepoImpl().connectDB()
        var result = Response.ok("is warning ${connect.warnings}").build()
        if (connect.isValid(1)) {
            result = Response.ok("is valid").build()
        }
        connect.close()
        return result
    }
}