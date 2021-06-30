import java.util.Scanner;

public class Tp {

    public static void main(String[] args) {
        Compilateur cmp=new Compilateur();
        String ligne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Démarage de l\'interpreteur...\nPour quiter tapez quit");
        do {
            System.out.print(">> ");
            ligne= sc.nextLine();
            if (!ligne.equals("quit"))
            cmp.Complie(ligne);
        } while (!ligne.equals("quit"));
        System.out.println("Au revoir");



    }

}
