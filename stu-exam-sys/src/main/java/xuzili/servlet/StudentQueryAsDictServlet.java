package xuzili.servlet;

import xuzili.dao.StudentDao;
import xuzili.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取班级id
        String id = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = StudentDao.queryAsDict(Integer.parseInt(id));
        return tags;
    }
}
