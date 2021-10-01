package optimization;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "kindOfEmployee",discriminatorType=DiscriminatorType.STRING)
@Table(name = "employee")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(insertable = false, updatable = false)
    protected String kindOfEmployee;

    protected String fullName;
    protected int age;
    protected String position;
    public Employee(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        Role role=new Role();
        this.position=role.choosePosition(role);
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
