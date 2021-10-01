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
@DiscriminatorValue("Employee with hourly pay")
public class EmployeeWithHourlyPay extends Employee{

    @Transient
    int salaryInDollarsPerHour;
    public EmployeeWithHourlyPay(String fullName, int age) {
        super(fullName, age);
    }
    public EmployeeWithHourlyPay(String fullName, int age, int salaryInDollarsPerHour) {
        super(fullName, age);
        this.salaryInDollarsPerHour=salaryInDollarsPerHour;
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
