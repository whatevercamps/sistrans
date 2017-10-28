package rest;

import java.sql.SQLException;
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

import tm.RotondAndesTM;
import vos.Cliente;
import vos.Pedido;
import vos.Producto;
import vos.Restaurante;



/**
 * Clase que expone servicios REST con ruta base: http://<ip o nombre del host>:8080/RotondAndes/rest/clientes/...
 * @author David Bautista
 */

@Path("cliente")
public class ClienteResorce {

	@XmlRootElement
	public static class RequestBody {
	    @XmlElement Long idProd;
	    @XmlElement Long idRestProd;
	}
	
	
	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	

	@POST
	@Path("{id: \\d+}/pedidos")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response agregarPedido(@PathParam("id") Long id, @QueryParam("idProd") Long idProd, @QueryParam("idRest") Long idRestProd) throws SQLException, Exception {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		
		Restaurante res = tm.darRestaurante(idRestProd);
		if(res == null) {
			return Response.status( 404 ).entity( "{ \"ERROR\": \""+ "NO SE ENCUENTRA EL RESTAURANTE" + "\"}" ).build( );
		}
		
		
		
		try {
			Pedido pedido = tm.agregarPedido(id, idProd, res.getId());
			 
			return Response.status( 200 ).entity( pedido ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	
	
}
