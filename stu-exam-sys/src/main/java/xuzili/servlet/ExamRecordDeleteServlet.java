package xuzili.servlet;

import xuzili.dao.ExamRecordDao;
import xuzili.model.Exam;
import xuzili.model.ExamRecord;
import xuzili.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/delete")
public class ExamRecordDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String [] ids= req.getParameterValues("ids");
        int num = ExamRecordDao.delete(ids);
        return null;
    }
}
