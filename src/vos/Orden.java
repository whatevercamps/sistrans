/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogot√° - Colombia)
 * Departamento de Ingenier√≠a de Sistemas y Computaci√≥n
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: RotondAndes
 * Autor: Juan Carlos Corrales - jc.corrales@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.codehaus.jackson.annotate.*;

public class Orden
{
	/**
	 * Id de la orden.
	 */
	@JsonProperty(value="id")
	private Long id;
	/**
	 * Atributo que contiene el costo total de esta orden.
	 */
	@JsonProperty(value = "costoTotal")
	private Double costoTotal;
	/**
	 * Atributo que contiene los productos Ordenados.
	 */
	@JsonProperty(value = "productosOrdenados")
	private List<Producto> productosOrdenados;

	@JsonProperty(value = "fecha")
	private LocalDateTime fecha;
	
	public Orden() {
		
	}
	
	/**
	 * MÈtodo constructor de la clase OrdenVos.
	 * @param id
	 * @param costoTotal
	 * @param productosOrdenados
	 * @param cliente
	 */
	public Orden(@JsonProperty(value = "id")Long id, 
			@JsonProperty(value = "costoTotal") Double costoTotal,
			@JsonProperty(value = "productosOrdenados")List<Producto> productosOrdenados,
			@JsonProperty(value = "fecha") LocalDateTime fecha)
	{
		this.id = id;
		this.costoTotal = costoTotal;
		this.productosOrdenados = productosOrdenados;
		this.fecha = fecha;
	}
	/**
	 * MÈtodo que obtiene el ID de este cliente frecuente.
	 * @return Long, ID de este cliente.
	 */
	public Long getId()
	{
		return this.id;
	}
	/**
	 * MÈtodo que establece el ID de esta orden.
	 * @param id Long, ID de esta orden.
	 */
	public void setId(Long id)
	{
		this.id = id;
	}
	/**
	 * MÈtodo que obtiene el costo total de esta orden.
	 * @return Double, costo total de esta orden.
	 */
	public Double getCostoTotal()
	{
		return this.costoTotal;
	}
	
	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	/**
	 * MÈtodo que obtiene la lista de productos ordenados de esta orden.
	 * @return List<ProductoVos>, Lista de productos Ordenados en esta orden.
	 */
	public List<Producto> getProductosOrdenados()
	{
		return this.productosOrdenados;
	}
	/**
	 * MÈtodo que establece la lista de productos ordenados de esta orden.
	 * @param productosOrdenados List<ProductoVos>, Nueva lista de productos ordenados en esta orden.
	 */
	public void setProductosOrdenados(List<Producto> productosOrdenados)
	{
		this.productosOrdenados = productosOrdenados;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


}
