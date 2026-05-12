import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuestionLoader loader = new QuestionLoader("portuguesequestion.txt");
    Faceis nivelFacil = new Faceis(loader);

// Para printar apenas a questão 3:
nivelFacil.printarQuestao(7);



    }
    
}
