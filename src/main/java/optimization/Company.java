package optimization;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "nameOfDepartment",discriminatorType=DiscriminatorType.STRING)
@Table(name = "company")
public abstract class Company implements Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column(insertable = false, updatable = false)
    protected String nameOfDepartment;
    protected String modeOfOptimization;

    protected int startWorkday;
    protected int endWorkday;
    protected int durationWorkday;
    protected final int LUNCH_BREAK = 1;
    protected int amountOfEmployees;
    double resultOfOptimization;

    public Company(int startWorkday, int endWorkday,int amountOfEmployees) {
        this.startWorkday = startWorkday;
        this.endWorkday = endWorkday;
        this.durationWorkday=endWorkday - startWorkday - LUNCH_BREAK;
        this.amountOfEmployees=amountOfEmployees;
    }

}
