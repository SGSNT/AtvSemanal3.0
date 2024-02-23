package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Biblioteca;

@Service
public class BibliotecaService {
	
	List<Biblioteca> lista = new ArrayList<>();

	public String save(Biblioteca biblioteca) {
		
		lista.add(biblioteca);

		return biblioteca.getNome() + "Biblioteca salva";

	}

	public List<Biblioteca> listAll() {

		List<Biblioteca> lista = new ArrayList<>();

		Biblioteca biblioteca = new Biblioteca(1, "Alexandria", "(00)00000-0000");
		Biblioteca biblioteca1 = new Biblioteca(2, "Strahov", "(01)11111-1111");
		Biblioteca biblioteca2 = new Biblioteca(3, "Rijksmuseum", "(02)22222-2222");
		Biblioteca biblioteca3 = new Biblioteca(4, "Trindade", "(03)33333-3333");
		Biblioteca biblioteca4 = new Biblioteca(5, "Sao Galo", "(04)44444-4444");

		lista.add(biblioteca);
		lista.add(biblioteca1);
		lista.add(biblioteca2);
		lista.add(biblioteca3);
		lista.add(biblioteca4);

		return lista;
	}
	
	
	public Biblioteca findById(long id) {
		
		List<Biblioteca> lista = this.listAll();
		
		if(lista != null) {
			
			for(int i = 0; i < lista.size(); i++) {
				
				if(id == lista.get(i).getId()) {
					
					
					return lista.get(i);
					
				}
				
			}
			
		}
		 
		return null;
	}
	
	public Biblioteca update(long id, Biblioteca newBiblioteca) {
		
		List<Biblioteca> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			Biblioteca biblioteca = lista.get(i);
			
			if(biblioteca != null && biblioteca.getId() == id) {
				
				biblioteca.setNome(newBiblioteca.getNome());
				biblioteca.setTelefone(newBiblioteca.getTelefone());
				
				return biblioteca;
				
			}
			
		}
		
		return null;
	}
	
	public String delete(long id) {
		
		List<Biblioteca> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getId() == id) {
				
				lista.remove(lista.get(i));
				
				return "Deletado com sucesso";
				
			}
			
		}
		
		return "Não deu para excluir";
	}

}
