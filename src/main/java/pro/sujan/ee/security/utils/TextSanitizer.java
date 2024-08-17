package pro.sujan.ee.security.utils;

import jakarta.servlet.http.HttpServletRequest;
import pro.sujan.ee.security.exception.TextSanitaryException;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class TextSanitizer {
    private TextSanitizer(){}
    public static void checkForNonSanitaryParameters(HttpServletRequest request, List<String> parameters){
        for(String parameter: parameters){
            String requestParameter = request.getParameter(parameter);
            if(Objects.isNull(requestParameter))
                throw new TextSanitaryException("Missing value: "+parameter);
            checkForValidText(requestParameter);
        }
    }

    private static void checkForValidText(String parameter){
        if(!Pattern.matches("[A-Za-z0-9\\\\-]+", parameter))
            throw new TextSanitaryException("Only A-Z, a-z and - are allowed!");
    }
}
