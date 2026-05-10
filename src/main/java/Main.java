import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String command = scanner.next();
            if(Objects.equals(command.toLowerCase(), "exit")){
                return;
            }
            System.out.println(command + ": command not found");
        }
    }
}
