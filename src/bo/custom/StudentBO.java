package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    public List<StudentDTO> findAll() throws Exception;

    List<String> getAllStudentId() throws Exception;

    public StudentDTO findStudent(String sId) throws Exception;
}
