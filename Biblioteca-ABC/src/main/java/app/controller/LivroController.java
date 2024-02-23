package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	public LivroService livroSercive;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Livro livro){
		
		try {
			
			String salvar = this.livroSercive.save(livro);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll(){
		
		try {
			
			List<Livro> lista = this.livroSercive.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> findById(@PathVariable long id){
		
		try {
			
			Livro livro = this.livroSercive.findById(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Livro> update(@PathVariable long id,@RequestBody Livro newLivro){
		
		try {
			
			Livro livro = this.livroSercive.update(id, newLivro);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){

		try {

			String mensagem = this.livroSercive.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
}
