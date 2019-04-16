package ufjf.api_ponto_apoio.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufjf.api_ponto_apoio.classes.PDA;
import ufjf.api_ponto_apoio.repo.PDARepository;

/**
 * Implementação da interface
 */

@Service ("PDAService")
public class PDAServiceImplementation implements PDAService {

    @Autowired
    private PDARepository repository;

    public List<PDA> getAll() {
        return repository.findAll();
    }

    
    @Override
    public List<PDA> findByCEP(String cep) {
        return repository.findByCep(cep);
    }

    @Override
    public List<PDA> findByRua(String rua) {
        return repository.findByRuaLikeIgnoreCase(rua);
    }


    @Override
    public List<PDA> findByCidade(String cidade) {
        return repository.findByCidadeLikeIgnoreCase(cidade);
    }

    @Override
    public List<PDA> findByBairro(String bairro) {
        return repository.findByBairroLikeIgnoreCase(bairro);
    }
    

    public PDA findById(String id) {
        PDA get = repository.findById(id).get();
        return get;
    }


    public PDA insert(PDA p) {
        PDA novo = new PDA();
        BeanUtils.copyProperties(p, novo, "id");
        return repository.save(novo);
    }

    public PDA update(String id,PDA p) {
        try {
            PDA existente = repository.findById(id).get();
            BeanUtils.copyProperties(p, existente, "id");
            return repository.save(existente);
        } catch(NoSuchElementException e) {
            return null;
        }
    }

    public void delete(PDA p) {
        repository.delete(p);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}