package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Editora;

@Service
public class EditoraService {

	List<Editora> lista = new ArrayList<>();

	public String save(Editora editora) {

		lista.add(editora);

		return editora.getNome() + "Editora salva";

	}

	public List<Editora> listAll(){

		List<Editora> lista = new ArrayList<>();

		Editora editora = new Editora(1,"Warner","Rua do João","(00)00000-0000");
		Editora editora1 = new Editora(2,"Capcom","Rua do Osvaldo","(01)01010-0101");
		Editora editora2 = new Editora(3,"Nitendo","Rua do Maicão","(02)02020-0202");
		Editora editora3 = new Editora(4,"Nike","Rua do Julião","(03)03030-0303");

		lista.add(editora);
		lista.add(editora1);
		lista.add(editora2);
		lista.add(editora3);

		return lista;
	}

	public Editora findById(long id) {

		List<Editora> lista = this.listAll();

		if(lista != null) {

			for(int i = 0; i < lista.size(); i++) {

				if(id == lista.get(i).getId()) {

					return lista.get(i);
				}

			}
		}

		return null;
	}

	public Editora update(long id, Editora newEditora) {

		List<Editora> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			Editora editora = lista.get(i);

			if(editora != null && editora.getId() == id) {

				editora.setNome(newEditora.getNome());
				editora.setEndereco(newEditora.getEndereco());
				editora.setTelefone(newEditora.getTelefone());

				return editora;
			}

		}
		return null;
	}

	public String delete(long id) {

		List<Editora> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			if(lista.get(i).getId() == id) {

				lista.remove(lista.get(i));

				return "Deletado com sucesso";
			}

		}

		return "Não foi possível excluir";
	}
}

