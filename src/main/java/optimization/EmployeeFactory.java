package optimization;

import java.util.Scanner;
public class EmployeeFactory {
    public static Employee createEmployee(){
        Employee employee;
        Scanner scanner=new Scanner(System.in);
        String fullName;
        int age;
        boolean validInput = false;
        int choiceForSwitch;
        do {
            System.out.println("Input number of mode the calculation method employee`s salary.");
            System.out.println("(1) - Employee on basic salary \n(2) - Employee with hourly pay \n(3) - Employee on basic salary plus percentage of monthly sales ");
            choiceForSwitch = scanner.nextInt();
            if(choiceForSwitch>=1 && choiceForSwitch<=3){
                validInput = true;
            }else System.out.println("You have entered incorrect input! Please input a number from 1 to 3.");
        }while (!validInput);
        validInput=false;

        do{
            Scanner scanner2=new Scanner(System.in);
            System.out.print("Input full name: ");
            fullName = scanner2.nextLine();
            if (!fullName.isEmpty()){
                validInput = true;
            }else System.out.println("You have entered incorrect input, variable can`t be empty!");
        }while (!validInput);
        validInput = false;

        do {
            System.out.print("Input age of employee: ");
            age=scanner.nextInt();
            if(age>=18 && age<=80){
                validInput = true;
            }else System.out.println("You have entered incorrect input, age can`t be less than 18 and more than 80!");
        }while (!validInput);

        switch (choiceForSwitch){
            case 1 -> employee = new EmployeeOnBasicSalary(fullName, age);
            case 2 -> employee = new EmployeeWithHourlyPay(fullName,age);
            case 3 -> employee = new EmployeeOnBasicSalaryPlusPercent(fullName,age);
            default -> throw new IllegalStateException("Unexpected value: " + choiceForSwitch);
        }
        System.out.println(employee);
        return employee;
    }
}
