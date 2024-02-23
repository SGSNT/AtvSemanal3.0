package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Editora {

	private long id;
	private String nome;
	private String endereco;
	private String telefone;
}
