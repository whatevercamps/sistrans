package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Representante {
	/**
	 * Id del representante
	 */
	@JsonProperty(value="id")
	private Long id;

	/**
	 * Nombre del representante
	 */
	@JsonProperty(value="name")
	private String name;

	public Representante(@JsonProperty(value="id")Long id, @JsonProperty(value="name")String name) {
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
