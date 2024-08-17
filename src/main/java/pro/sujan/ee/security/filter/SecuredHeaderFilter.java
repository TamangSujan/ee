package pro.sujan.ee.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import pro.sujan.ee.security.WebSecurity;

import java.io.IOException;

@WebFilter("/*")
public class SecuredHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        initializeWebResponseSecurity((HttpServletResponse) response);
        filterChain.doFilter(request, response);
    }

    void initializeWebResponseSecurity(HttpServletResponse response){
        WebSecurity.blockIframe(response);
        WebSecurity.blockInlineJavaScript(response);
        WebSecurity.blockFlashAndApplets(response);
        WebSecurity.accessCssAndImageFromOriginOnly(response);
        WebSecurity.removeDefaults(response);
    }
}
