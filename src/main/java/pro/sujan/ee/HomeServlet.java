package pro.sujan.ee;

import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pro.sujan.ee.database.entity.UserEntity;
import pro.sujan.ee.database.service.UserService;
import pro.sujan.ee.response.ResponseSender;
import pro.sujan.ee.security.utils.TextSanitizer;

import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Inject
    private UserService userService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        ResponseSender.sendPage(request, response, "home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        TextSanitizer.checkForNonSanitaryParameters(request, List.of("username", "password"));
        userService.save(newUser(request.getParameter("username"), request.getParameter("password")));
        doGet(request, response);
    }

    private UserEntity newUser(String username, String password){
        UserEntity user = new UserEntity();
        user.setName(username);
        user.setPassword(password);
        return user;
    }
}