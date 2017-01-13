package javacommon.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;


/**
 * @version 1.0
 * @date 2016年4月12日 上午10:26:55
 * @description GZIP压缩工具类
 */
public class GZIPCompress {

    private static Logger log = LoggerFactory.getLogger(GZIPCompress.class);

    public static void data(JSONObject data, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("status", HttpStatusCode.SUCCESS.value());
        result.put("data", data);
        WriteToString(result, response);
    }

    public static void success(HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("status", HttpStatusCode.SUCCESS.value());
        result.put("msg", HttpStatusCode.SUCCESS.getMsg());
        WriteToString(result, response);
    }

    public static void fail(HttpStatusCode httpStatusCode, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("status", httpStatusCode.value());
        result.put("msg", httpStatusCode.getMsg());
        WriteToString(result, response);
    }

    public static void pages(Paginator page, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("status", HttpStatusCode.SUCCESS.value());
        result.put("total", page.getTotal());
        result.put("page", page.getCurrentPage());
        result.put("data", page.getDataList());
        WriteToString(result, response);
    }

    public static void WriteToString(JSONObject result, HttpServletResponse response) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            String str = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
            /** 对应响应的文本进行GZIP压缩 */
            gzip.write(str.getBytes("utf-8"));
            gzip.finish();
            /** 告诉浏览器响应文本的编码 */
            response.setHeader("Content-Encoding", "GZIP");
            response.setContentType("application/json; charset=UTF-8");
            /** 输出 */
            response.getOutputStream().write(bos.toByteArray());
        } catch (Exception e) {
            log.error("GZIP compress error", e);
        }
    }
}
