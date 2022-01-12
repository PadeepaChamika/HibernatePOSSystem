package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CourseDAO;
import dao.custom.impl.CourseDAOImpl;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAOImpl courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public boolean add(CourseDTO courseDTO) throws Exception {
        return courseDAO.add(new Course(
                courseDTO.getCourseId(),
                courseDTO.getProgram(),
                courseDTO.getDuration(),
                courseDTO.getCourseFee()
        ));
    }

    @Override
    public boolean update(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(
           courseDTO.getCourseId(),
           courseDTO.getProgram(),
           courseDTO.getDuration(),
           courseDTO.getCourseFee()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public List<CourseDTO> findAll() throws Exception {
        List<Course> all = courseDAO.findAll();
        System.out.println(all.size());
        ArrayList<CourseDTO> dtoList = new ArrayList<>();
         for (Course courseDTO : all){
             dtoList.add(new CourseDTO(
                     courseDTO.getCourseId(),
                     courseDTO.getProgram(),
                     courseDTO.getDuration(),
                     courseDTO.getCourseFee()
             ));
         }
         return dtoList;
    }

    @Override
    public List<String> getAllCourseId() throws Exception {
        ArrayList<String> idList = new ArrayList<>();
        try {
            List<Course> all = courseDAO.findAll();
            for (Course dto : all){
                idList.add(dto.getCourseId());
            }
            return idList;

        }catch (Exception e){
            e.printStackTrace();
            return idList;
        }
    }
    @Override
    public CourseDTO findCourse(String Id) throws Exception {
        Course course = courseDAO.find(Id);
        return new CourseDTO(course.getCourseId(),
                course.getProgram(),course.getDuration(),course.getCourseFee());
    }
}
