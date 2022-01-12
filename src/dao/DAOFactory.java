package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.ManageCourseDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch (daoType){
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case MANAGECOURSE:
                return (T) new ManageCourseDAOImpl();

            default:
                return null;
        }
    }
}
