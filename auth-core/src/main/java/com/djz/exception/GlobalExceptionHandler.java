package com.djz.exception;

import cn.hutool.json.JSONUtil;
import com.djz.response.ResultBean;
import com.djz.response.ResultHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.UUID;


@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String APPLICATION_JSON = "application/json";

    public GlobalExceptionHandler() {
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        try {
            String errorLogId = UUID.randomUUID() + "";
            String message;
            int code;

            if (e instanceof DuplicateKeyException) {
                code = 501;
                message = "请勿频繁操作";
                logger.error("status code: " + code + "，重复错误：", e);
            } else if (e instanceof BusinessException) {
                code = ((BusinessException)e).getErrCode();
                if (StringUtils.isNotEmpty(e.getMessage())) {
                    message = e.getMessage();
                    logger.error("status code: " + code + "，业务错误：{}", e.getMessage());
                } else {
                    message = e.getMessage();
                    logger.error("status code: " + code + "，业务错误：", e);
                }
            } else {
                code = HttpStatus.INTERNAL_SERVER_ERROR.value();
                message = "服务器出现错误，错误编号：" + errorLogId;
                if (StringUtils.isNotEmpty(e.getMessage())) {
                    message = e.getMessage();
                    logger.error("status code: 500，编号：" + errorLogId + "，未知错误：", e);
                } else {
                    logger.error("status code: 500，编号：" + errorLogId + "，未知错误：", e);
                }
            }

            ResultBean jsonResponse = ResultHandler.resultBean(code, message);

            response.setHeader("Content-Encoding", "identity");
            response.setHeader("Content-Type", APPLICATION_JSON);
            OutputStream out = response.getOutputStream();
            out.write(JSONUtil.toJsonStr(jsonResponse).getBytes(StandardCharsets.UTF_8));
            response.flushBuffer();
        } catch (IOException var13) {
            logger.error("全局错误：", var13);
        }

        return new ModelAndView();
    }



    public static String getIP(HttpServletRequest request) {
        Assert.notNull(request, "HttpServletRequest is null");
        String ip = request.getHeader("X-Requested-For");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return StringUtils.isBlank(ip) ? null : ip.split(",")[0];
    }

    private byte[] getRequestBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        } else {
            byte[] buffer = new byte[contentLength];

            int readlen;
            for(int i = 0; i < contentLength; i += readlen) {
                readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }
            }

            return buffer;
        }
    }

    private String getRequestStr(HttpServletRequest request, byte[] buffer) throws IOException {
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }

        String str = (new String(buffer, charEncoding)).trim();
        if (StringUtils.isBlank(str)) {
            StringBuilder sb = new StringBuilder();
            Enumeration parameterNames = request.getParameterNames();

            while(parameterNames.hasMoreElements()) {
                String key = (String)parameterNames.nextElement();
                String value = request.getParameter(key);
                sb.append(key).append("=").append(value).append("&");
            }

            str = StringUtils.removeEnd(sb.toString(), "&");
        }

        return str.replaceAll("&amp;", "&");
    }
}
