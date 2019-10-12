import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class RandomNumsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random r = new Random();
        String num = Integer.toString(r.nextInt(100));

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(num);
    }
}
