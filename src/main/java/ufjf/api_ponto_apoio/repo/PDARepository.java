package ufjf.api_ponto_apoio.repo;



import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ufjf.api_ponto_apoio.classes.PDA;

/**
 * Interface com o Banco de Dados
 * Possui diversas queries prontas que so necessitam ser declaradas(por ex. as atuais)
 * Lista de queries 'prontas': https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html Table 6.1. Supported keywords for query methods
 */

@Repository
public interface PDARepository extends MongoRepository<PDA,String> {

    // Ja contem metodos CRUD basicos implementados

    // (@campo cep) == (@param cep)
    public List<PDA> findByCep(String cep);

    // equivalente a | select * from (@repo) where (@campo) like (@param)
    public List<PDA> findByRuaLikeIgnoreCase(String rua);
    public List<PDA> findByCidadeLikeIgnoreCase(String cidade);
    public List<PDA> findByBairroLikeIgnoreCase(String bairro);
    
}