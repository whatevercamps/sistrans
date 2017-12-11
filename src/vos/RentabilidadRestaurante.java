package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.*;
/**
 * Clase que contiene la Rentabilidad de un Restaurante.
 * @author jc.corrales
 *
 */
public class RentabilidadRestaurante
{
	/**
	 * Atributo que contiene los Ingresos.
	 */
	@JsonProperty(value = "ingresos")
	private Double ingresos;
	/**
	 * Atributo que contiene los Gastos.
	 */
	@JsonProperty(value = "gastos")
	private Double gastos;
	/**
	 * Atributo que contiene el valor de la Rentabilidad del Restaurante.
	 */
	@JsonProperty(value = "rentabilidad")
	private Double rentabilidad;
	/**
	 * Atributo que contiene la Cantidad de Pedidos realizados.
	 */
	@JsonProperty(value = "cantidadPedidos")
	private Integer cantidadPedidos;
	/**
	 * Atributo que contiene la Categor�a de comidas.
	 */
	@JsonProperty(value = "categoria")
	private String categoria;
	/**
	 * Atributo que contiene el producto.
	 */
	@JsonProperty(value = "producto")
	private Producto producto;
	/**
	 * Atributo que contiene la informaci�n del Restaurante.
	 */
	@JsonProperty(value = "restaurante")
	private Restaurante restaurante;
	/**
	 * Atributo que contiene la informaci�n de la Zona.
	 */
	@JsonProperty(value = "zona")
	private Zona zona;
	/**
	 * M�todo constructor de la clase Rentabilidad Restaurante.
	 * @param ingresos
	 * @param gastos
	 * @param rentabilidad Double, Valor de la Rentabilidad del Restaurante.
	 * @param cantidadPedidos
	 * @param restaurante Restaurante, Informaci�n del Restaurante.
	 * @param String categoria, Categor�a de comidas de la consulta.
	 * @param Producto, Producto en base al cual se hace la consulta.
	 */
	public RentabilidadRestaurante(
			@JsonProperty(value = "ingresos")Double ingresos,
			@JsonProperty(value = "gastos")Double gastos,
			@JsonProperty(value = "rentabilidad")Double rentabilidad,
			@JsonProperty(value = "cantidadPedidos")Integer cantidadPedidos,
			@JsonProperty(value = "restaurante")Restaurante restaurante,
			@JsonProperty(value = "categoria")String categoria,
			@JsonProperty(value = "producto")Producto producto,
			@JsonProperty(value = "zona")Zona zona
			)
	{
		this.rentabilidad = rentabilidad;
		this.restaurante = restaurante;
		this.categoria = categoria;
		this.producto = producto;
		this.cantidadPedidos = cantidadPedidos;
		this.ingresos = ingresos;
		this.gastos = gastos;
		this.zona = zona;
	}
	public RentabilidadRestaurante(Informe inf) {
		List<Dato> datos = new ArrayList<Dato>();
		if(datos.get(0).getName().equalsIgnoreCase("IdZona")) {
			Zona zonaN = new Zona();
			zonaN.setId(Long.parseLong(datos.get(0).getValor()));
			this.zona = zonaN;
		}
		if(datos.get(0).getName().equalsIgnoreCase("IdProducto")) {
			Producto prod = new Producto();
			prod.setId(Long.parseLong(datos.get(0).getValor()));
			this.producto = prod;
		}
		if(datos.get(0).getName().equalsIgnoreCase("Categoria")) {
			this.categoria = datos.get(0).getValor();
		}
		if(datos.get(0).getName().equalsIgnoreCase("IdRestaurante")) {
			Restaurante rest = new Restaurante();
			rest.setId(Long.parseLong(datos.get(0).getValor()));
			this.restaurante = rest;
		}
		
		this.cantidadPedidos = Integer.parseInt(datos.get(1).getValor());
		this.ingresos = Double.parseDouble(datos.get(2).getValor());
		this.gastos = Double.parseDouble(datos.get(3).getValor());
		
	}
	/**
	 * M�todo que obtiene los ingresos.
	 * @return Double, ingresos.
	 */
	public Double getIngresos()
	{
		return ingresos;
	}
	/**
	 * M�todo que establece los ingresos.
	 * @param ingresos Double, nuevos ingresos.
	 */
	public void setIngresos(Double ingresos) 
	{
		this.ingresos = ingresos;
	}
	/**
	 * M�todo que obtiene los Gastos.
	 * @return Double, Gastos.
	 */
	public Double getGastos()
	{
		return gastos;
	}
	/**
	 * M�todo que establece los Gastos.
	 * @param gastos Double, nuevos Gastos.
	 */
	public void setGastos(Double gastos)
	{
		this.gastos = gastos;
	}
	/**
	 * M�todo que obtiene la Rentabilidad del Restaurante.
	 * @return Double, Valor de la Rentabilidad del Restaurante.
	 */
	public Double getRentabilidad()
	{
		return rentabilidad;
	}
	/**
	 * M�todo que establece la Rentabilidad del Restaruante.
	 * @param rentabilidad Double, nueva Rentabilidad del Restaurante.
	 */
	public void setRentabilidad(Double rentabilidad)
	{
		this.rentabilidad = rentabilidad;
	}
	/**
	 * M�todo que obtiene la cantidad de Pedidos realizados.
	 * @return Integer, cantidad de Pedidos realizados.
	 */
	public Integer getCantidadPedidos()
	{
		return cantidadPedidos;
	}
	/**
	 * M�todo que establece la cantidad de Pedidos realizados.
	 * @param cantidadPedidos Integer, nueva cantidad de Pedidos relizados.
	 */
	public void setCantidadPedidos(Integer cantidadPedidos)
	{
		this.cantidadPedidos = cantidadPedidos;
	}
	/**
	 * M�todo que obtiene la Categor�a de comidas en base a la cual se hace esta consulta.
	 * @return String, nombre de la Categor�a de comidas.
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * M�todo que establece la Categor�a de comidas en base a la cual se hace esta consulta.
	 * @param categoria String, nueva categor�a de comidas.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * M�todo que obtiene el Producto de referencia de la Consulta.
	 * @return Producto, toda la informaci�n del Producto.
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * M�todo que establece el Producto de referencia de la Consulta.
	 * @param producto Producto, nuevo Producto de referencia de la Consulta.
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * M�todo que obtiene el Restaurante.
	 * @return Restaurante, Informaci�n del Restaurante cuya rentabilidad se consulta.
	 */
	public Restaurante getRestaurante()
	{
		return restaurante;
	}
	/**
	 * M�todo que establece la informaci�n del Restaurante.
	 * @param restaurante Restaurante, nueva informaci�n del Restaurante cuya rentabilidad se consulta.
	 */
	public void setRestaurante(Restaurante restaurante)
	{
		this.restaurante = restaurante;
	}
	/**
	 * M�todo que obtiene la informaci�n de la Zona.
	 * @return Zona, informaci�n de la Zona.
	 */
	public Zona getZona()
	{
		return zona;
	}
	/**
	 * M�todo que establece la informaci�n de la Zona.
	 * @param zona Zona, nueva Informaci�n de la Zona.
	 */
	public void setZona(Zona zona)
	{
		this.zona = zona;
	}
}
