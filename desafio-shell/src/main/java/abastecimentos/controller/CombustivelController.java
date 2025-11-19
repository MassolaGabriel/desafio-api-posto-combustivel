package abastecimentos.controller;

import java.util.List;
import java.util.Optional;

import abastecimentos.service.CombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import abastecimentos.model.Combustivel;
import abastecimentos.repository.CombustivelRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {

	@Autowired
	private CombustivelService combustivelService;

	@GetMapping
	public List<Combustivel> listarTodos() {
		return combustivelService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Combustivel> listarPorId(@PathVariable Integer id) {
		Optional<Combustivel> combustivel = combustivelService.listarPorId(id);
		return combustivel.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Combustivel salvar(@Valid @RequestBody Combustivel combustivel) {
		return combustivelService.salvar(combustivel);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Combustivel> atualizar(@PathVariable Integer id, @Valid @RequestBody Combustivel combustivelAtualizado) {
		try {
			Combustivel combustivel = combustivelService.atualizar(id, combustivelAtualizado);
			return ResponseEntity.ok(combustivel);
		}catch (RuntimeException e){
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		combustivelService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}