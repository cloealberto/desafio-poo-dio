package br.com.dio.desafio.dominio;

/**
 * Classe abstrata que representa um conteúdo educacional.
 * Não pode ser instanciada diretamente, apenas herdada por outras classes
 * como Curso ou Mentoria.
 */
public abstract class Conteudo {

    /**
     * Constante de XP base usada no cálculo de experiência.
     * static = pertence à classe
     * final = não pode ser alterada
     */
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    /**
     * Método abstrato que obriga as classes filhas
     * a implementarem sua própria lógica de cálculo de XP.
     */
    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    // Setter responsável por definir o título do conteúdo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setter responsável por definir a descrição do conteúdo
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Sobrescrita do método toString para facilitar debug
     * e visualização do objeto em logs.
     */
    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
