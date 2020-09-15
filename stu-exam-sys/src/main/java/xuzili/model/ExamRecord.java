package xuzili.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class ExamRecord {
    private Integer id;
    private BigDecimal score;
    private Integer studentId;
    private Integer examId;
    private String examRecordDesc;
    private Date createTime;  // java.util.Date

    private Exam exam;
    private Classes classes;
    private Course course;
    private Student student;
}
