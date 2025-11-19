package abastecimentos.service;

import abastecimentos.model.Abastecimento;
import abastecimentos.repository.AbastecimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {
    @Autowired
    public AbastecimentoRepository abastecimentoRepository;

    public List<Abastecimento> listar(){
        return abastecimentoRepository.findAll();
    }

    public Optional<Abastecimento> listarPorId(Integer id){
        return abastecimentoRepository.findById(id);
    }

    public Abastecimento salvar(Abastecimento abastecimento){
        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento atualizar(Integer id, Abastecimento abastecimento){
        Optional<Abastecimento> abastecimentoOptional = abastecimentoRepository.findById(id);

        if (abastecimentoOptional.isEmpty()){
            return null;
        }

        Abastecimento abastecimentoAtualizado = abastecimentoOptional.get();

        abastecimentoAtualizado.setBomba(abastecimento.getBomba());
        abastecimentoAtualizado.setDataHora(abastecimento.getDataHora());
        abastecimentoAtualizado.setVolumeLitros(abastecimento.getVolumeLitros());
        abastecimentoAtualizado.setValorTotal(abastecimento.getValorTotal());

        return abastecimentoRepository.save(abastecimentoAtualizado);
    }

    @Transactional
    public void deletar(Integer id){
        abastecimentoRepository.deleteById(id);
    }
}
