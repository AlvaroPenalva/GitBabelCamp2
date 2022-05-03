package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatriculaDto {
	private double nota;
	private CursoDto cdto;
	private AlumnoDto adto;
}
