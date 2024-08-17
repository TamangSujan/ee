package pro.sujan.ee.url;

import jakarta.servlet.http.HttpServletRequest;

public class PathHandler {
    public static String getServletPath(HttpServletRequest request, String servletUrl){
        return request.getContextPath()+servletUrl;
    }
}
