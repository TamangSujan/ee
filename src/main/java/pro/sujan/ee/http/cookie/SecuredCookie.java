package pro.sujan.ee.http.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecuredCookie {
    private final StringBuilder cookieBuffer;
    private SecuredCookie(String name, String value){
        cookieBuffer = new StringBuilder(getInitialCookieValue(name, value));
    }

    public static SecuredCookie newCookie(String name, String value){
        return new SecuredCookie(name, value);
    }

    public SecuredCookie setCurrentPath(HttpServletRequest request){
        cookieBuffer.append("Path=").append(request.getServletPath()).append(";");
        return this;
    }

    public SecuredCookie setPath(String path){
        cookieBuffer.append("Path=").append(path).append(";");
        return this;
    }

    public SecuredCookie addExpiryMinutes(int minutes){
        cookieBuffer.append("Max-Age=").append(Math.max(0, minutes) * 60).append(";");
        return this;
    }

    public void addCookieToResponse(HttpServletResponse response){
        response.addHeader("Set-Cookie", cookieBuffer.toString());
    }

    private String getInitialCookieValue(String name, String value){
        return name + "=" + value + ";" +
                "HttpOnly; Secured; SameSite=STRICT;";
    }
}
