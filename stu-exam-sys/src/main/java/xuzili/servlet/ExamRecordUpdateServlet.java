package xuzili.servlet;

import xuzili.dao.ExamRecordDao;
import xuzili.model.ExamRecord;
import xuzili.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/update")
public class ExamRecordUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ExamRecord record = JSONUtil.read(req.getInputStream(),ExamRecord.class);
        int num = ExamRecordDao.update(record);
        return null;
    }
}
