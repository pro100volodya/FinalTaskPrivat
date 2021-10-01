package optimization;

public class Main {
    public static void main(String[] args) {

        Company company=DepartmentFactory.createDepartment();
        System.out.println(company);

        Optimization optimization =new Optimization();
        optimization.optimize(company);

        CompanyDAOImpl companyDAO =new CompanyDAOImpl();
        companyDAO.save(company);

    }
}
