package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Classe que representa um Desenvolvedor (Dev) participante do Bootcamp.
 *
 * O Dev pode:
 * - Se inscrever em um Bootcamp
 * - Progredir nos conteúdos
 * - Acumular XP conforme conclui cursos e mentorias
 */
public class Dev {

    // Nome do desenvolvedor
    private String nome;

    /**
     * Conteúdos nos quais o Dev está atualmente inscrito.
     *
     * LinkedHashSet evita duplicação e mantém a ordem de inserção,
     * garantindo que o progresso aconteça na sequência correta.
     */
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

    /**
     * Conteúdos que o Dev já concluiu.
     */
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /**
     * Realiza a inscrição do Dev em um Bootcamp.
     *
     * Todos os conteúdos do bootcamp são adicionados
     * à lista de conteúdos inscritos do Dev.
     */
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    /**
     * Permite que o Dev avance para o próximo conteúdo.
     *
     * O primeiro conteúdo da lista de inscritos é movido
     * para a lista de conteúdos concluídos.
     */
    public void progredir() {

        Optional<Conteudo> conteudo = this.conteudosInscritos
                .stream()
                .findFirst();

        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    /**
     * Calcula o total de XP acumulado pelo Dev
     * com base nos conteúdos concluídos.
     */
    public double calcularTotalXp() {

        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;

        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }

        return soma;

        /*
        Implementação alternativa usando Stream API (Java moderno):

        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
        */
    }

    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do desenvolvedor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    /**
     * Define os conteúdos nos quais o Dev está inscrito.
     */
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    /**
     * Define os conteúdos concluídos pelo Dev.
     */
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    /**
     * Sobrescrita do equals para comparação entre objetos Dev.
     * Importante para funcionamento correto em coleções como Set.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;

        return Objects.equals(nome, dev.nome) &&
               Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
               Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    /**
     * Sobrescrita do hashCode para manter consistência com equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
