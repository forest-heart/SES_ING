package xuzili.dao;

import xuzili.model.*;
import xuzili.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamRecordDao {

    public static List<ExamRecord> query() {
        List<ExamRecord> records = new ArrayList<>();

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql =
                    "select distinct" +
                    "  er.id," +
                    "  er.create_time," +
                    "  er.exam_record_desc," +
                    "  er.score," +
                    "  e.id            prefix_e_id," +
                    "  e.exam_name     prefix_e_exam_name," +
                    "  e.exam_desc     prefix_e_exam_desc," +
                    "  c1.id            prefix_c1_id," +
                    "  c1.classes_name  prefix_c1_classes_name," +
                    "  c2.id           prefix_c2_id," +
                    "  c2.course_name  prefix_c2_course_name," +
                    "  s.id            prefix_s_id," +
                    "  s.student_name  prefix_s_student_name," +
                    "  s.student_no    prefix_s_student_no," +
                    "  s.id_card       prefix_s_id_cord," +
                    "  s.student_email prefix_s_student_email" +
                    "  from stu_exam.exam_record er" +
                    "  join stu_exam.exam e on er.exam_id = e.id" +
                    "  join stu_exam.student s on s.id = er.student_id"+
                    "  join stu_exam.classes c1 on c1.id = s.classes_id" +
                    "  join stu_exam.course c2 on e.course_id = c2.id;";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               // 设置考试成绩对象
                ExamRecord examRecord = new ExamRecord();
                examRecord.setId(rs.getInt("id"));
                examRecord.setScore(rs.getBigDecimal("score"));
                examRecord.setExamRecordDesc(rs.getString("exam_record_desc"));
                examRecord.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                //设置考试对象e
                Exam e = new Exam();
                e.setId(rs.getInt("prefix_e_id"));
                e.setExamName(rs.getString("prefix_e_exam_name"));
                e.setExamDesc(rs.getString("prefix_e_exam_desc"));
                examRecord.setExam(e);
                //设置班级对象
                Classes classes = new Classes();
                classes.setId(rs.getInt("prefix_c1_id"));
                classes.setClassesName(rs.getString("prefix_c1_classes_name"));
                examRecord.setClasses(classes);
                //设置课程对象
                Course course = new Course();
                course.setId(rs.getInt("prefix_c2_id"));
                course.setCourseName(rs.getString("prefix_c2_course_name"));
                examRecord.setCourse(course);
                //设置学生对象
                Student student = new Student();
                student.setId(rs.getInt("prefix_s_id"));
                student.setStudentName(rs.getString("prefix_s_student_name"));
                student.setStudentNo(rs.getString("prefix_s_student_no"));
                student.setIdCard(rs.getString("prefix_s_id_cord"));
                student.setStudentEmail(rs.getString("prefix_s_student_email"));
                examRecord.setStudent(student);
                records.add(examRecord);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询考试成绩列表出错",e);
        }
        return records;
    }

    public static ExamRecord queryById(Integer id) {
        ExamRecord examRecord = new ExamRecord();

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql =
                    "select distinct" +
                            "  er.id," +
                            "  er.create_time," +
                            "  er.exam_record_desc," +
                            "  er.score," +
                            "  e.id            prefix_e_id," +
                            "  e.exam_name     prefix_e_exam_name," +
                            "  e.exam_desc     prefix_e_exam_desc," +
                            "  c1.id            prefix_c1_id," +
                            "  c1.classes_name  prefix_c1_classes_name," +
                            "  c2.id           prefix_c2_id," +
                            "  c2.course_name  prefix_c2_course_name," +
                            "  s.id            prefix_s_id," +
                            "  s.student_name  prefix_s_student_name," +
                            "  s.student_no    prefix_s_student_no," +
                            "  s.id_card       prefix_s_id_cord," +
                            "  s.student_email prefix_s_student_email" +
                            "  from stu_exam.exam_record er" +
                            "  join stu_exam.exam e on er.exam_id = e.id" +
                            "  join stu_exam.student s on s.id = er.student_id"+
                            "  join stu_exam.classes c1 on c1.id = s.classes_id" +
                            "  join stu_exam.course c2 on e.course_id = c2.id" +
                            "   where er.id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                // 设置考试成绩对象
                examRecord.setId(rs.getInt("id"));
                examRecord.setScore(rs.getBigDecimal("score"));
                examRecord.setExamRecordDesc(rs.getString("exam_record_desc"));
                examRecord.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                //设置考试对象e
                Exam e = new Exam();
                e.setId(rs.getInt("prefix_e_id"));
                e.setExamName(rs.getString("prefix_e_exam_name"));
                e.setExamDesc(rs.getString("prefix_e_exam_desc"));
                examRecord.setExam(e);
                //设置班级对象
                Classes classes = new Classes();
                classes.setId(rs.getInt("prefix_c1_id"));
                classes.setClassesName(rs.getString("prefix_c1_classes_name"));
                examRecord.setClasses(classes);
                //设置课程对象
                Course course = new Course();
                course.setId(rs.getInt("prefix_c2_id"));
                course.setCourseName(rs.getString("prefix_c2_course_name"));
                examRecord.setCourse(course);
                //设置学生对象
                Student student = new Student();
                student.setId(rs.getInt("prefix_s_id"));
                student.setStudentName(rs.getString("prefix_s_student_name"));
                student.setStudentNo(rs.getString("prefix_s_student_no"));
                student.setIdCard(rs.getString("prefix_s_id_cord"));
                student.setStudentEmail(rs.getString("prefix_s_student_email"));
                examRecord.setStudent(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询考试成绩详情出错",e);
        }
        return examRecord;
    }

    public static int insert(ExamRecord record) {

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql = "insert stu_exam.exam_record(exam_id,student_id,score) values (?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setInt(1,record.getExamId());
            ps.setInt(2,record.getStudentId());
            ps.setBigDecimal(3,record.getScore());
            return ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("插入考试成绩出错",e);
        }
    }

    public static int update(ExamRecord record) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql = "update stu_exam.exam_record set exam_id = ?,student_id = ?,score = ? " +
                    "     where id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,record.getExamId());
            ps.setInt(2,record.getStudentId());
            ps.setBigDecimal(3,record.getScore());
            ps.setInt(4,record.getId());
            return ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("修改考试成绩出错",e);
        }
    }

    public static int delete(String[] ids) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from stu_exam.exam_record where id in (");
            for(int i = 0; i<ids.length; i++) {
                if(i != 0) {
                    sql.append(",");
                }
                sql.append("?");

            }
            sql.append(");");
            ps = c.prepareStatement(sql.toString());
            for(int i = 0; i < ids.length; i++) {
                ps.setInt(i + 1,Integer.parseInt(ids[i]));
            }
            return ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("删除考试成绩出错",e);
        }
    }
}
