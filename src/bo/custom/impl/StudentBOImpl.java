package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Course;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getBirthday(),
                studentDTO.getAddress(),
                studentDTO.getNic(),
                studentDTO.getSchool(),
                studentDTO.getTelephoneNumber()
        ));
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getBirthday(),
                studentDTO.getAddress(),
                studentDTO.getNic(),
                studentDTO.getSchool(),
                studentDTO.getTelephoneNumber()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> findAll() throws Exception {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();
        for (Student studentDTO : all){
            dtoList.add(new StudentDTO(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getBirthday(),
                    studentDTO.getAddress(),
                    studentDTO.getNic(),
                    studentDTO.getSchool(),
                    studentDTO.getTelephoneNumber()
            ));
        }
        return dtoList;
    }

    @Override
    public List<String> getAllStudentId() throws Exception {
        ArrayList<String> idList = new ArrayList<>();
        try {
            List<Student> all = studentDAO.findAll();
            for (Student dto : all){
                idList.add(dto.getStudentId());
            }
            return idList;

        }catch (Exception e){
            e.printStackTrace();
            return idList;
        }
    }

    @Override
    public StudentDTO findStudent(String sId) throws Exception {
        Student student = studentDAO.find(sId);
        return new StudentDTO(
                student.getStudentId(),
                student.getName(),
                student.getBirthday(),
                student.getAddress(),
                student.getNic(),
                student.getSchool(),
                student.getTelephoneNumber()
        );
    }
}
