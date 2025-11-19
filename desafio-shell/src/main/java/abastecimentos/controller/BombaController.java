package abastecimentos.controller;

import abastecimentos.model.Bomba;
import abastecimentos.service.BombaService;
import abastecimentos.service.CombustivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bomba")
public class BombaController {
    @Autowired
    public BombaService bombaService;

    @GetMapping
    public List<Bomba> listarTodasBombas(){
        return bombaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bomba> listarBombaId(@PathVariable Integer id) {
        Optional<Bomba> bomba = bombaService.listarPorId(id);
        return bomba.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bomba salvar(@Valid @RequestBody Bomba bomba) {
        return bombaService.salvar(bomba);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bomba> atualizarBomba(@PathVariable Integer id, @Valid @RequestBody Bomba bombaAtualizada){
        try {
            Bomba bomba = bombaService.atualizar(id, bombaAtualizada);
            return ResponseEntity.ok(bomba);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        bombaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
