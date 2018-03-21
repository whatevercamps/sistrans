package dtm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import com.rabbitmq.jms.admin.RMQDestination;

import dao.DAOTablaPedidos;
import jms.NonReplyException;
//import jms.ProductosMDB;
//import jms.RegistrarPedidoMDB;
import jms.RentabilidadRestaurantesMDB;
//import jms.RetirarRestauranteMDB;
//import jms.TodosLosProductosMDB;
import tm.AlohAndesTM;
import vos.Informe;
import vos.ListaRentabilidad;
import vos.Pedido;

import vos.Producto;
import vos.RentabilidadRestaurante;
import vos.Restaurante;

public class RotondAndesDistributed {
	private final static String QUEUE_NAME = "java:global/RMQAppQueue";
	private final static String MQ_CONNECTION_NAME = "java:global/RMQClient";
	
	private static RotondAndesDistributed instance;
	
	private AlohAndesTM tm;
	
	private QueueConnectionFactory queueFactory;
	
	private TopicConnectionFactory factory;
	
	private RentabilidadRestaurantesMDB rentabilidadRestaurantesMQ;
	
//	private TodosLosProductosMDB todosLosProductosMQ;
	
//	private ProductosMDB productosMQ;
	
//	private RetirarRestauranteMDB retirarRestauranteMQ;
	
//	private RegistrarPedidoMDB registrarPedidoMQ;
	
	private static String path;
	
	private RotondAndesDistributed() throws NamingException, JMSException
	{
		InitialContext ctx = new InitialContext();
		factory = (RMQConnectionFactory) ctx.lookup(MQ_CONNECTION_NAME);
		rentabilidadRestaurantesMQ = new RentabilidadRestaurantesMDB(factory, ctx);
//		todosLosProductosMQ = new TodosLosProductosMDB(factory, ctx);
//		productosMQ = new ProductosMDB(factory, ctx);
//		retirarRestauranteMQ = new RetirarRestauranteMDB(factory, ctx);
//		registrarPedidoMQ = new RegistrarPedidoMDB(factory, ctx);
//		todosLosProductosMQ.start();
		rentabilidadRestaurantesMQ.start();
//		productosMQ.start();
//		retirarRestauranteMQ.start();;
//		registrarPedidoMQ.start();
	}
	
	public void stop() throws JMSException
	{
//		productosMQ.close();
//		todosLosProductosMQ.close();
		rentabilidadRestaurantesMQ.close();
//		retirarRestauranteMQ.close();
//		registrarPedidoMQ.close();
	}
	
	/**
	 * Método que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	public static void setPath(String p) {
		path = p;
	}
	
	public void setUpTransactionManager(AlohAndesTM tm)
	{
	   this.tm = tm;
	}
	
	private static RotondAndesDistributed getInst()
	{
		return instance;
	}
	
	public static RotondAndesDistributed getInstance(AlohAndesTM tm)
	{
		if(instance == null)
		{
			try {
				instance = new RotondAndesDistributed();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		instance.setUpTransactionManager(tm);
		return instance;
	}
	
	public static RotondAndesDistributed getInstance()
	{
		if(instance == null)
		{
			AlohAndesTM tm = new AlohAndesTM(path);
			return getInstance(tm);
		}
		if(instance.tm != null)
		{
			return instance;
		}
		AlohAndesTM tm = new AlohAndesTM(path);
		return getInstance(tm);
	}
	/**
	 * Método que obtiene las Rentabilidades Locales.
	 * @param stringParams
	 * @return
	 * @throws Exception
	 */
	public ListaRentabilidad getLocalRentabilidades(String stringParams)throws Exception
	{
		String [] arrayParams = stringParams.split(",");
		String initDate = arrayParams[0];
		String endDate = arrayParams[1];
		int filtro = Integer.parseInt(arrayParams[2]);
		Long idProducto = null;
		if(!arrayParams[3].equals("null"))
		{
			idProducto = Long.parseLong(arrayParams[3]);
		}
			
		List<Informe> lista = tm.darRentabilidad(DAOTablaPedidos.ADMIN, filtro, initDate, endDate);
		List<RentabilidadRestaurante> listConv = new ArrayList<RentabilidadRestaurante>();
		for (Informe inf : lista) {
			RentabilidadRestaurante rentConv = new RentabilidadRestaurante(inf);
			listConv.add(rentConv);
			
		}
		return new ListaRentabilidad(listConv);
	}
	/**
	 * Método que obtiene las Rentabilidades de las otras bases de Datos.
	 * @param parametrosUnidos
	 * @return
	 * @throws Exception
	 */
	public ListaRentabilidad getRemoteRentabilidades(String parametrosUnidos)throws Exception
	{
		return rentabilidadRestaurantesMQ.getRemoteRentabilidades(parametrosUnidos);
	}
	
	
	
}
