package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Cliente;
import vos.Producto;

public class DAOTablaClientes {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOTablaClientes() {
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


	public List<Cliente> darClientes() throws SQLException, Exception {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		String sentencia = "SELECT * FROM CLIENTES";
		PreparedStatement stamnt = conn.prepareStatement(sentencia);
		recursos.add(stamnt);
		ResultSet rs = stamnt.executeQuery();

		while(rs.next()) {
			String name = rs.getString("NAME");
			Long id = rs.getLong("ID");
			Integer mesa = rs.getInt("MESA"); 
			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setNombre(name);
			cliente.setMesa(mesa);
	
			clientes.add(cliente);
		}
		return clientes;
	}




	public Cliente darCliente(Long id) throws SQLException {
		Cliente clientePorId = null;

		String sqlClientePorId = "SELECT * FROM CLIENTES WHERE ID =" + id; 
		PreparedStatement stClientePorId = conn.prepareStatement(sqlClientePorId);
		recursos.add(stClientePorId);
		ResultSet rsClientePorId = stClientePorId.executeQuery();

		if (rsClientePorId.next()) {
			Long id2 = rsClientePorId.getLong("ID");
			String nameclientePorId = rsClientePorId.getString("NAME");
			Integer mesaClientePorId = rsClientePorId.getInt("MESA");
			clientePorId = new Cliente();
			clientePorId.setId(id2);
			clientePorId.setNombre(nameclientePorId);
			clientePorId.setMesa(mesaClientePorId);
		}

		return clientePorId;
	}

}
