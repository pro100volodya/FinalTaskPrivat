package optimization;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Legal Department")
public class LegalDepartment extends Company{

    public LegalDepartment(int startWorkday, int endWorkday, int amountOfEmployees) {
        super(startWorkday, endWorkday, amountOfEmployees);
    }

    @Override
    public void workEarlier(int amountOfEmployeeForOptimization, int changeTime, double efficiency,String resultChoice) {
        resultOfOptimization = amountOfEmployeeForOptimization * changeTime * efficiency;
        String result = String.format("%.1f",resultOfOptimization);
        modeOfOptimization = "Work earlier on %d".formatted(changeTime)+" hours";
        System.out.println(resultChoice + " from optimization in LegalDepartment will increase " + result + " times");
    }

    @Override
    public void workLater(int amountOfEmployeeForOptimization, int changeTime, double efficiency,String resultChoice) {
        resultOfOptimization = amountOfEmployeeForOptimization * changeTime * efficiency;
        String result = String.format("%.1f",resultOfOptimization);
        modeOfOptimization = "Work later on %d".formatted(changeTime)+" hours";
        System.out.println(resultChoice + " from optimization in LegalDepartment will increase " + result + " times");
    }

    @Override
    public void workInOldConditions() {
        modeOfOptimization = "Work in old conditions";
        System.out.println("We continue to work in old conditions");
        resultOfOptimization=0;
        System.out.println("Income from optimization in LegalDepartment will increase " + resultOfOptimization + " times");
    }

    @Override
    public void workRemotely(int amountOfEmployeeForOptimization, double efficiency, String resultChoice) {
        resultOfOptimization = amountOfEmployeeForOptimization * durationWorkday * efficiency;
        String result = String.format("%.1f",resultOfOptimization);
        modeOfOptimization = "Work remotely";
        System.out.println(resultChoice + " from optimization in LegalDepartment will increase " + result + " times per day");
    }

    @Override
    public String toString() {
        return "LegalDepartment(" +
                "startWorkday=" + startWorkday +
                ", endWorkday=" + endWorkday +
                ", durationWorkday=" + durationWorkday +
                ", LUNCH_BREAK=" + LUNCH_BREAK +
                ", amountOfEmployees=" + amountOfEmployees +
                ')';
    }
}

