package javacommon.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName SpringContextUtil
 * @Description spring 获取bean工具类
 * @author Andy
 * @date 2014年10月20日下午4:35:53
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext context = null;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}

	public synchronized static <T> T getBean(String beanName) {
		return (T)context.getBean(beanName);
	}

}
