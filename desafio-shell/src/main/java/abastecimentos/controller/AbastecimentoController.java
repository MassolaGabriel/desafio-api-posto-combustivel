package abastecimentos.controller;

import abastecimentos.model.Abastecimento;
import abastecimentos.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    @Autowired
    public AbastecimentoService abastecimentoService;

    @GetMapping
    public List<Abastecimento> listarTodosAbastecimentos(){
        return abastecimentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abastecimento> listarAbastecimentoId(@PathVariable Integer id){
        Optional<Abastecimento> abastecimento = abastecimentoService.listarPorId(id);
        return abastecimento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Abastecimento novoAbastecimento(@Valid @RequestBody Abastecimento abastecimento){
        return abastecimentoService.salvar(abastecimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abastecimento> atualizarAbastecimento(@PathVariable Integer id, @Valid @RequestBody Abastecimento abastecimentoAtualizado){
        try {
            Abastecimento abastecimento = abastecimentoService.atualizar(id, abastecimentoAtualizado);
            return ResponseEntity.ok(abastecimento);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAbastecimento(@PathVariable Integer id){
        abastecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
