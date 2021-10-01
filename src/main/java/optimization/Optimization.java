package optimization;

import java.util.Scanner;

public class Optimization {
    int amountOfEmployeesForOptimization;
    double efficiency;
    int changeTime;
    String resultChoice;

    public void optimize(Company company){
        Scanner scanner =new Scanner(System.in);
        boolean validInput = false;
        int permissionForSwitch;
        int choiceForSwitch;
        int suitableChangeForSwitch;
        int modeForSwitch;

        do {
            System.out.println("Is it allowed to change working hours of department?");
            System.out.println("(1) - Yes \n(2) - No");
            permissionForSwitch = scanner.nextInt();
            if(permissionForSwitch>=1 && permissionForSwitch<=2){
                validInput = true;
            }else System.out.println("You have entered incorrect input! Please input a number 1 or 2.");
        }while (!validInput);
        validInput=false;

        switch (permissionForSwitch){
            case 1 -> {
                do {
                    System.out.println("Do you want to change working hours of the entire department or only employee?");
                    System.out.println("(1) - Entire department \n(2) - Only employee");
                    choiceForSwitch = scanner.nextInt();
                    if(choiceForSwitch>=1 && choiceForSwitch<=2){
                        validInput = true;
                    }else System.out.println("You have entered incorrect input! Please input a number 1 or 2.");
                }while (!validInput);
                validInput=false;

                switch (choiceForSwitch){
                    case 1 -> amountOfEmployeesForOptimization = company.amountOfEmployees;
                    case 2 -> {
                        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                        employeeDAO.save(EmployeeFactory.createEmployee());
                        amountOfEmployeesForOptimization = 1;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + choiceForSwitch);
                }
            }
            case 2 -> company.workInOldConditions();
            default -> throw new IllegalStateException("Unexpected value: " + permissionForSwitch);
        }

        if(permissionForSwitch==1) {
            efficiency = 0.2;
            do {
                System.out.println("Is the change suitable for the employees? \n(1) - Yes \n(2) - No");
                suitableChangeForSwitch=scanner.nextInt();
                if(suitableChangeForSwitch>=1 && suitableChangeForSwitch<=2){
                    validInput = true;
                }else System.out.println("You have entered incorrect input! Please input a number 1 or 2.");
            }while (!validInput);
            validInput=false;

            switch (suitableChangeForSwitch){
                case 1 -> resultChoice = "Income";
                case 2 -> resultChoice = "Loss";
                default -> throw new IllegalStateException("Unexpected value: " + suitableChangeForSwitch);
            }

            do {
                System.out.println("Select mode:");
                System.out.println("(1) - Start work earlier \n(2) - Start work later \n(3) - Work in old conditions \n(4) - Work remotely");
                modeForSwitch =scanner.nextInt();
                if(modeForSwitch>=1 && modeForSwitch<=4){
                    validInput = true;
                }else System.out.println("You have entered incorrect input! Please input a number from 1 to 4.");
            }while (!validInput);
            validInput=false;

            switch (modeForSwitch){
                case 1 -> {
                    do {
                        System.out.print("How much earlier do you want to change working hours:");
                        changeTime = scanner.nextInt();
                        if (changeTime > 0 && company.startWorkday - changeTime > 0) {
                            validInput=true;
                            company.workEarlier(amountOfEmployeesForOptimization, changeTime, efficiency, resultChoice);
                        } else System.out.println("You have entered incorrect input!");
                    }while (!validInput);
                }
                case 2 -> {
                    do {
                        System.out.print("How much later do you want to change working hours:");
                        changeTime = scanner.nextInt();
                        if (changeTime > 0 && company.endWorkday + changeTime < 24) {
                            validInput=true;
                            company.workLater(amountOfEmployeesForOptimization, changeTime, efficiency, resultChoice);
                        } else System.out.println("You have entered incorrect input!");
                    }while (!validInput);
                }
                case 3 ->{
                    company.workInOldConditions();
                }
                case 4 ->{
                    efficiency = 0.1;
                    company.workRemotely(amountOfEmployeesForOptimization,efficiency,resultChoice);
                }
                default -> throw new IllegalStateException("Unexpected value: " + modeForSwitch);
            }
        }
    }
}
