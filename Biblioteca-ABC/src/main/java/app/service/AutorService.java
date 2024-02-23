package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;

@Service
public class AutorService {

	List<Autor> lista = new ArrayList<>();

	public String save(Autor autor) {

		lista.add(autor);

		return autor.getNome() + "Autor salvo";

	}

	public List<Autor> listAll(){

		List<Autor> lista = new ArrayList<>();

		Autor autor = new Autor(1,"Henrique","000.000.000-00",18);
		Autor autor1 = new Autor(2,"João","111.111.111-11",19);
		Autor autor2 = new Autor(3,"Jonas","222.222.222-22",20);
		Autor autor3 = new Autor(4,"Bruno","333.333.333-33",21);
		Autor autor4 = new Autor(5,"Billy","444.444.444-44",22);

		lista.add(autor);
		lista.add(autor1);
		lista.add(autor2);
		lista.add(autor3);
		lista.add(autor4);

		return lista;
	}

	public Autor findById(long id) {

		List<Autor> lista = this.listAll();

		if(lista != null) {

			for(int i = 0; i < lista.size(); i++) {

				if(id == lista.get(i).getId()) {

					return lista.get(i);

				}

			}

		}
		return null;
	}

	public Autor update(long id, Autor newAutor) {

		List<Autor> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			Autor autor = lista.get(i);

			if(autor != null && autor.getId() == id) {

				autor.setNome(newAutor.getNome());
				autor.setCpf(newAutor.getCpf());
				autor.setIdade(newAutor.getIdade());

				return autor;

			}
		}

		return null;
	}
	
	public String delete(long id) {
		
		List<Autor> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getId() == id) {
				
				lista.remove(lista.get(i));
				
				return "Deletado com sucesso";
			}
			
		}
		
		return "Não foi possível excluir";
	}

}	
