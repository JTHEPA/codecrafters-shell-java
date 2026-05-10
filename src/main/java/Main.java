import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String command = scanner.nextLine();
            String[] types = {"type","echo","exit"};
            if(Objects.equals(command.toLowerCase(), "exit")){
                return;
            } else if (command.startsWith("echo ")) {
                System.out.println(command.substring(5));
            } else if (command.startsWith("type ")) {
                if(command.substring(5).contains(Arrays.toString(types))){
                    System.out.println(command.substring(5)+ ": is a shell builtin");
                }
            } else{
                System.out.println(command+ ": command not found");
            }

        }
    }
}
