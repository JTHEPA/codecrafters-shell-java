import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
         String command =scanner.next();
         System.out.print("$ "+command+": command not found");
    }
}
