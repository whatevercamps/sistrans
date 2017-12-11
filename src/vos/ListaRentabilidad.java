package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRentabilidad
{
	@JsonProperty(value = "rentabilidades")
	private List<RentabilidadRestaurante> rentabilidades;

	public ListaRentabilidad(
			@JsonProperty(value = "rentabilidades")List<RentabilidadRestaurante> rentabilidades
			)
	{
		this.rentabilidades = rentabilidades;
	}
	/**
	 * M�todo que obtiene la Lista de Rentabilidades.
	 * @return List<RentabilidadRestaurante>, Lista de las Rentabilidades de los Restaurantes.
	 */
	public List<RentabilidadRestaurante> getRentabilidades() {
		return rentabilidades;
	}
	/**
	 * M�todo que establece la Lista de Rentabilidades que entra por par�metro.
	 * @param rentabilidades List<RentabilidadRestaurante>, nueva Lista de Rentabilidades de los Restaurantes.
	 */
	public void setRentabilidades(List<RentabilidadRestaurante> rentabilidades) {
		this.rentabilidades = rentabilidades;
	}
}
