package rest;

import java.util.ArrayList;
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
import vos.Pedido;
import vos.Producto;
import vos.Restaurante;

@Path("restaurante")
public class RestauranteResource {

	
	
	
	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}



	@GET
	@Path("{idRest: \\d+}/productos/{idProd: \\d+}")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getProducto(@PathParam("idRest") Long idRest, @PathParam("idProd") Long idProd) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Producto producto = tm.darProducto(idProd, idRest);
			System.out.println("FINAL ingredientes: " + producto.getIngredientes().size());
			return Response.status( 200 ).entity( producto ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}



	@PUT
	@Path("{id: \\d+}/pedidos/{idPedido: \\d+}")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response despacharPedido(@PathParam("id") Long idRest, @PathParam("idPedido") Long idPed) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {	 
			tm.despacharPedido(idPed);
			return Response.status( 200 ).entity( "{ \"RESPUESTA\": \" Pedido despachado \"}" ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@PUT
	@Path("{id: \\d+}/pedidos")
	@Consumes( { MediaType.APPLICATION_JSON } )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response despacharPedidosMesa(@PathParam("id") Long idRest, @QueryParam("idMesa") Long idMesa) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {	
			tm.despacharPedidosMesa(idMesa, idRest);
			return Response.status( 200 ).entity( "{ \"RESPUESTA\": \" Pedidos despachado \"}" ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@DELETE
	@Path("{id: \\d+}/pedido")
	@Consumes( { MediaType.APPLICATION_JSON } )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response CancelarPedido(@PathParam("idPedido")Long idPed) 
	{
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {	 
			tm.cancelarPedido(idPed);
			return Response.status( 200 ).entity( "{ \"RESPUESTA\": \" Pedido despachado \"}" ).build();	
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}


}
