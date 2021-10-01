package optimization;

import java.util.Scanner;

public class DepartmentFactory {
    public static Company createDepartment(){
        Company company;
        int startWorkday;
        int endWorkday;
        int amountOfEmployees;
        boolean validInput=false;
        int choiceForSwitch;

        Scanner scanner =new Scanner(System.in);
        do {
            System.out.println("Input number of department in which the employee works");
            System.out.println("(1) - Economic Department \n(2) - Legal Department \n(3) - IT Department");
            choiceForSwitch = scanner.nextInt();
            if(choiceForSwitch>=1 && choiceForSwitch<=3){
                validInput = true;
            }else System.out.println("You have entered incorrect input! Please input a number from 1 to 3.");
        }while (!validInput);
        validInput=false;

        do {
            System.out.print("Input the hour of the start working day: ");
            startWorkday=scanner.nextInt();
            if(startWorkday>0 && startWorkday<23){
                validInput = true;
            }else System.out.println("You have entered incorrect input, the beginning of the working day can`t start earlier than 0!");
        }while (!validInput);
        validInput=false;

        do {
            System.out.print("Input the hour of the end working day: ");
            endWorkday=scanner.nextInt();
            if(endWorkday<24 && endWorkday>startWorkday){
                validInput = true;
            }else System.out.println("You have entered incorrect input, the end of the working day can`t be earlier than the beginning of the working and end later than 24!");
        }while (!validInput);
        validInput=false;

        do {
            System.out.print("Input amount of employees in the department: ");
            amountOfEmployees=scanner.nextInt();
            if(amountOfEmployees>0){
                validInput = true;
            }else System.out.println("You have entered incorrect input, amount of employees can`t be negative!");
        }while (!validInput);

        switch (choiceForSwitch){
            case 1 -> company = new EconomicDepartment(startWorkday,endWorkday,amountOfEmployees);
            case 2 -> company = new LegalDepartment(startWorkday,endWorkday,amountOfEmployees);
            case 3 -> company = new ITDepartment(startWorkday,endWorkday,amountOfEmployees);
            default -> throw new IllegalStateException("Unexpected value: " + choiceForSwitch);
        }
        return company;
    }
}
