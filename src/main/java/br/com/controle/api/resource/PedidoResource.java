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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.api.event.RecursoCriarEvent;
import br.com.controle.api.model.ItemPedido;
import br.com.controle.api.model.Pedido;
import br.com.controle.api.repository.ItemPedidoRepository;
import br.com.controle.api.repository.PedidoRepository;
import br.com.controle.api.repository.filter.PedidoFilter;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

//	@Autowired
//	private PedidoService pedidoService;

	@GetMapping
	public List<Pedido> getAll(PedidoFilter pedidoFilter) {
		return pedidoRepository.filtrar(pedidoFilter);
	}

	@PostMapping
	public ResponseEntity<?> create(@Validated @RequestBody Pedido pedido, HttpServletResponse response) {
		
		
		for(ItemPedido i:pedido.getListaItemPedido()) {
			i.calcular();
		}
		
		pedido.calcular();
		
		
		Pedido c = pedidoRepository.save(pedido);

		publisher.publishEvent(new RecursoCriarEvent(this, response, c.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(c);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getId(@PathVariable Long id) {

		return pedidoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.noContent().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pedido> update(@Validated @PathVariable long id, @RequestBody Pedido pedido) {
		
		

		return pedidoRepository.findById(id).map(record -> {
			record.setCliente(pedido.getCliente());
			record.setCreateAt(pedido.getCreateAt());
			record.setPagamentoAt(pedido.getPagamentoAt());
			record.setStatusPagamento(pedido.getStatusPagamento());
			
			List<ItemPedido> lista = record.getListaItemPedido();
			
			for (ItemPedido itemPedido : lista) {
				itemPedidoRepository.deleteById(itemPedido.getId());
			}
			
			record.setListaItemPedido(pedido.getListaItemPedido());
			
			for(ItemPedido i:pedido.getListaItemPedido()) {
				i.calcular();
			}
			
			record.calcular();
			
			Pedido updated = pedidoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@PutMapping(value = "/{id}/add")
	public ResponseEntity<Pedido> addItem(@Validated @PathVariable long id, @RequestBody ItemPedido item) {
		System.out.println(item);
		
		
		return pedidoRepository.findById(id).map(record -> {
			record.getListaItemPedido().add(item);
			Pedido updated = pedidoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return pedidoRepository.findById(id).map(record -> {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
