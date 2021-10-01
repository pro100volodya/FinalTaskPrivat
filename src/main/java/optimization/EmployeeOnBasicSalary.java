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
@DiscriminatorValue("Employee on basic salary")
public class EmployeeOnBasicSalary extends Employee {

    @Transient
    int salaryInDollarsPerMonth;
    public EmployeeOnBasicSalary(String fullName, int age) {
        super(fullName, age);
    }
    public EmployeeOnBasicSalary(String fullName, int age, int salaryInDollarsPerMonth) {
        super(fullName, age);
        this.salaryInDollarsPerMonth=salaryInDollarsPerMonth;
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
