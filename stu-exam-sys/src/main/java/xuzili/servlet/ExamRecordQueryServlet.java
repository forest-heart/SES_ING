package xuzili.servlet;

//考试成绩查询的一个servlet

import xuzili.dao.ExamRecordDao;
import xuzili.model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/examRecord/query")
public class ExamRecordQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<ExamRecord> records =  ExamRecordDao.query();
        return records;
    }
}
