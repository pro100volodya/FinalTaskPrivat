package optimization;

public interface CompanyDAO {
     Company findById(int id);
     void save(Company company);
     void update(Company company);
     void delete(Company company);
}
