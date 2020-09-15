package xuzili.dao;

import xuzili.model.*;
import xuzili.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamDao {
    public static List<Exam> queryAsDict() {
        List<Exam> exams = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection c = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select" +
                    "  e.id," +
                    "  e.exam_name," +
                    "  e.create_time," +
                    "  e.exam_desc," +
                    "  e.classes_id," +
                    "  e.course_id," +
                    "  c1.classes_name," +
                    "  c2.course_name" +
                    " from stu_exam.exam e" +
                    "  join stu_exam.classes c1 on e.classes_id = c1.id" +
                    "  join stu_exam.course c2 on e.course_id = c2.id;";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                //设置考试对象e
                Exam e = new Exam();
                e.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                e.setDictionaryTagValue(rs.getString("exam_name"));
                e.setExamDesc(rs.getString("exam_desc"));
                e.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                //设置班级对象
                Classes classes = new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                e.setClasses(classes);
                //设置课程对象
                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                e.setCourse(course);

                exams.add(e);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典出错",e);
        }
        return exams;
    }
}
