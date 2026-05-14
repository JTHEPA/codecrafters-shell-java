import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String command = scanner.nextLine();
            String[] types = {"type", "echo", "exit"};
            if (Objects.equals(command.toLowerCase(), "exit")) {
                break;
            } else if (command.startsWith("echo ")) {
                System.out.println(command.substring(5));
            } else if (command.startsWith("type ")) {
                boolean found = false;
                for (String newCommand : types) {
                    if (Objects.equals(command.substring(5), newCommand)) {
                        found = true;
                        System.out.println(command.substring(5) + " is a shell builtin");
                    }
                }
                if (!found) {
                    String search = System.getenv("PATH");
                    String[] paths = search.split(File.pathSeparator);
                    for (String word : paths) {
                        Path path = Path.of(word, command.substring(5));
                        if (Files.isExecutable(path)) {
                            System.out.println(command.substring(5) + " is " + path.toAbsolutePath());
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    System.out.println(command.substring(5) + ": not found");
                } else if (!found) {

                    String cmd = command.substring(5);

                    String search = System.getenv("PATH");
                    String[] paths = search.split(File.pathSeparator);

                    for (String directory : paths) {

                        Path path = Path.of(directory, cmd);

                        if (Files.exists(path) && Files.isExecutable(path)) {

                            System.out.println(cmd + " is " + path.toAbsolutePath());

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(cmd + ": not found");
                    }
                }

                }else{
                    System.out.println(command + ": command not found");
                }
            }
        }
}
