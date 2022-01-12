package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Course;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public boolean add(Student entity) throws  Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Student entity) throws  Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public  boolean delete(String s) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    public Student find(String s) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);

        transaction.commit();
        session.close();
        return student;
    }

    public List<Student> findAll() throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = null;

        Query students = session.createQuery("from Student");
        list = students.list();

        transaction.commit();
        session.close();
        return list;
    }
}
