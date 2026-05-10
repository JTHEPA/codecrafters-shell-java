import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
         System.out.print("$ ");
         String command =scanner.next();
         System.out.println(command+": command not found");
    }
}
