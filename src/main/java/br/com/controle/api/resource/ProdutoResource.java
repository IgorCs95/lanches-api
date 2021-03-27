package br.com.controle.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.api.event.RecursoCriarEvent;
import br.com.controle.api.model.Produto;
import br.com.controle.api.repository.ProdutoRepository;
import br.com.controle.api.repository.filter.ProdutoFilter;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

//	@Autowired
//	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> getAll(ProdutoFilter produtoFilter) {
		return produtoRepository.filtrar(produtoFilter);
	}

	@PostMapping
	public ResponseEntity<?> create(@Validated @RequestBody Produto produto, HttpServletResponse response) {
		Produto c = produtoRepository.save(produto);

		publisher.publishEvent(new RecursoCriarEvent(this, response, c.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(c);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getId(@PathVariable Long id) {

		return produtoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.noContent().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@Validated @PathVariable long id, @RequestBody Produto produto) {

		return produtoRepository.findById(id).map(record -> {
			record.setStatus(produto.isStatus());
			record.setNome(produto.getNome());
			record.setValor(produto.getValor());
			record.setEstoque(produto.getEstoque());
			record.setCategoria(produto.getCategoria());

			Produto updated = produtoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@PatchMapping("/{id}/status")
	public ResponseEntity<Produto> ativarDesativarProduto(@PathVariable Long id, @RequestBody Boolean status) {
		return produtoRepository.findById(id).map(record -> {
			record.setStatus(status);
			Produto updated = produtoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElseThrow(() -> new EmptyResultDataAccessException(1));

	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return produtoRepository.findById(id).map(record -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
