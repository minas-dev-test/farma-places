package ufjf.api_ponto_apoio.classes;

import java.util.UUID;

import javax.validation.constraints.NotBlank;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Classe que representa o objeto Ponto de Apoio
 * Também linka o objeto ao banco de dados
 */


@Document(collection="pontos_de_apoio") // define a 'tabela' no BD
public class PDA {

    @Id
    private String id;

    @NotBlank(message="Campo nome não pode ser vazio")
    private String nome;

    @NotBlank(message="Campo CEP não pode ser vazio")
    private String cep;

    @NotBlank(message="Campo rua não pode ser vazio")
    private String rua;

    @NotBlank(message="Campo número não pode ser vazio")
    private String numero;
    
    private String complemento;

    @NotBlank(message="Campo bairro não pode ser vazio")
    private String bairro;

    @NotBlank(message="Campo cidade não pode ser vazio")
    private String cidade;

    @NotBlank(message="Campo estado não pode ser vazio")
    private String estado;

    private String pnt_referencia;

    private String hora_Abertura;

    private String hora_Fechamento;

    private GeoJsonPoint localizacao;

    public PDA() {
        this.id = gerarUID();
    }

    // gera id com 32 caracteres
    public String gerarUID() {
        //String id1 = UUID.randomUUID().toString().replace("-", "");
        String id1 = UUID.randomUUID().toString();
        return id1;
    }

    public String getEndereco() {
        return rua + " " + numero + " " + complemento + ", " + bairro + ", " + cidade + ", " + estado;
    }

    @Override
    public String toString() {
        return "PDA {" +
        "id: " + id + System.lineSeparator() +
        "nome: " + nome + System.lineSeparator() +
        "rua: " + rua + System.lineSeparator() +
        "numero: " + numero + System.lineSeparator() +
        "complemento: " + complemento + System.lineSeparator() +
        "bairro: " + bairro + System.lineSeparator() +
        "cidade: " + cidade + System.lineSeparator() +
        "estado: " + estado + System.lineSeparator() +
        "cep: " + cep + System.lineSeparator() +
        "pnt_referencia: " + pnt_referencia + System.lineSeparator() +
        "hora_Abertura: " + hora_Abertura + System.lineSeparator() +
        "hora_Fechamento: " + hora_Fechamento + System.lineSeparator() +
        "}";
    }
    

    /**
     * @return the hora_Abertura
     */
    public String getHora_Abertura() {
        return hora_Abertura;
    }

    /**
     * @return the hora_Fechamento
     */
    public String getHora_Fechamento() {
        return hora_Fechamento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }
    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }
    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }
    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }
    /**
     * @return the pnt_referencia
     */
    public String getPnt_referencia() {
        return pnt_referencia;
    }

    /**
     * @return the localizacao
     */
    public GeoJsonPoint getLocalizacao() {
        return localizacao;
    }


    /**
     * @param hora_Abertura the hora_Abertura to set
     */
    public void setHora_Abertura(String hora_Abertura) {
        this.hora_Abertura = hora_Abertura;
    }

    /**
     * @param hora_Fechamento the hora_Fechamento to set
     */
    public void setHora_Fechamento(String hora_Fechamento) {
        this.hora_Fechamento = hora_Fechamento;
    }
    

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }/**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * @param pnt_referencia the pnt_referencia to set
     */
    public void setPnt_referencia(String pnt_referencia) {
        this.pnt_referencia = pnt_referencia;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }


    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(GeoJsonPoint localizacao) {
        this.localizacao = localizacao;
    }

}