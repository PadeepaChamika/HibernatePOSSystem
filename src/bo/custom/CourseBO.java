package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean add(CourseDTO courseDTO) throws Exception;

    public boolean update(CourseDTO courseDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    public List<CourseDTO> findAll() throws Exception;

    List<String> getAllCourseId() throws Exception;

    CourseDTO findCourse(String Id) throws Exception;
}
