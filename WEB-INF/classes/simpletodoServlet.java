import bean.Task;
import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/simpletodo")
public class simpletodoServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{

		// レスポンスのコンテンツタイプと文字エンコーディングを設定
		res.setContentType("text/html; charset=UTF-8");

		// セッションオブジェクトの生成or取得
		HttpSession session = req.getSession(true);
		// セッションオブジェクトからtodolistを取得
		ArrayList<Task> todolist = (ArrayList<Task>)session.getAttribute("todolist");

		if(todolist == null)
			{
			todolist = new ArrayList<Task>();  // 初回アクセス
			req.setCharacterEncoding("utf-8");
			String todo = req.getParameter("todo");
			todolist.add(new Task(todo,false));
			} else {
			req.setCharacterEncoding("utf-8");   // ２回目以降
			String todo = req.getParameter("todo");
			todolist.add(new Task(todo,false));
			}

		session.setAttribute("todolist", todolist);		//ArrayList<String>をjspで使用するため
		req.getRequestDispatcher("/simpleTodo.jsp").forward(req,res);

		}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
	doPost(req, res);
	}
}
