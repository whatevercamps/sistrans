package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import vos.Ingrediente;
import vos.Producto;
import vos.ProductoBase;
import vos.RotondAndes;

public class DAOTablaProductos {
	private ArrayList<Object> recursos;
	private Connection conn;

	public static final int RESTAURANTE = 1;
	public static final int CATEGORIA = 2;
	public static final int RANGO_PRECIOS= 3;
	public static final int ORDEN = 4;

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

		String sentencia = "SELECT * FROM PRODUCTOS FETCH FIRST 100 ROWS ONLY";
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


	public Producto darProducto(Long id, Long idRest) throws SQLException, Exception {
		String sqlProductoPorId = "SELECT * FROM PRODUCTOS, PRODUCTO_RESTAURANTE WHERE ID_PROD = ID AND ID_PROD = " + id + " AND ID_REST =" + idRest + " FETCH FIRST 100 ROWS ONLY"; 
		PreparedStatement stProductoPorId = conn.prepareStatement(sqlProductoPorId);
		recursos.add(stProductoPorId);
		ResultSet rs = stProductoPorId.executeQuery();

		if (rs.next()) {
			Producto producto = new Producto();
			producto.setId(rs.getLong("ID_PROD"));
			producto.setNombre(rs.getString("NAME"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			producto.setCategoria(rs.getString("CATEGORIA"));
			producto.setPrecio(rs.getDouble("PRECIO"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setProductosEquivalentes(darProductosEquivalentes(producto.getId(), rs.getLong("ID_REST")));
			
			return producto;
		}
		return null;
	}


	private List<ProductoBase> darProductosEquivalentes(Long id, Long idRest)  throws SQLException, Exception {
		String sql = "SELECT * FROM PRODUCTOS, PRODUCTO_RESTAURANTE, PRODUCTOSSIMILARES WHERE ID = ID_PROD AND ID_PROD2 = ID_PROD AND ID_REST = "; 
		sql += idRest + " AND ID_PROD1 = "  + id + " FETCH FIRST 100 ROWS ONLY"; 
		System.out.println(sql);
		PreparedStatement st = conn.prepareStatement(sql);
		recursos.add(st);
		ResultSet rs = st.executeQuery();
		
		List<ProductoBase> prods = new ArrayList<>();
		
		while (rs.next()) {
			ProductoBase prod = new ProductoBase();
			prod.setId(rs.getLong("ID"));
			prod.setNombre(rs.getString("NAME"));
			prod.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			prod.setDescripcionIngles(rs.getString("DESCRIPTION"));
			prod.setCategoria(rs.getString("CATEGORIA"));
			prods.add(prod);
		}
		return prods;
	}



	public List<Producto> darProductosPor(Integer filtro, String parametro) throws SQLException, Exception{
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String sentencia = "SELECT * FROM PRODUCTOS, PRODUCTO_RESTAURANTE WHERE ID = ID_PROD ";

		switch(filtro) {

		case RESTAURANTE:
			sentencia +=  "AND ID_REST = " + Integer.parseInt(parametro);
			break;

		case CATEGORIA: 
			sentencia += "AND CATEGORIA = '" + ((String) parametro) + "'";
			System.out.println("sentencia -> " + sentencia);
			break;
			
		case RANGO_PRECIOS:
			String[] precios = parametro.split(",");
			sentencia += "AND PRECIO >= " + Integer.parseInt(precios[0]) + " AND  PRECIO <= " + Integer.parseInt(precios[1]);
			break;
			
		case ORDEN: 
			sentencia =" SELECT * FROM PRODUCTOS, PRODUCTO_RESTAURANTE, PEDIDOS ";
			sentencia +=  "WHERE PRODUCTOS.ID = ID_PROD AND PEDIDOS.ID_PRODUCTO = ID_PROD AND PEDIDOS.ID_RESTAURANTE = ID_REST AND ID_ORDEN = " + Integer.parseInt(parametro);
		default:
			break;
		}

		sentencia += " FETCH FIRST 100 ROWS ONLY"; 
		PreparedStatement stamnt = conn.prepareStatement(sentencia);
		recursos.add(stamnt);
		ResultSet rs = stamnt.executeQuery();
		while(rs.next()) {
			Producto producto = new Producto();
			producto.setId(rs.getLong("ID_PROD"));
			producto.setNombre(rs.getString("NAME"));
			producto.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			producto.setDescripcionIngles(rs.getString("DESCRIPTION"));
			producto.setCategoria(rs.getString("CATEGORIA"));
			producto.setPrecio(rs.getDouble("PRECIO"));
			producto.setCostoDeProduccion(rs.getDouble("COSTO_PRODUCCION"));
			producto.setProductosEquivalentes(darProductosEquivalentes(producto.getId(), rs.getLong("ID_REST")));
			productos.add(producto);
		}
		System.out.println("------------> sentencia:  " + sentencia);
		return productos;
		
	}



	public List<ProductoBase> darPreferencias(Long id)  throws SQLException, Exception{
		List<ProductoBase> preferencias = new ArrayList<>();
		
		String sql = "SELECT * FROM PRODUCTOS, PREFERENCIAS WHERE ID_PRODUCTO = ID AND ID_CLIENTEFRECUENTE = " + id + " FETCH FIRST 100 ROWS ONLY";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next()) {
			ProductoBase prod = new ProductoBase();
			prod.setId(rs.getLong("ID"));
			prod.setNombre(rs.getString("NAME"));
			prod.setDescripcionEspaniol(rs.getString("DESCRIPCION"));
			prod.setDescripcionIngles(rs.getString("DESCRIPTION"));
			prod.setCategoria(rs.getString("CATEGORIA"));
			
			preferencias.add(prod);
		}
		return preferencias;
	}




}
