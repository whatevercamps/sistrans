package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.ClienteFrecuente;

public class DAOTablaClientesFrecuentes {
	
	private ArrayList<Object> recursos;
	private Connection conn;
	
	

	public DAOTablaClientesFrecuentes() {
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

	public void borrarPreferencia(Long idCliente, Long idProd) throws SQLException, Exception{
		String sql = "DELETE FROM PREFERENCIAS WHERE ID_CLIENTEFRECUENTE = ";
		sql += idCliente + "AND ID_PRODUCTO = " + idProd;
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void registrarPreferencia(Long idCliente, Long idProd) throws SQLException, Exception {
		String sql = "INSERT INTO PREFERENCIAS (ID_CLIENTEFRECUENTE, ID_PRODUCTO) VALUES (";
		sql += idCliente + ", ";
		sql += idProd + ")";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
