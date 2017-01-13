package javacommon.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sys.manager.model.LoginUser;
import javacommon.util.HttpStatusCode;
import javacommon.util.GZIPCompress;
import javacommon.util.MD5Util;
import javacommon.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Andy
 * @since 2016/8/31 0031.
 */
public class SpringInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    private static Logger log = LoggerFactory.getLogger(SpringInterceptor.class);

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        JSONObject result = new JSONObject();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            result.put("status", HttpStatusCode.VALIDATOR_ERROR.value());
            result.put("msg", HttpStatusCode.VALIDATOR_ERROR.getMsg());
            GZIPCompress.WriteToString(result, response);
        }
        else {
            RedisTemplate redisTemplate = SpringContextUtil.getBean("redisTemplate");
            int hashToken = MD5Util.FNVHash1(token);
            LoginUser user = (LoginUser) redisTemplate.opsForValue().get(String.valueOf(hashToken));
            if (user == null) {
                result.put("msg", HttpStatusCode.LOGIN_OVER_ERROR.getMsg());
                result.put("status", HttpStatusCode.LOGIN_OVER_ERROR.value());
                GZIPCompress.WriteToString(result, response);
            } else {
                request.setAttribute("loginUser", user);
                return super.preHandle(request, response, handler);
            }
        }
        return false;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            GZIPCompress.fail(HttpStatusCode.INTERNAL_SERVER_ERROR, response);
            log.error("search error", ex);
        }
    }
}
