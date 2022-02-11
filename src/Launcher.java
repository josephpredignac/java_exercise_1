import java.util.Scanner;

public class Launcher {
    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (fibo(n - 1) + fibo(n - 2));
    }

    public static void main(String[] args) {
        System.out.println("Salut bg du 92");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!command.equals("quit")) {
            if (command.equals("fibo")) {
                System.out.println("Donne un n");
                int n = sc.nextInt();
                command = sc.nextLine();
                System.out.println(fibo(n));
            }
            else {
                System.out.println("Unknown command");
            }
            command = sc.nextLine();
        }
    }
}
