package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlumnoDto {
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;
}
