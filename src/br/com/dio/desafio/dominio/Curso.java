package br.com.dio.desafio.dominio;

/**
 * Classe que representa um curso dentro do bootcamp.
 * Herda propriedades e comportamentos da classe Conteudo.
 */
public class Curso extends Conteudo {

    // Carga horária do curso em horas
    private int cargaHoraria;

    /**
     * Implementação do cálculo de XP para cursos.
     * O XP é calculado multiplicando o XP padrão pela carga horária.
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    // Construtor padrão da classe
    public Curso() {
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Define a carga horária do curso com validação
    public void setCargaHoraria(int cargaHoraria) {
    // Garante que a carga horária não seja negativa
    if (cargaHoraria < 0) {
        throw new IllegalArgumentException("Carga horária não pode ser negativa");
    }

    this.cargaHoraria = cargaHoraria;
    }

    /**
     * Sobrescrita do método toString para facilitar
     * visualização do objeto em logs ou debug.
     */
    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
