package br.com.dio.desafio.dominio;

import java.time.LocalDate;

/**
 * Classe que representa uma Mentoria dentro do Bootcamp.
 * 
 * Diferente de um Curso, a mentoria possui uma data específica
 * em que será realizada e concede um bônus fixo de XP.
 */
public class Mentoria extends Conteudo {

    // Data em que a mentoria acontecerá
    private LocalDate data;

    /**
     * Implementação do cálculo de XP para mentorias.
     * 
     * Mentorias possuem um bônus fixo adicional ao XP padrão.
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    // Construtor padrão
    public Mentoria() {
    }

    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data da mentoria.
     * 
     * Validação para impedir que uma mentoria seja criada
     * sem uma data definida.
     */
    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("A data da mentoria não pode ser nula");
        }
        this.data = data;
    }

    /**
     * Sobrescrita do método toString para facilitar
     * visualização do objeto em logs ou debug.
     */
    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}
