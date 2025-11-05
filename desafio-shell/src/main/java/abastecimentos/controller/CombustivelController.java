package abastecimentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abastecimentos.model.Combustivel;
import abastecimentos.repository.CombustivelRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {
	@Autowired
	private CombustivelRepository combustivelRepository;
	
	@PostMapping
	public Combustivel cadastrarCombustivel(@Valid @RequestBody Combustivel novoCombustivel) {
		return combustivelRepository.save(novoCombustivel);
	}	
	
	@GetMapping
	public List<Combustivel> listarTiposCombustiveis(){
		return combustivelRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Combustivel> atualizarCombustivel(@PathVariable String id, @RequestBody Combustivel combustivelAtualizado){
		Optional<Combustivel> combustivelExistenteOptional = combustivelRepository.findById(id);
		
		if(combustivelExistenteOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Combustivel combustivelExistente = combustivelExistenteOptional.get();
		
		combustivelExistente.setNome(combustivelAtualizado.getNome());
		combustivelExistente.setPrecoLitro(combustivelAtualizado.getPrecoLitro());
		combustivelExistente.setBombas(combustivelAtualizado.getBombas());
	
		Combustivel salvo = combustivelRepository.save(combustivelExistente);
		
		return ResponseEntity.ok(salvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCombustivel(@PathVariable String id){
		Optional<Combustivel> combustivelOptional = combustivelRepository.findById(id);
		
		if(combustivelOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		combustivelRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
}
