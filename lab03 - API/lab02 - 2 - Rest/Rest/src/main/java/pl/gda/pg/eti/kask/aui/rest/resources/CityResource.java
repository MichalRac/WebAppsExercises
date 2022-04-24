package pl.gda.pg.eti.kask.aui.rest.resources;

import pl.gda.pg.eti.kask.aui.rest.entities.Book;
import pl.gda.pg.eti.kask.aui.rest.entities.City;
import pl.gda.pg.eti.kask.aui.rest.servlet.CityContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@Path("/city")
public class CityResource
{
    public static final String CITY_CONTEXT = "bookContext";

    @Context
    ServletContext context;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    private CityContext getCityContext()
    {
        CityContext cityContext = (CityContext) context.getAttribute(CITY_CONTEXT);
        if(cityContext == null)
        {
            cityContext = new CityContext();
            context.setAttribute(CITY_CONTEXT, cityContext);
        }
        return cityContext;
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> listCities()
    {
        return getCityContext().findAllCities();
    }

    @GET
    @Path("find/{id:[0-9]+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public City findCity(@PathParam("id") Integer id) {
        return getCityContext().findCity(id);
    }

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public City findCity2(@DefaultValue("-1") @QueryParam("city_id") Integer cityId) {
        return getCityContext().findCity(cityId);
    }
}
