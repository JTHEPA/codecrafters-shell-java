import java.nio.file.Files;
import java.nio.file.Path;
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
            } else if(command.startsWith("echo ")) {
                System.out.println(command.substring(5));
            } else if(command.startsWith("type ")) {
                boolean found = false;
                for(String newCommand : types){
                    if(Objects.equals(command.substring(5),newCommand)){
                        found = true;
                        System.out.println(command.substring(5)+ " is a shell builtin");
                    }
                }
                if(!found){
                    if(Files.isExecutable(Path.of(command.substring(5)))){
                        System.out.println(command.substring(5)+" is ");
                    }
                }
                if(!found){
                    System.out.println(command.substring(5)+ ": not found");
                }

            } else{
                System.out.println(command+ ": command not found");
            }

        }
    }
}
