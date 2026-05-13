import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Carragadores
    QuestionLoader loaderPt = new QuestionLoader("C:\\Users\\MSF - 0085\\Desktop\\CodeArena-adanbandim-patch-1\\CodeArena-adanbandim-patch-1\\Questions\\portuguesequestion.txt");
    QuestionLoader loaderMt = new QuestionLoader("C:\\Users\\MSF - 0085\\Desktop\\CodeArena-adanbandim-patch-1\\CodeArena-adanbandim-patch-1\\Questions\\math.txt");
    RoteiroLoader jogo = new RoteiroLoader("C:\\Users\\MSF - 0085\\Desktop\\CodeArena-adanbandim-patch-1\\CodeArena-adanbandim-patch-1\\roteiro.txt");
    // Perguntas portugues
    Faceis nivelFacilPt = new Faceis(loaderPt);
    Medias nivelMedioPt = new Medias(loaderPt);
    Dificeis nivelDificilPt = new Dificeis(loaderPt);
    MuitoDificeis nivelMuitoDificilPt = new MuitoDificeis(loaderPt);    

    // Perguntas matematica
    Faceis nivelFacilMt = new Faceis(loaderMt);
    Medias nivelMedioMt = new Medias(loaderMt);
    Dificeis nivelDificilMt = new Dificeis(loaderMt);
    MuitoDificeis nivelMuitoDificilMt = new MuitoDificeis(loaderMt);

    // Fases

  
    } 
    
}
