package bo.custom.impl;

import bo.custom.ManageCourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.ManageCourseDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.CourseDTO;
import dto.ManageCourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.ManageCourse;
import entity.Student;

import java.util.ArrayList;

public class ManageCourseBOImpl implements ManageCourseBO {
    CourseDAOImpl courseDAO= DAOFactory.getInstance().getDAO(DAOType.COURSE);
    StudentDAOImpl studentDAO= DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    ManageCourseDAOImpl manageCourseDAO = DAOFactory.getInstance().getDAO(DAOType.MANAGECOURSE);

    @Override
    public boolean ManageCourse(ManageCourseDTO dto) throws Exception {
        return manageCourseDAO.add(new ManageCourse(
               dto.getRegisterID(),
                dto.getName(),
                dto.getProgramId(),
                dto.getFees(),
                dto.getStudent(),
                dto.getCourses()
        ));
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<StudentDTO> allStudents = new ArrayList<>();
        ArrayList<Student> all = (ArrayList<Student>) studentDAO.findAll();
        for (Student s : all) {
            allStudents.add(new StudentDTO(s.getStudentId(), s.getName(), s.getBirthday(),s.getAddress(),
                    s.getNic(),s.getSchool(),s.getTelephoneNumber()));
        }
        return allStudents;
    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        ArrayList<CourseDTO> allCourses = new ArrayList<>();
        ArrayList<Course> all = (ArrayList<Course>) courseDAO.findAll();
        for (Course c : all) {
            allCourses.add(new CourseDTO(c.getCourseId(), c.getProgram(),c.getDuration() ,c.getCourseFee()));
        }
        return allCourses;
    }

    @Override
    public CourseDTO searchCourse(String code) throws Exception {
        Course course = courseDAO.find(code);
        return new CourseDTO(course.getCourseId(), course.getProgram(),course.getDuration() ,course.getCourseFee());
    }

    @Override
    public StudentDTO searchStudent(String s1) throws Exception {
        Student s = studentDAO.find(s1);
        return new StudentDTO(s.getStudentId(), s.getName(), s.getBirthday(),s.getAddress(),
                s.getNic(),s.getSchool(),s.getTelephoneNumber());
    }

    @Override
    public String getLastRegisterId() throws Exception {
        String lastId = manageCourseDAO.getLastRegisterId();
        return lastId;
    }
}
