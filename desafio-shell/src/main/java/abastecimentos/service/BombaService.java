package abastecimentos.service;

import abastecimentos.model.Bomba;
import abastecimentos.repository.BombaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BombaService {
    @Autowired
    private BombaRepository bombaRepository;

    public List<Bomba> listar(){
        return bombaRepository.findAll();
    }

    public Optional<Bomba> listarPorId(Integer id){
        return bombaRepository.findById(id);
    }

    public Bomba atualizar(Integer id,Bomba bombaAtualizada){
        Optional<Bomba> bombaExisteOptional = bombaRepository.findById(id);

        if (bombaExisteOptional.isEmpty()){
            return null;
        }

        Bomba bombaExiste = bombaExisteOptional.get();

        bombaExiste.setNome(bombaAtualizada.getNome());
        bombaExiste.setCombustivel(bombaAtualizada.getCombustivel());

        return bombaRepository.save(bombaExiste);
    }

    public Bomba salvar(Bomba bomba){
        return bombaRepository.save(bomba);
    }

    @Transactional
    public void deletar(Integer id){
        bombaRepository.deleteById(id);
    }
}
