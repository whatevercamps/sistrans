package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import vos.Cliente;
import vos.Pedido;
import vos.Producto;
import vos.Restaurante;

public class DAOTablaPedidos {

	public static final int SIN_DESPACHAR_DE_MESA = 1;

	private ArrayList<Object> recursos;
	private Connection conn;


	public DAOTablaPedidos() {
		recursos = new ArrayList<Object>();
	}


	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public Long darIdMax() throws SQLException, Exception {
		String sql = "SELECT COUNT(*) AS CONT FROM PEDIDOS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		if(rs.next())
			return rs.getLong("CONT") + 1;
		return 0L;
	}





	public Pedido registrarPedido(Cliente cliente, Producto producto, Restaurante rest) throws SQLException, Exception{
		Long id =  darIdMax();	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDate = LocalDateTime.now();
		String sql = "INSERT INTO PEDIDOS (ID, ID_CLIENTE, ID_PRODUCTO, FECHA, SERVIDO, ID_ORDEN, ID_RESTAURANTE) VALUES (";
		sql += id + ", ";
		sql += cliente.getId() + ", ";
		sql += producto.getId() + ", ";
		sql += "TIMESTAMP '" + dtf.format(localDate) + "', 0, ";
		sql += cliente.getOrdenes().get(cliente.getOrdenes().size()-1).getId() + ", ";
		sql += rest.getId() + ")";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();



		return new Pedido(id, cliente.getId(), cliente.getNombre(), producto, localDate, false, rest.getId(), rest.getName());
	}


	public void despacharPedido(Long idPed) throws SQLException, Exception{
		String sql = "UPDATE PEDIDOS SET SERVIDO = 1 WHERE ID = " + idPed;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}



	public void cancelarPedido(Long idPed) throws SQLException, Exception
	{
		String  sql = "SELECT SERVIDO FROM PEDIDOS WHERE ID = '" + idPed + "'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while(rs.next())
		{
			boolean servido = rs.getLong("SERVIDO")==1;
			if(!servido)
			{
				sql = "DELETE FROM PEDIDOS WHERE ID = '" + idPed+ "'" ;
				prepStmt = conn.prepareStatement(sql);
				recursos.add(prepStmt);
				prepStmt.executeUpdate();

			}
		}

	}
	/*
	public  ArrayList<Pedido> registrarPedidos(Cliente cliente, ArrayList<Pedido> pedidos) throws SQLException, Exception
	{
		System.out.println("dsjkfsldkf");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDate = LocalDateTime.now();
		String sql = "";
		for (Pedido pedido : pedidos) 
		{
			sql = "INSERT INTO PEDIDOS (ID, ID_CLIENTE, ID_PRODUCTO, FECHA, SERVIDO, ID_ORDEN, ID_RESTAURANTE, MESA) VALUES (";
					sql += darIdMax() + ", ";
					sql += cliente.getId() + ", ";
					sql += pedido.getId() + ", ";
					sql += "TIMESTAMP '" + dtf.format(localDate) + "', 0, ";
					sql += cliente.getOrdenes().get(cliente.getOrdenes().size()-1).getId() + ", ";
					sql += pedido.getIdRestaurante() + "','";
					sql += pedido.getMesa() + "')";
					PreparedStatement prepStmt = conn.prepareStatement(sql);
					recursos.add(prepStmt);
					prepStmt.executeUpdate();
		}

		return pedidos;
	}
	 */


	public List<Pedido> darPedidos(int filtro, String parametro)throws SQLException, Exception {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		String sentencia = "SELECT * FROM PEDIDOS";

		switch(filtro) {

		case SIN_DESPACHAR_DE_MESA:
			sentencia += " WHERE SERVIDO = 0 AND MESA = " + Integer.parseInt(parametro);
			break;

		default:
			break;
		}

		PreparedStatement stamnt = conn.prepareStatement(sentencia);
		recursos.add(stamnt);
		ResultSet rs = stamnt.executeQuery();
		while(rs.next()) {
			Pedido pedido = new Pedido();
			pedido.setId(rs.getLong("ID"));
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDate = LocalDateTime.parse(rs.getString("FECHA"), dtf);
			
			pedido.setFecha(localDate);
			pedido.setServido(rs.getBoolean("SERVIDO"));
			pedido.setCliente(rs.getLong("ID_CLIENTE"), new String("holi"));
			Producto prodTemp = new Producto();
			prodTemp.setId(rs.getLong("ID_PRODUCTO"));
			pedido.setProducto(prodTemp);
			pedidos.add(pedido);
		}
		System.out.println("------------> sentencia:  " + sentencia);
		return pedidos;
	}
}