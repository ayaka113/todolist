import bean.Task;
import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
	{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{

			req.setCharacterEncoding("utf-8");
			HttpSession session = req.getSession();
			ArrayList<Task> todolists = (ArrayList<Task>) session.getAttribute("todolist");

			String[] deleteIndexes = req.getParameterValues("deleteIndex");
			if (deleteIndexes != null && todolists != null)
				{
				List<Integer> indexes = new ArrayList<>();
				for (String idxStr : deleteIndexes)
				{
					indexes.add(Integer.parseInt(idxStr));
				}
				Collections.sort(indexes, Collections.reverseOrder());
				for (int idx : indexes)
				{
					if (idx >= 0 && idx < todolists.size())
					{
						todolists.remove(idx);
					}
				}
			}
			session.setAttribute("todolist", todolists);
			req.getRequestDispatcher("/simpleTodo.jsp").forward(req,res);
		}
		public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);
	}
}
