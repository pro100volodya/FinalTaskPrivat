package optimization;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyDAOImpl implements CompanyDAO{

    @Override
    public Company findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Company.class, id);
    }

    @Override
    public void save(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(company);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(company);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(company);
        tx1.commit();
        session.close();
    }

}
