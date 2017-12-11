package vos; 

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Informe {
	/**
	 * Atributo que contiene el ID del informe.
	 */
	@JsonProperty(value="id")
	private Long id; 
	/**
	 * Atributo que contiene el arreglo de valores que hacen parte del informe.
	 */
	@JsonProperty(value="datos")
	private List<Dato> datos; 
	
	
	/**
	 * Método constructor de la clase informe.
	 * @param id Long
	 * @param name String
	 */
	public Informe(@JsonProperty(value="id") Long id, @JsonProperty(value="datos") List<Dato> datos) {
		this.id = id;
		this.datos = datos;
	}
	public Informe(RentabilidadRestaurante a) {
		this.id = 666L;
		Dato totalProductosVendidos = new Dato("TotalProductosVendidos", ""+a.getCantidadPedidos());
		Dato totalFacturado = new Dato("TotalFacturado", "" + a.getIngresos());
		Dato costoTotal = new Dato("CostoTotal", "" + a.getGastos());
		Dato tfiltro = new Dato("","");
		if(a.getRestaurante() != null){
			tfiltro = new Dato("IdRestaurante", "" + a.getRestaurante().getId());
		}
		if(a.getZona() != null){
			tfiltro = new Dato("IdZona", a.getZona().toString());
		}
		if(a.getProducto() != null){
			tfiltro = new Dato("IdProducto", a.getProducto().toString());
		}
		if(a.getCategoria() != null) {
			tfiltro = new Dato("Categoria", a.getCategoria());
		}
		
		this.datos.add(tfiltro);
		this.datos.add(totalProductosVendidos);
		this.datos.add(totalFacturado);
		this.datos.add(costoTotal);
	}
	
	
	/**
	 * Método que obtiene el ID del informe.
	 * @return Long, ID del informe.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Método que establece el ID del informe.
	 * @param id Long, nuevo ID del informe.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método que obtiene el nombre del informe.
	 * @return String, nombre del informe.
	 */
	public List<Dato> getDatos() {
		return datos;
	}
	/**
	 * Método que establece el nombre del informe.
	 * @param name String, nuevo nombre del informe.
	 */
	public void setDatos(List<Dato> datos) {
		this.datos = datos; 
	}
}
