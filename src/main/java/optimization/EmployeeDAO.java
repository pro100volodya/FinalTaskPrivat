package optimization;

public interface EmployeeDAO {
    Employee findById(int id);
    void save(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}
