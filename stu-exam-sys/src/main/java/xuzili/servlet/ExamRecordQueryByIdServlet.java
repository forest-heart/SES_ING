package xuzili.servlet;

import xuzili.dao.ExamRecordDao;
import xuzili.model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/queryById")
public class ExamRecordQueryByIdServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
       ExamRecord record = ExamRecordDao.queryById(Integer.valueOf(id));
        return record;
    }
}
