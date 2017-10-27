package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Zona;
import vos.Condicion;
import vos.Producto;
import vos.Restaurante;

/**
 * Clase que administra las reglas de funcionamiento de una Zona.
 * @author Usuario
 *
 */
public class DAOTablaZonas
{
	/**
	 * Constante que contiene si la solicitud es respecto a una condiciÛn tÈcnica.
	 */
	public final static Integer CONDICIONTECNICA = 0;
	/**
	 * Constante que contiene si la solicitud es respecto a un Restaurante.
	 */
	public final static Integer CONTAINSRESTAURANTE = 1 ;
	/**
	 * Constante que contiene si la solicitud es respecto a un Producto en la zona.
	 */
	public final static Integer CONTAINSPRODUCTO = 2;
	/**
	 * Constante que contiene si la solicitud es respecto al nombre de la zona.
	 */
	public final static Integer ZONA = 3;
	/**
	 * Constante que contiene si la solicitud respecto a si es espacio abierto o no
	 */
	public final static Integer ESESPACIOABIERTO = 4;
	/**
	 * Constante que contiene si la solicitud respecto a si es incluyente o no
	 */
	public final static Integer ESINCLUYENTE = 5;
	/**
	 * Constante que contiene si la solicitud es alrededor de la capacidad. Puede haber capacidad, o rango de capacidades.
	 */
	public final static Integer CAPACIDAD = 6;

	/**
	 * Arraylits de recursos que se usan para la ejecuci√≥n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexi√≥n a la base de datos
	 */
	private Connection conn;

	/**
	 * M√©todo constructor que crea DAOTablaReservasCarga
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public  DAOTablaZonas()
	{
		recursos = new ArrayList<Object>();
	}

	/**
	 * M√©todo que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos()
	{
		for (Object ob : recursos)
		{
			if (ob instanceof PreparedStatement)
				try
			{
					((PreparedStatement) ob).close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}


	/**
	 * M√©todo que inicializa la connection del DAO a la base de datos con la conexi√≥n que entra como par√°metro.
	 * @param con  - connection a la base de datos
	 * @throws SQLException 
	 */
	public void setConn(Connection con) throws SQLException
	{
		this.conn = con;

	}
	/**
	 * MÈtodo que agrega una zona.
	 * @param zona Zona con una lista de Restaurantes, los cuales todos est·n en la base de datos.
	 * @throws SQLException
	 * @throws Exception
	 */
	public void addZona(Zona zona) throws SQLException, Exception{

		String sqlZonaConID = "SELECT * FROM ZONAS WHERE ID = " + zona.getId();
		PreparedStatement prepStmtID= conn.prepareStatement(sqlZonaConID);
		recursos.add(prepStmtID);
		ResultSet rsID = prepStmtID.executeQuery();

		if(rsID.next()){
			throw new Exception ("Zona con ID dado ya existe.");
		}


		//ZONA EN QUE SE AGREGA LA ZONA
		String sql = "INSERT INTO ZONAS VALUES (";
		sql += zona.getId() + ",'";
		sql += zona.getNombre() + "', ";
		sql += (zona.getEsEspacioAbierto()? 1 : 0) + ",";
		sql += zona.getCapacidad() + ", ";
		sql += (zona.getEsIncluyente() ? 1 : 0) + ", ";
		sql += ")";


		if(zona.getCondiciones() != null){
			String sqlCondiciones = "SELECT * FROM CONDICIONESTECNICAS";

			PreparedStatement prepStmtCondiciones = conn.prepareStatement(sqlCondiciones);
			recursos.add(prepStmtCondiciones);
			ResultSet rsCondiciones = prepStmtCondiciones.executeQuery();
			List<Condicion> condiciones = zona.getCondiciones();

			for(Condicion cond : condiciones){
				sql += ("\n" + "INSERT INTO CONDICIONZONA VALUES (" + zona.getId() +", "+ cond.getId() +");" );
			}
		}

		System.out.println("SQL statement: " + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);

		prepStmt.executeQuery();
	}

	public Zona darZona(Long id)  throws SQLException, Exception{

		Zona zona = null;

		String sql = "SELECT * FROM ZONAS WHERE ID = " + id;
		PreparedStatement st = conn.prepareStatement(sql);
		recursos.add(st);

		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			zona = new Zona();

			zona.setId(rs.getLong("ID"));
			zona.setNombre(rs.getString("NAME"));
			zona.setEsEspacioAbierto(rs.getBoolean("ESPACIO_ABIERTO"));
			zona.setCapacidad(rs.getInt("CAPACIDAD"));;
			zona.setEsIncluyente(rs.getBoolean("INCLUYENTE"));
		}
		return zona;
	}



}
