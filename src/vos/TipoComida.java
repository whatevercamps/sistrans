package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoComida {
	
	@JsonProperty(value="id")
	private Long id;
	
	 @JsonProperty(value="name")
	 private String name;
	 
	 
	 public TipoComida(@JsonProperty(value="id") Long id, 
			 @JsonProperty(value="name") String name) {
		 this.id = id;
		 this.name = name;
	 }
}
