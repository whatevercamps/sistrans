package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dao.DAOTablaPedidos;
import tm.AlohAndesTM;
import vos.Cliente;
import vos.Informe;
import vos.Producto;
import vos.ProductoBase;

@Path("admin")
public class RotondAndesResource {
	
	@XmlRootElement
	public static class RequestBody {
	    @XmlElement Object parametro;
	}
	
	
	@Context
	private ServletContext context;
	

	@GET
	@Path("productos")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({MediaType.APPLICATION_JSON})
	public Response getProductosPor(@QueryParam("filtro") Integer ident, @QueryParam("parametro") String parametro) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<Producto> productos;
		try {
			productos = tm.darProductosPor(ident, parametro);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(productos).build();
		
	}
	
	@GET
	@Path("clientes")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getClientes() {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<Cliente> clientes;
		try {
			clientes = tm.darClientes();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clientes).build();
		
	}
	
	@GET
	@Path("clientes/{id: \\d+}")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getCliente(@PathParam("id") Long id) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		try {
			Cliente cliente = tm.darCliente(id);
			return Response.status( 200 ).entity( cliente ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@GET
	@Path("rentabilidad")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getRentabilidadAdmin(@QueryParam("filtro") Integer filtro, @QueryParam("initDate") String initDate, @QueryParam("endDate") String endDate) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		
		
		List<Informe> rentabilidad;
		try {
			rentabilidad= tm.darRentabilidad(DAOTablaPedidos.ADMIN, filtro, initDate, endDate);
			return Response.status( 200 ).entity( rentabilidad ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@GET
	@Path("rentabilidad/Rotondas")
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getRentabilidadRotondas(@QueryParam("filtro") Integer filtro, @QueryParam("initDate") String initDate, @QueryParam("endDate") String endDate) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		
		
		List<Informe> rentabilidad;
		try {
			rentabilidad= tm.darRentabilidadUnificada(DAOTablaPedidos.ADMIN, filtro, initDate, endDate);
			return Response.status( 200 ).entity( rentabilidad ).build( );		
		}catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	
	
	
}
