package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import vos.Orden;

public class DAOTablaOrdenes {
	
	private ArrayList<Object> recursos;
	private Connection conn;


	public DAOTablaOrdenes() {
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


	public List<Orden> darOrdenesCliente(Long idCliente) throws SQLException, Exception {
		
		List<Orden> ordenes = new ArrayList<Orden>();
		
		String sql = "SELECT * FROM PEDIDOS, ORDENES WHERE PEDIDOS.ID_ORDEN = ORDENES.ID AND ID_CLIENTE = " + idCliente + " FETCH FIRST 100 ROWS ONLY";
		System.out.println("sentencia darOrdenesClientes: " + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next()){
			Orden orden = new Orden();
			orden.setId(rs.getLong("ID_ORDEN"));
			orden.setCostoTotal(rs.getDouble("COSTOTOTAL"));		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			

			LocalDateTime localDate = LocalDateTime.parse(rs.getString("FECHA"), dtf);
			orden.setFecha(localDate);
			ordenes.add(orden);
		}
		return ordenes;
	}

}
