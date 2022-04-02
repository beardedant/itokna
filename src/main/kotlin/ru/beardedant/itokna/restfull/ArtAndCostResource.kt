package ru.beardedant.itokna.restfull

import org.springframework.stereotype.Component
import ru.beardedant.itokna.domain.FireBirdRepoImpl
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Component
@Path("status/{id}")
class ArtAndCostResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    fun resultList(@PathParam ("id") id :Int) = FireBirdRepoImpl().getDataFromDB(id).toString()
}