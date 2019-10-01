import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("name");
        pw.println("<html><body>Hello, " + name + "</body</html>");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        BufferedReader reader = request.getReader();
        printWriter.println("<html><body><pre>" + reader.readLine() + "</pre></body</html>");
        printWriter.close();
    }
}
