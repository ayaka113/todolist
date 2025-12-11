<%@page contentType = "text/html;charset=utf-8" %>
<%@page import = "bean.Task" %>
<%@page import = "java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id ="todolist" class="java.util.ArrayList" scope="session" />

<html>
	<head>
		<title>Todoリスト</title>
	</head>
<body>
	<p>Todoリスト</p>

	<form action="simpletodo" method="post">
	<input type="text" size="30" name="todo"/><input type="submit" value="追加" style="WIDTH: 60px; HEIGHT: 25px"></p>
	<br />
	</form>
	<h2>やること</h2>
	<%
		ArrayList<Task> todolists = (ArrayList<Task>) session.getAttribute("todolist");
		for (int i = 0; i < todolists.size(); i++) {
			Task task = todolists.get(i);

			// チェックボックス用フォーム
			out.println("<form action=\"CheckboxServlet\" method=\"get\" style=\"display:inline;\">");
			out.println("<input type=\"hidden\" name=\"checking\" value=\"" + i + "\" />");
			out.println("<input type=\"checkbox\" name=\"checkedIndex\" value=\"" + i + "\"");

			if (task.getcheck()) {
				out.println(" checked");
			}

			out.println(" onchange=\"this.form.submit()\" />");

			if (task.getcheck()) {
				out.println("<s>" + task.getName() + "</s>");
			} else {
				out.println(task.getName());
			}

			out.println("</form>");

			// 削除ボタン用フォーム
			out.println("<form action=\"DeleteServlet\" method=\"get\" style=\"display:inline;\">");
			out.println("<input type=\"hidden\" name=\"deleteIndex\" value=\"" + i + "\" />");
			out.println("<input type=\"image\" name=\"delete\" src=\"images/icons8gomibako30.png\" alt=\"削除\" width=\"20\" height=\"20\" />");
			out.println("</form>");

			// 改行
			out.println("<br/>");
		}
	%>
</body>
</html>
