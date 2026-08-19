package com.google.com.ianfinardi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{codigo}")
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable int codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		if (produto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(produto.get());
			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		try {
			if (produtoRepository.existsById(produto.getCodigo())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Produto salvo = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}


	@PutMapping("/produtos/{codigo}")
	public ResponseEntity<Produto> atualizar(@PathVariable int codigo, @RequestBody Produto produto) {
		if (!produtoRepository.existsById(codigo)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		produto.setCodigo(codigo);
		Produto atualizado = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.OK).body(atualizado);
	}


	@DeleteMapping("/produto/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable int codigo) {
		if (!produtoRepository.existsById(codigo)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		produtoRepository.deleteById(codigo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
