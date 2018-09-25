package com.github.zywaiting.httputiltest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.output.StringBuilderWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created on 2018-09-25.<br/>
 *
 * @author zy
 * @since 1.0
 */
public abstract class Utils {
    private final static Logger logger = LoggerFactory.getLogger(Utils.class);
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * json转Object
     *
     * @param content
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T json(String content, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(content, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("json格式错误.\n{}", content, e);
            throw HttpException.INSTANCE;
        }
    }

    public static Map<String, Object> StringToMap(String content) {
        Map<String, Object> map = new HashMap<>();
        String[] str = content.split("&");
        if (str != null && str.length > 0) {
            for (String s : str) {
                String[] tem = s.split("=");
                if (tem != null && tem.length > 1) {
                    map.put("" + tem[0], tem[1]);
                } else if (tem != null && tem.length == 1) {
                    map.put("" + tem[0], null);
                }
            }
        }
        return map;
    }

    public static String json(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json对象格式错误.\n{}", obj, e);
            throw HttpException.INSTANCE;
        }
    }

    public static <T> T xml(String content, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(new StringReader(content));
        } catch (Exception e) {
            logger.error("xml格式错误.\n{}", content, e);
            throw HttpException.INSTANCE;
        }
    }

    public static String xml(Object obj, Class clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringBuilderWriter builderWriter = new StringBuilderWriter();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(obj, builderWriter);
            return builderWriter.toString();
        } catch (Exception e) {
            logger.error("xml对象格式错误.\n{}", obj, e);
            throw HttpException.INSTANCE;
        }
    }

    public static String ip(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || Objects.equals(ip, "unknown"))
            ip = request.getHeader("Proxy-Client-IP");
        if (StringUtils.isEmpty(ip) || Objects.equals(ip, "unknown"))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (StringUtils.isEmpty(ip) || Objects.equals(ip, "unknown"))
            ip = request.getRemoteAddr();
        return ip.split(",")[0];
    }

    public static String getSuffix(String source) {
        int i = source.lastIndexOf(".");
        if (i > 0) {
            return source.substring(i + 1);
        }
        return null;
    }

    public static String getHash(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
