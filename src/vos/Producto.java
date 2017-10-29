/**-------------------------------------------------------------------
  * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: RotondAndes
 * Autor: Juan Carlos Corrales - jc.corrales@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;

import java.util.List;

import org.codehaus.jackson.annotate.*;


public class Producto extends ProductoBase
{
	

	/**
	 * Costo de Producci�del producto.
	 */
	@JsonProperty(value="costoDeProduccion")
	private Double costoDeProduccion;

	/**
	 * Atributo que contiene  los productos equivalentes.
	 */
	@JsonProperty(value = "productosEquivalentes")
	private List<ProductoBase> productosEquivalentes;
	/**
	 * Atributo que contiene el precio.
	 */
	@JsonProperty(value = "precio")
	private Double precio;
	/**
	 * Atributo que contiene los tipos de comida.
	 */
	@JsonProperty(value = "tiposComida")
	private List<TipoComida> tiposComida;
	
	/**
	 * M�todo constructor de la clase Producto.
	 * @param id
	 * @param nombre
	 * @param costoDeProduccion
	 * @param descripcionEspaniol
	 * @param descripcionIngles
	 * @param ProductosEquivalentes
	 * @param precio
	 * @param tiposComida
	 */
	
	public Producto() {
		super();
	}
	
	public Producto(@JsonProperty(value = "id")Long id, 
			@JsonProperty(value = "nombre") String nombre, 
			@JsonProperty(value = "descripcionEspaniol")String descripcionEspaniol,
			@JsonProperty(value = "descripcionIngles")String descripcionIngles,
			@JsonProperty(value = "costo_prod") Double costoDeProduccion, 
			@JsonProperty(value = "productos_equivalentes") List<ProductoBase> productosEquivalentes, 
			@JsonProperty(value = "precio") Double precio, 
			@JsonProperty(value = "tipos") List<TipoComida> tiposComida,
			@JsonProperty(value = "categoria") String categoria,
			@JsonProperty(value = "ingredientes") List<Ingrediente> ingredientes){
		
		super(id, nombre, descripcionEspaniol, descripcionIngles, categoria, ingredientes);
		this.costoDeProduccion = costoDeProduccion;
		this.productosEquivalentes = productosEquivalentes;
		this.precio = precio;
		this.tiposComida = tiposComida;
		
	}
	
	/**
	 * M�todo que obtiene el costo de producci�n.
	 * @return Double, Costo de producci�n de este Producto.
	 */
	public Double getCostoDeProduccion()
	{
		return this.costoDeProduccion;
	}
	/**
	 * M�todo que establece el costo de producci�n de este producto.
	 * @param costoDeProduccion Double, Nuevo costo de producci�n.
	 */
	public void setCostoDeProduccion(Double costoDeProduccion)
	{
		this.costoDeProduccion = costoDeProduccion;
	}
	/**
	 * M�todo que obtiene el precio de este producto.
	 * @return
	 */
	public Double getPrecio()
	{
		return this.precio;
	}
	/**
	 * M�todo que establece el precio de este producto.
	 * @param precio Double, Precio nuevo del producto.
	 */
	public void setPrecio(Double precio)
	{
		this.precio = precio;
	}
	/**
	 * M�todo que obtiene los IDs de los productos equivalentes a este.
	 * @return List<ProductoBase>, Lista de productos Equivalentes.
	 */
	public List<ProductoBase> getProductosEquivalentes()
	{
		return productosEquivalentes;
	}
	/**
	 * M�todo que establece una lista de IDs de productos equivalentes a este.
	 * @param ProductosEquivalentes List<ProductoBase>, Lista de productos equivalentes.
	 */
	public void setProductosEquivalentes(List<ProductoBase> productosEquivalentes)
	{
		this.productosEquivalentes = productosEquivalentes;
	}
	/**
	 * M�todo que obtiene los tipos de comida de este producto.
	 * @return List<String>, Tipos de comida de este producto.
	 */
	public List<TipoComida> getTiposComida()
	{
		return this.tiposComida;
	}
	/**
	 * M�todo que obtiene los tipos de comida.
	 * @param tiposComida
	 */
	public void setTiposComida(List<TipoComida> tiposComida)
	{
		this.tiposComida = tiposComida;
	}
	

}
