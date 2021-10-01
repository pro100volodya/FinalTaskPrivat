package optimization;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Employee on basic salary plus percentage of monthly sales")
public class EmployeeOnBasicSalaryPlusPercent extends Employee{

    @Transient
    int salaryInDollarsPerMonth;
    @Transient
    double percentageOfMonthlySales;
    public EmployeeOnBasicSalaryPlusPercent(String fullName, int age) {
        super(fullName, age);
    }
     public EmployeeOnBasicSalaryPlusPercent(String fullName, int age, int salaryInDollarsPerMonth, double percentageOfMonthlySales) {
        super(fullName, age);
        this.salaryInDollarsPerMonth=salaryInDollarsPerMonth;
        this.percentageOfMonthlySales=percentageOfMonthlySales;
    }

    @Override
    public String toString() {
        return "Employee(" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ')';
    }
}
