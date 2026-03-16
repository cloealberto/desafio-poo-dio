import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

/**
 * Classe responsável por executar a aplicação.
 *
 * Aqui simulamos o funcionamento do sistema:
 * - Criação de cursos e mentorias
 * - Criação de um bootcamp
 * - Inscrição de desenvolvedores
 * - Progressão nos conteúdos
 * - Cálculo de XP acumulado
 */
public class Main {

    public static void main(String[] args) {

        // Criação do primeiro curso
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do curso Java");
        curso1.setCargaHoraria(8);

        // Criação do segundo curso
        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição do curso JavaScript");
        curso2.setCargaHoraria(4);

        // Criação da mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria de Java");
        mentoria.setData(LocalDate.now());

        // Criação do bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp Java Developer");

        // Adicionando conteúdos ao bootcamp
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criação da desenvolvedora Camila
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");

        // Camila se inscreve no bootcamp
        devCamila.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudosInscritos());

        // Camila progride em dois conteúdos
        devCamila.progredir();
        devCamila.progredir();

        System.out.println("-");
        System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Camila: " + devCamila.getConteudosConcluidos());
        System.out.println("XP Camila: " + devCamila.calcularTotalXp());

        System.out.println("-------");

        // Criação do desenvolvedor João
        Dev devJoao = new Dev();
        devJoao.setNome("João");

        // João se inscreve no bootcamp
        devJoao.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());

        // João progride em três conteúdos
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("-");
        System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos concluídos João: " + devJoao.getConteudosConcluidos());
        System.out.println("XP João: " + devJoao.calcularTotalXp());
    }
}
