import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {
        List<Command> list = new ArrayList<>(Arrays.asList(new Fibo(), new Freq(), new Quit()));
        System.out.println("Salut bg du 92");
        Scanner sc = new Scanner(System.in);
        String command;
        while (true) {
            command = sc.nextLine();
            int co = 0;
            for (Command c:list) {
                if (c.name().equals(command)) {
                    boolean exit = c.run(sc);
                    if (exit)
                        System.exit(0);
                    co = 1;
                    break;
                }
            }
            if (co == 0)
                System.out.println("Unknown command");
        }
    }
}
