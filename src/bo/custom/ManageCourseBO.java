package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import dto.ManageCourseDTO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface ManageCourseBO extends SuperBO {
    boolean ManageCourse(ManageCourseDTO dto) throws Exception;

    ArrayList<StudentDTO> getAllStudents() throws Exception;

    ArrayList<CourseDTO> getAllCourses() throws Exception;

    CourseDTO searchCourse(String code) throws Exception;

    StudentDTO searchStudent(String s) throws Exception;

    String getLastRegisterId() throws Exception;
}
