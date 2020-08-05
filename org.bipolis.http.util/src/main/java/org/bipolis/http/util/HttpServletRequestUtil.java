package org.bipolis.http.util;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;


public class HttpServletRequestUtil {

    public static Map<Object, String[]> getMapFromRequest(HttpServletRequest request) {
        return Collections.list(request.getParameterNames()).stream()
            .collect(Collectors.toMap(parameterName -> parameterName, request::getParameterValues));
    }
}
