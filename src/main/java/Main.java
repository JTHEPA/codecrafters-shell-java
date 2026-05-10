import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String command = scanner.nextLine();
            if(Objects.equals(command.toLowerCase(), "exit")){
                return;
            } else if (command.startsWith("echo ")) {
                System.out.println(command.substring(4));
            }else{
                System.out.println(command+ ": command not found");
            }

        }
    }
}
