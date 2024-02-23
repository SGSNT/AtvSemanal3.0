package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {

	List<Livro> lista = new ArrayList<>();
	
	public String save(Livro livro) {
		
		lista.add(livro);
		
		return livro.getTitulo() + "Livro salvo";
	}
	
	public List<Livro> listAll(){
		
		List<Livro> lista = new ArrayList<>();
		
		Livro livro = new Livro(1,"ISBN 968-90-888","Harry Potter","Harry potter bruxao",26051969,400);
		Livro livro1 = new Livro(2,"ISBN 969-89-777","Hobbit","Bilbo Bolseiro",15022001,390);
		Livro livro2 = new Livro(3,"ISBN 970-87-555","Cronicas de Gelo","John Snow",30011988,380);
		Livro livro3 = new Livro(4,"ISBN 988-86-444","Marley e Eu","Não sou o Marley",20101980,370);
		
		lista.add(livro);
		lista.add(livro1);
		lista.add(livro2);
		lista.add(livro3);
		
		return lista;
	}
	
	public Livro findById(long id) {
		
		List<Livro> lista = this.listAll();
		
		if(lista != null) {
			
			for(int i = 0; i < lista.size(); i++) {
				
				if(id == lista.get(i).getId()) {
					
					return lista.get(i);
					
				}
				
			}
			
		}
		return null;
	}
	
	public Livro update(long id, Livro newLivro) {
		
		List<Livro> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			Livro livro = lista.get(i);
			
			if(livro != null && livro.getId() == id) {
				
				livro.setIssn(newLivro.getIssn());
				livro.setTitulo(newLivro.getTitulo());
				livro.setSinopse(newLivro.getSinopse());
				livro.setAno(newLivro.getAno());
				livro.setNumPag(newLivro.getNumPag());
				
				return livro;
			}
			
		}
		return null;
	}
	
	public String delete(long id) {
		
		List<Livro> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getId() == id) {
				
				lista.remove(lista.get(i));
				
				return "Deletado com sucesso";
			}
			
		}
		return "Não foi possível deletar o projeto";
	}
}
