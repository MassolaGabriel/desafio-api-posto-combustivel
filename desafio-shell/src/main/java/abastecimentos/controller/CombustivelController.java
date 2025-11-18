package abastecimentos.controller;

import java.util.List;
import java.util.Optional;

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
	private CombustivelRepository combustivelRepository;

	// 1. CRIAR (POST)
	@PostMapping
	public ResponseEntity<Combustivel> cadastrarCombustivel(@Valid @RequestBody Combustivel novoCombustivel) {
		Combustivel combustivelSalvo = combustivelRepository.save(novoCombustivel);
		// Retorna 201 Created (Melhor prática REST)
		return ResponseEntity.status(201).body(combustivelSalvo);
	}

	// 2. LISTAR TODOS (GET)
	@GetMapping
	public ResponseEntity<List<Combustivel>> listarTiposCombustiveis() {
		List<Combustivel> lista = combustivelRepository.findAll();
		return ResponseEntity.ok(lista);
	}

	// 3. BUSCAR POR ID (GET)
	@GetMapping("/{id}")
	public ResponseEntity<Combustivel> buscarPorId(@PathVariable Integer id) {
		return combustivelRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// 4. ATUALIZAR (PUT)
	@PutMapping("/{id}")
	public ResponseEntity<Combustivel> atualizarCombustivel(@PathVariable Integer id, @Valid @RequestBody Combustivel combustivelAtualizado) {
		Optional<Combustivel> combustivelExistenteOptional = combustivelRepository.findById(id);

		if (combustivelExistenteOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Combustivel combustivelExistente = combustivelExistenteOptional.get();

		// Atualiza os dados
		combustivelExistente.setNome(combustivelAtualizado.getNome());
		combustivelExistente.setPrecoLitro(combustivelAtualizado.getPrecoLitro());

		Combustivel salvo = combustivelRepository.save(combustivelExistente);

		return ResponseEntity.ok(salvo);
	}

	// 5. DELETAR (DELETE)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCombustivel(@PathVariable Integer id) {
		if (!combustivelRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		combustivelRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}