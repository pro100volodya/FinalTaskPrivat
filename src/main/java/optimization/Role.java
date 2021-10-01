package optimization;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Role {
    Set<String> position=new HashSet<>(List.of(
            "Economist", "Accountant", "Financial analyst", "Credit specialist", "Auditor",
            "Lawyer",
            "Software Developer", "Web Designer", "Software Test Engineer", "Project Manager"
    ));

    public String choosePosition(Role role){
        System.out.println("Position of employee " + role.position);
        Scanner scanner = new Scanner(System.in);
        String choicePosition;
        String collect;
        boolean validInput = false;
        do{
            System.out.print("Input position of the employee for optimization: ");
            choicePosition = scanner.nextLine();
            String finalChoicePosition = choicePosition;
            collect = role.position.stream().filter(x -> x.equals(finalChoicePosition)).collect(Collectors.joining());
            if (!collect.isEmpty()){
                validInput=true;
            }else System.out.println("You have entered incorrect input!");
        }while (!validInput);
        return collect;
    }
    
}
