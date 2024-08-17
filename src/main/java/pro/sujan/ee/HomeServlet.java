package pro.sujan.ee;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pro.sujan.ee.response.ResponseSender;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        ResponseSender.sendPage(request, response, "home.jsp");
    }
}