import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuestionValidator {

    private static final int TOTAL_PERGUNTAS = 8;
    private static final int ACERTOS_PARA_PASSAR = 4;

    private final List<Question> banco;
    private final Scanner scanner;

    public QuestionValidator(List<Question> banco, Scanner scanner) {
        this.banco = banco;
        this.scanner = scanner;
    }

    /**
     * Executa a rodada de perguntas.
     * Retorna true se o jogador acertou ACERTOS_PARA_PASSAR antes de esgotar as tentativas.
     * A cada pergunta, chama os callbacks onAcerto ou onErro para o BattleManager agir.
     */
    public boolean executarRodada(RodadaCallback callback) {
        List<Question> embaralhadas = new ArrayList<>(banco);
        Collections.shuffle(embaralhadas);

        // Garante que não tenta pegar mais perguntas do que há no banco
        int limite = Math.min(TOTAL_PERGUNTAS, embaralhadas.size());

        int acertos = 0;
        int erros = 0;
        int maxErros = TOTAL_PERGUNTAS - ACERTOS_PARA_PASSAR;

        for (int i = 0; i < limite; i++) {
            Question q = embaralhadas.get(i);

            System.out.println("\n--- Pergunta " + (i + 1) + " ---");
            q.mostrarEnunciado();
            q.mostrarAlternativas();
            System.out.print("Sua resposta: ");
            String entrada = scanner.nextLine().trim();

            if (q.verificarResposta(entrada)) {
                System.out.println("✔ Correto!");
                acertos++;
                callback.onAcerto();

                if (acertos >= ACERTOS_PARA_PASSAR) {
                    System.out.println("\nVocê acertou " + acertos + " perguntas. Fase superada!");
                    return true;
                }
            } else {
                System.out.println("✘ Errado! A resposta correta era: " + q.getResposta());
                erros++;
                callback.onErro();

                if (erros > maxErros) {
                    System.out.println("\nVocê errou demais. O inimigo venceu esta batalha.");
                    return false;
                }
            }
        }

        // Chegou ao fim das perguntas — avalia pelo saldo
        return acertos >= ACERTOS_PARA_PASSAR;
    }

    // Interface funcional para o BattleManager reagir a cada resposta
    public interface RodadaCallback {
        void onAcerto();
        void onErro();
    }
}