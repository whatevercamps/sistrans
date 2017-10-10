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


import java.util.List;

import org.codehaus.jackson.annotate.*;


public class ClienteFrecuente extends Cliente
{
	/**
	 * Atributo que contiene la contrasenia de este cliente.
	 */
	@JsonProperty(value="contrasenia")
	private String contrasenia;
	/**
	 * Atributo que contiene los productos pre seleccionados de este cliente.
	 */
	@JsonProperty(value = "productosPreSeleccionados")
	private List<Producto> preferencias;
	
	
	/**
	 * MÈtodo Constructor de la clase ClienteFrecuenteVos.
	 * @param contrasenia
	 * @param id
	 * @param mesa
	 * @param nombre
	 * @param nPersonas
	 * @param numeroTarjetaCredito
	 */
	public ClienteFrecuente(@JsonProperty(value = "productosPreSeleccionados")List<Producto> productosPreSeleccionados, @JsonProperty(value="contrasenia")String contrasenia,@JsonProperty(value="id")Long id, @JsonProperty(value = "mesa")Integer mesa, @JsonProperty(value = "nombre")String nombre)
	{
		super(id, mesa, nombre);
		this.contrasenia = contrasenia;
		this.preferencias = productosPreSeleccionados;
	}
	/**
	 * MÈtodo que obtiene la contrasenia de este cliente frecuente registrado.
	 * @return String, contrasenia de este cliente.
	 */
	public String getContrasenia()
	{
		return this.contrasenia;
	}
	/**
	 * MÈtodo que establece la contrasenia de este cliente frecuente.
	 * @param contrasenia String, nueva contrasenia de este cliente frecuente.
	 */
	public void setContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}
	/**
	 * MÈtodo que obtiene los productos pre seleccionados de este cliente frecuente.
	 * @return List<ProductoVos>, lista de productos pre seleccionados de este cliente.
	 */
	public List<Producto> getProductosPreSeleccionados()
	{
		return preferencias;
	}
	/**
	 * MÈtodo que establece la lista de productos pre seleccionados de este cliente frecuente.
	 * @param productosPreSeleccionados List<ProductoVos>, nueva lista de productos pre seleccionados de este cliente.
	 */
	public void setProductosPreSeleccionados(List<Producto> productosPreSeleccionados)
	{
		this.preferencias = productosPreSeleccionados;
	}
}
