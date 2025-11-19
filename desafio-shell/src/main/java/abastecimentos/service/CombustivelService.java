package abastecimentos.service;

import abastecimentos.model.Combustivel;
import abastecimentos.repository.CombustivelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombustivelService {
    @Autowired
    private CombustivelRepository combustivelRepository;

    public List<Combustivel> listarTodos() {
        return combustivelRepository.findAll();
    }

    public Optional<Combustivel> listarPorId(Integer id) {
        return combustivelRepository.findById(id);
    }

    public Combustivel salvar(Combustivel combustivel) {
        return combustivelRepository.save(combustivel);
    }

    public Combustivel atualizar(Integer id, Combustivel combustivelAtualizado) {
        Optional<Combustivel> combustivelExistenteOptional = combustivelRepository.findById(id);

        if (combustivelExistenteOptional.isEmpty()) {
            return null;
        }

        Combustivel combustivelExistente = combustivelExistenteOptional.get();

        // Atualiza os dados
        combustivelExistente.setNome(combustivelAtualizado.getNome());
        combustivelExistente.setPrecoLitro(combustivelAtualizado.getPrecoLitro());

        return combustivelRepository.save(combustivelExistente);
    }

    @Transactional
    public void deletar(Integer id) {
        combustivelRepository.deleteById(id);
    }
}
