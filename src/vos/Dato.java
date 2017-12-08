package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Dato {
	/**
	 * Nombre de este Sabor.
	 */
	@JsonProperty(value="name")
	private String name; 
	
	/**
	 * Atributo que contiene el valor de este Sabor.
	 */
	@JsonProperty(value="valor")
	private String valor; 
	
	
	/**
	 * M�todo constructor de la clase Sabor.
	 * @param id Long
	 * @param name String
	 */
	public Dato(@JsonProperty(value="name") String name, @JsonProperty(value="valor") String valor) {
		
		this.name = name;
		this.valor = valor;
	}

	/**
	 * M�todo que obtiene el nombre de este Sabor.
	 * @return String, nombre del Sabor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * M�todo que establece el nombre de este Sabor.
	 * @param name String, nuevo nombre de este Sabor.
	 */
	public void setName(String name) {
		this.name = name; 
	}
	
	/**
	 * M�todo que obtiene el nombre de este Sabor.
	 * @return String, nombre del Sabor.
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * M�todo que establece el nombre de este Sabor.
	 * @param name String, nuevo nombre de este Sabor.
	 */
	public void setValor(String valor) {
		this.valor = valor; 
	}
}
