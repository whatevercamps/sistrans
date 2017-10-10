package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Cliente;
import vos.Producto;

public class DAOTablaProductos {
	private ArrayList<Object> recursos;
	private Connection conn;



	public DAOTablaProductos() {
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

	public List<Producto> darProductos() throws SQLException, Exception {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		String sentencia = "SELECT * FROM PRODUCTOS";
		PreparedStatement stamnt = conn.prepareStatement(sentencia);
		recursos.add(stamnt);
		ResultSet rs = stamnt.executeQuery();
		int a = 1;
		while(rs.next()) {
			Producto producto = new Producto();
			producto.setId(rs.getLong("ID"));
			producto.setNombre("Producto" + a);
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			productos.add(producto);
			a++;
		}
		return productos;
	}

	public Producto darProducto(Long id) throws SQLException, Exception {
		Producto producto = new Producto();

		String sqlProductoPorId = "SELECT * FROM PRODUCTOS, BEBIDAS WHERE BEBIDAS.ID_PRODUCTO = PRODUCTOS.ID AND PRODUCTOS.ID = " + id; 
		PreparedStatement stProductoPorId = conn.prepareStatement(sqlProductoPorId);
		recursos.add(stProductoPorId);
		ResultSet rs = stProductoPorId.executeQuery();

		if (rs.next()) {
			producto.setId(rs.getLong("ID"));
			producto.setNombre(rs.getString("NAME"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			return producto;
		}
		
		sqlProductoPorId = "SELECT * FROM PRODUCTOS, POSTRES WHERE POSTRES.ID_PRODUCTO = PRODUCTOS.ID AND PRODUCTOS.ID = " + id; 
		stProductoPorId = conn.prepareStatement(sqlProductoPorId);
		recursos.add(stProductoPorId);
		rs = stProductoPorId.executeQuery();

		if (rs.next()) {
			producto.setId(rs.getLong("ID"));
			producto.setNombre(rs.getString("NAME"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			return producto;
		}

		sqlProductoPorId = "SELECT * FROM PRODUCTOS, ENTRADAS WHERE ENTRADAS.ID_PRODUCTO = PRODUCTOS.ID AND PRODUCTOS.ID = " + id; 
		stProductoPorId = conn.prepareStatement(sqlProductoPorId);
		recursos.add(stProductoPorId);
		rs = stProductoPorId.executeQuery();

		if (rs.next()) {
			producto.setId(rs.getLong("ID"));
			producto.setNombre(rs.getString("NAME"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			return producto;
		}
		
		sqlProductoPorId = "SELECT * FROM PRODUCTOS, PLATOSFUERTES WHERE PLATOSFUERTES.ID_PRODUCTO = PRODUCTOS.ID AND PRODUCTOS.ID = " + id; 
		stProductoPorId = conn.prepareStatement(sqlProductoPorId);
		recursos.add(stProductoPorId);
		rs = stProductoPorId.executeQuery();

		if (rs.next()) {
			producto.setId(rs.getLong("ID"));
			producto.setNombre(rs.getString("NAME"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			return producto;
		}
		
		return null;
	}
}
