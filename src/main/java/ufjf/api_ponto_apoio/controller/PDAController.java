package ufjf.api_ponto_apoio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ufjf.api_ponto_apoio.services.PDAService;
import ufjf.api_ponto_apoio.classes.PDA;

/**
 * Classe controladora da API
 * Recebe e processa as requisições, solicitando ao Service qualquer tipo de consulta ou tratamento de dados
 */


// Mapeia a API REST
@RestController
@RequestMapping("/ms-places")

public class PDAController {

    @Autowired
    private PDAService pdaService;

    @RequestMapping(value = "/q/{field}={param}", method = RequestMethod.GET)
    public ResponseEntity<List<PDA>> queryBy(@PathVariable("field") String field, @PathVariable("param") String param) {
        switch(field) {
            case "rua": return ResponseEntity.ok(pdaService.findByRua(param));
            case "bairro": return ResponseEntity.ok(pdaService.findByBairro(param));
            case "cidade": return ResponseEntity.ok(pdaService.findByCidade(param));
            case "cep": return ResponseEntity.ok(pdaService.findByCEP(param));
            default: return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<PDA>> getPDAs() {
        List<PDA> re = pdaService.getAll();
        if(re == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(re);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PDA> getById(@PathVariable String id) {
        PDA p = pdaService.findById(id);
        if(p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PDA> addPDA(@Valid @RequestBody PDA pda) {
        PDA novo = pdaService.insert(pda);
        return ResponseEntity.ok(novo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PDA> updatePDA(@PathVariable String id, @Valid @RequestBody PDA pda) {
        PDA atualizado = pdaService.update(id,pda);
        if(atualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        pdaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    

}