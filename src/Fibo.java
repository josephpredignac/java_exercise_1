import java.util.Scanner;

public class Fibo implements Command{
    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (fibo(n - 1) + fibo(n - 2));
    }

    public static void fiboo(Scanner sc) {
        System.out.println("Donne un n");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println(fibo(n));
    }

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        fiboo(scanner);
        return false;
    }
}
