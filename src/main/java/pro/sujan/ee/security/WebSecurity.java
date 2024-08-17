package pro.sujan.ee.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import pro.sujan.ee.http.HttpHeader;
import pro.sujan.ee.http.headers.IFrameOptions;
import pro.sujan.ee.http.headers.XFrameOptions;

import java.util.Objects;

public class WebSecurity {
    /**
     * This method must be invoked after final response has been generated
     * @param response
     */
    public static void removeDefaults(HttpServletResponse response){
        response.setHeader("X-Powered-By", "Web");
    }
    public static void blockIframe(HttpServletResponse response){
        response.addHeader(HttpHeader.CONTENT_SECURITY_POLICY, IFrameOptions.SELF_ANCESTOR);
        response.addHeader(HttpHeader.X_FRAME_OPTIONS, XFrameOptions.SAME_ORIGIN);
    }

    public static void blockInlineJavaScript(HttpServletResponse response){
        response.addHeader(HttpHeader.CONTENT_SECURITY_POLICY, "script-src 'self'");
    }

    public static void blockFlashAndApplets(HttpServletResponse response){
        response.addHeader(HttpHeader.CONTENT_SECURITY_POLICY, "object-src 'self'");
    }

    public static void accessCssAndImageFromOriginOnly(HttpServletResponse response){
        response.addHeader(HttpHeader.CONTENT_SECURITY_POLICY, "style-src 'self'; img-src 'self' data");
    }
}
