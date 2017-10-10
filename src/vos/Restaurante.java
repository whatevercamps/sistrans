package vos;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;

public class Restaurante {

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="name")
	private String name;
	
	@JsonProperty(value="paginaWeb")
	private String pagina;
	
	@JsonProperty(value="entradas")
	private Collection<Entrada> entradas;
	
	@JsonProperty(value="platosFuertes")
	private Collection<PlatoFuerte> platosFuertes;
	
	@JsonProperty(value="postres")
	private Collection<Postre> postres;
	
	@JsonProperty(value="bebidas")
	private Collection<Bebida> bebidas;
	
	public Restaurante(@JsonProperty(value="id") Long id, 
			@JsonProperty(value="name") String name, 
			@JsonProperty(value="paginaWeb") String pagina,
			@JsonProperty(value="entradas") Collection<Entrada> entradas,
			@JsonProperty(value="platosFuertes") Collection<PlatoFuerte> platosFuertes,
			@JsonProperty(value="postres") Collection<Postre> postres,
			@JsonProperty(value="bebidas") Collection<Bebida> bebidas) {
		
		this.id = id;
		this.name = name;
		this.pagina = pagina;
		this.bebidas = bebidas;
		this.entradas = entradas;
		this.platosFuertes = platosFuertes;
		this.postres = postres;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPagina() {
		return pagina;
	}
	
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	
	public Collection<Entrada> getEntradas(){
		return entradas;
	}
	
	public void SetEntradas(Collection<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	public Collection<PlatoFuerte> getPlatosFuertes(){
		return platosFuertes;
	}
	
	public void SetPlatosFuertes(Collection<PlatoFuerte> platosFuertes) {
		this.platosFuertes = platosFuertes;
	}
	
	public Collection<Bebida> getBebidas(){
		return bebidas;
	}
	
	public void SetBebidas(Collection<Bebida> bebidas) {
		this.bebidas= bebidas;
	}
	
	public Collection<Postre> getPostres(){
		return postres;
	}
	
	public void SetPostres(Collection<Postre> postres) {
		this.postres= postres;
	}
}
