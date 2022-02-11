import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Salut bg du 92");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (!command.equals("quit")) {
            System.out.println("Unknown command");
        }
    }
}
