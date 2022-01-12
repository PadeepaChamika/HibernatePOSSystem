package dao.custom.impl;

import dao.custom.ManageCourseDAO;
import entity.ManageCourse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.List;

public class ManageCourseDAOImpl implements ManageCourseDAO {

    @Override
    public String getLastRegisterId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        String i = (String) session.createNativeQuery("SELECT registerId FROM ManageCourse ORDER BY registerId DESC LIMIT 1")
                .uniqueResult();
        return (i == null) ? null : i;
    }

    @Override
    public boolean existsByStudentId(String studentId) throws Exception {
        return false;
    }

    @Override
    public boolean add(ManageCourse entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ManageCourse entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ManageCourse find(String s) throws Exception {
        return null;
    }

    @Override
    public List<ManageCourse> findAll() throws Exception {
        return null;
    }
}
