package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa um Bootcamp.
 *
 * Um Bootcamp possui:
 * - Nome
 * - Descrição
 * - Data de início
 * - Data final (calculada automaticamente)
 * - Conteúdos (Cursos e Mentorías)
 * - Desenvolvedores inscritos
 */
public class Bootcamp {

    // Nome do bootcamp
    private String nome;

    // Descrição do bootcamp
    private String descricao;

    // Data de início definida automaticamente na criação do objeto
    private final LocalDate dataInicial = LocalDate.now();

    /**
     * Data final calculada automaticamente
     * com base na duração padrão do bootcamp.
     */
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    /**
     * Conjunto de desenvolvedores inscritos.
     *
     * HashSet é utilizado para evitar duplicação de desenvolvedores.
     */
    private Set<Dev> devsInscritos = new HashSet<>();

    /**
     * Conjunto de conteúdos do bootcamp.
     *
     * LinkedHashSet evita duplicação e mantém a ordem de inserção
     * dos conteúdos (curso, mentoria, etc).
     */
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do bootcamp.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do bootcamp.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a data de início do bootcamp.
     */
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    /**
     * Retorna a data final do bootcamp.
     */
    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    /**
     * Define os desenvolvedores inscritos no bootcamp.
     */
    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    /**
     * Define os conteúdos disponíveis no bootcamp.
     */
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    /**
     * Sobrescrita do equals para comparação entre objetos Bootcamp.
     * Importante para funcionamento correto em coleções como Set.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
               Objects.equals(descricao, bootcamp.descricao) &&
               Objects.equals(dataInicial, bootcamp.dataInicial) &&
               Objects.equals(dataFinal, bootcamp.dataFinal) &&
               Objects.equals(devsInscritos, bootcamp.devsInscritos) &&
               Objects.equals(conteudos, bootcamp.conteudos);
    }

    /**
     * Sobrescrita do hashCode para manter consistência com equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}