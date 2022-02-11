import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {
    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (fibo(n - 1) + fibo(n - 2));
    }

    public static void freq(String file) {
        file = file.toLowerCase().replaceAll("[^a-z^\n^ ]", "");
        String[] array = file.split("[ \n]");
        Stream<String> stream = Arrays.stream(array);
        Stream<Map.Entry<String, Long>> map = stream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingInt((entry) -> {
                    return Math.toIntExact(entry.getValue());
                }))
                .limit(3);

        map.forEach((elem) -> {
            System.out.print(elem.getKey());
            System.out.print(' ');
        });
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println("Salut bg du 92");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!command.equals("quit")) {
            if (command.equals("freq")) {
                System.out.println("Donne un chemin de fichier");
                command = sc.nextLine();
                String file;
                Path path;
                try {
                    path = Paths.get(command);
                    file = java.nio.file.Files.readString(path);
                    freq(file);
                }
                catch (Exception e) {
                    System.out.println("Unreadable file: " + e.getClass().toString() + e.getMessage());
                    System.exit(1);
                }
            }
            else if (command.equals("fibo")) {
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
