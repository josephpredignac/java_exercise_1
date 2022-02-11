import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command{
    public static void freq(String file) {
        file = file.toLowerCase().replaceAll("[^a-z^\n^ ]", "");
        String[] array = file.split("[ \n]");
        Stream<String> stream = Arrays.stream(array);
        Stream<Map.Entry<String, Long>> map = stream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingInt((entry) -> {
                    return -Math.toIntExact(entry.getValue());
                })).limit(3);

        map.forEach((elem) -> {
            System.out.print(elem.getKey());
            System.out.print(' ');
        });
        System.out.println();

    }

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donne un chemin de fichier");
        String command = sc.nextLine();
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
        return false;
    }
}
