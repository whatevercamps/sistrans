package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class IngredienteBase {


	private Long id;
	private String name;
	
	public IngredienteBase(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
