package rest;

import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.ObjectMapper;

import rest.ClienteResorce.RequestBody;
import tm.AlohAndesTM;
import vos.Zona;
import vos.Pedido;
import vos.Producto;

@Path("zonas")
@Produces("application/json")
@Consumes("application/json")
public class ZonasResource
{
	@XmlRootElement
	public static class RequestBody {
	    @XmlElement Long id;
	    @XmlElement String nombre;
	    @XmlElement Boolean esEspacioAbierto;
	    @XmlElement Integer capacidad;
	    @XmlElement Boolean esIncluyente;
	    @XmlElement List<String> condiciones;
	}
	
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	
	@GET
	@Path("{idZona: \\d+}")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getZona(@PathParam("idZona") Long idZona) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		try {
			Zona zona = tm.darZona(idZona);
			return Response.status( 200 ).entity( zona ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response agregarZona(Zona zona) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		try {
			
			Zona res = tm.agregarZona(zona);
			return Response.status( 200 ).entity( res ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	
}
