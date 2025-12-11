import bean.Task;
import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet
	{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{

			int i;

			res.setContentType("text/html; charset=UTF-8");
			String checkboxValue = req.getParameter("agree");

			// セッションオブジェクトの生成or取得
			HttpSession session = req.getSession(true);
			// セッションオブジェクトからtodolistを取得
			ArrayList<Task> todolist = (ArrayList<Task>)session.getAttribute("todolist");

			// チェックされた項目にチェックをつける
			String checking = req.getParameter("checking");
			String checked = req.getParameter("checkedIndex");
			if (checked != null)
			{
				int index = Integer.parseInt(checking);
				// index番目の項目がチェックされていた
				todolist.get(index).setcheck(true);
				System.out.println("Checked position: " + index);
			} else {
			// nullの時。チェックが外れた時の処理
			System.out.println("No checkboxes selected.");
			int index = Integer.parseInt(checking);
				todolist.get(index).setcheck(false);
			}

		session.setAttribute("todolist", todolist);		//ArrayList<String>をjspで使用するため
		req.getRequestDispatcher("/simpleTodo.jsp").forward(req,res);
    	}
		public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException
		{
		doGet(req, res);
		}
}
