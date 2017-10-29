package vos;

import java.time.LocalDateTime;


import org.codehaus.jackson.annotate.*;

public class Pedido {

	private class RestaurantePedido {

		@JsonProperty(value = "idRest")
		private Long idRest;

		@JsonProperty(value = "nameRest")
		private String nameRest;

		public RestaurantePedido(
				@JsonProperty(value = "idRest") Long idRest,
				@JsonProperty(value = "nameRest") String nameRest) {
			this.idRest = idRest;
			this.nameRest = nameRest;
		}
		
		public Long getId() {
			return this.idRest;
		}
		
		public void setId(Long id) {
			this.idRest = id;
		}
		
		public String getName() {
			return nameRest;
		}
		
		public void setName(String name) {
			this.nameRest = name;
		}
	};

	private class ClientePedido {
		@JsonProperty(value = "idCliente")
		private Long idCliente;

		@JsonProperty(value = "nameCliente")
		private String nameCliente;
		
		public ClientePedido(
				@JsonProperty(value = "idCliente") Long idCliente,
				@JsonProperty(value = "nameCliente") String nameCliente) {
			
			this.idCliente = idCliente;
			this.nameCliente = nameCliente;
		}
		
		public Long getId() {
			return this.idCliente;
		}
		
		public void setId(Long id) {
			this.idCliente = id;
		}
		
		public String getName() {
			return this.nameCliente;
		}
		
		public void setName(String name) {
			this.nameCliente = name;
		}
		
	};


	/**
	 * Atributo que contiene el ID de este pedido.
	 */
	@JsonProperty(value = "id")
	private Long id;

	/**
	 * Atributo que contiene el producto pedido.
	 */
	@JsonProperty(value = "producto")
	private Producto producto; 
	/**
	 * Atributo que contiene la fecha de este pedido.
	 */
	@JsonProperty(value = "fecha")
	private LocalDateTime fecha;

	/**
	 * Atributo que contiene si este pedido ya ha sido servido o no.
	 */
	@JsonProperty(value = "servido")
	private Boolean servido;


	@JsonProperty(value = "restaurantePedido")
	private RestaurantePedido restaurantePedido;

	@JsonProperty(value = "clientePedido")
	private ClientePedido cliente;

	/**
	 * Método constructor de la clase Pedido.
	 * @param id Long, ID del pedido.
	 * @param cliente Cliente, Cliente dueño del pedido.
	 * @param producto Producto, producto ordenado.
	 * @param fecha LocalDateTime, fecha en que se hizo el pedido.
	 * @param servido Boolean, Booleano que determina si el pedido ya ha sido entregado o no.
	 * @param restaurante Restaurante, restaurante dueño del pedido.
	 */
	public Pedido(@JsonProperty(value = "id") Long id, 
			@JsonProperty(value = "idCliente") Long idCliente,
			@JsonProperty(value = "nameCliente") String nameCliente,
			@JsonProperty(value = "producto") Producto producto,
			@JsonProperty(value = "fecha") LocalDateTime fecha,
			@JsonProperty(value = "servido") Boolean servido,
			@JsonProperty(value = "idRest") Long idRest,
			@JsonProperty(value = "nameRest") String nameRest
			) {
		this.id = id;
		this.cliente = new ClientePedido(idCliente, nameCliente);
		this.producto = producto;
		this.fecha = fecha; 
		this.servido = servido;
		this.restaurantePedido = new RestaurantePedido(idRest, nameRest);
	}
	public Pedido() {}
	/**
	 * Método que obtiene el ID del pedido.
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * Método que establece el ID del pedido.
	 * @param id Long, nuevo ID del pedido.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que obtiene el Producto pedido en este Pedido.
	 * @return Producto, producto del pedido.
	 */
	public Producto getProducto() {
		return this.producto;
	}
	/**
	 * Método que obtiene la fecha de este Pedido.
	 * @return LocalDateTime, fecha del Pedido.
	 */
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	/**
	 * Método que obtiene un booleano que determina si el pedido ha sido entregado o no.
	 * @return Boolean, booleano que determina si el pedido ha sido entregado o no.
	 */
	public Boolean getServido() {
		return this.servido;
	}
	
	
	/**
	 * Método que establece el Producto en este Pedido.
	 * @param producto Producto, nuevo Producto del Pedido.
	 */
	public void setProducto(Producto producto) {
		this.producto = producto; 
	}
	/**
	 * Método que establece la fecha de este Pedido.
	 * @param fecha LocalDateTime, nueva fecha de este Pedido.
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha; 
	}
	/**
	 * Método que establece si este pedido ha sido servido o no.
	 * @param servido Boolean, 
	 */
	public void setServido(Boolean servido) {
		this.servido = servido; 
	}
	/**
	 * Método que obtiene el Restaurante de este pedido.
	 * @return Restaurante.
	 */
	public Long getIdRest() {
		return this.restaurantePedido.getId();
	}
	
	public void setIdRest(Long idRest) {
		this.restaurantePedido.setId(idRest);
	}
	
	public String getNameRest() {
		return this.restaurantePedido.getName();
	}
	
	public void setNameRest(String nameRest) {
		this.restaurantePedido.setName(nameRest);
	}
	
	public Long getIdCliente() {
		return this.cliente.getId();
	}
	
	public void setIdCliente(Long idCliente) {
		this.cliente.setId(idCliente);
	}
	
	public String getNameCliente() {
		return this.cliente.getName();
	}
	
	public void setNameCliente(String nameCliente) {
		this.cliente.setName(nameCliente);
	}
	
	public void setCliente(Long idCliente, String nameCliente) {
		this.cliente = new ClientePedido(idCliente, nameCliente);
	}
	
	public void setRestaurante(Long idRest, String nameRest) {
		this.restaurantePedido = new RestaurantePedido(idRest, nameRest);
	}
}
