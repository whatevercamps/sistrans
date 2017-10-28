package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.TipoComida;

public class DAOTablaTipos {

	private ArrayList<Object> recursos;
	private Connection conn;


	public DAOTablaTipos() {
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


	public List<TipoComida> darTiposComidaProducto(Long id) throws SQLException, Exception {
		List<TipoComida> tipos = new ArrayList<TipoComida>();
		
		String sql = "SELECT * FROM TIPOPRODUCTO, TIPOS WHERE ID = ID_TIPO AND ID_PROD = " + id; 
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next()) {
			TipoComida tipo = new TipoComida(rs.getLong("ID_TIPO"), rs.getString("NAME"));
			
			tipos.add(tipo);
		}
		return tipos;
	}
}
