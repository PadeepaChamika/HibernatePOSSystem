package dao.custom;

import dao.SuperDAO;
import entity.ManageCourse;

public interface ManageCourseDAO extends SuperDAO<ManageCourse , String> {
    String getLastRegisterId() throws Exception;

    boolean existsByStudentId(String studentId) throws  Exception;
}
