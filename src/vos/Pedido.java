package vos;

import java.time.LocalDateTime;


import org.codehaus.jackson.annotate.*;

public class Pedido {
	
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "cliente")
	private Cliente cliente;
	@JsonProperty(value = "producto")
	private Producto producto; 
	@JsonProperty(value = "fecha")
	private LocalDateTime fecha;
	@JsonProperty(value = "servido")
	private Boolean servido;
	
	public Pedido(@JsonProperty(value = "id") Long id, 
			@JsonProperty(value = "cliente") Cliente cliente, 
			@JsonProperty(value = "producto") Producto producto,
			@JsonProperty(value = "fecha") LocalDateTime fecha,
			@JsonProperty(value = "servido") Boolean servido
			) {
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha; 
		this.servido = servido; 
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	public Boolean getServido() {
		return this.servido;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente; 
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto; 
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha; 
	}
	
	public void setServido(Boolean servido) {
		this.servido = servido; 
	}
	
	
}
