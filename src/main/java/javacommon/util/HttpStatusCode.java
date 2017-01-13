package javacommon.util;

/**
 * Created by Andy
 */
public enum HttpStatusCode {

	SUCCESS(200, "success"), // 成功
	INTERNAL_SERVER_ERROR(500, "server error"), // 服务器错误
	NOT_EXIST_ERROR(501, "record do not exist"), // 记录不存在
//	EXIST_ERROR(502), // 已存在记录
//	LOGIN_ERROR(503), // 登陆错误
	VALIDATOR_ERROR(504, "param is not valid"), // 参数不合法
//	TIME_OUT_ERROR(505), // 参数超时
//	BUSYNESS_ERROR(506), // 请求过于频繁
//	IM_SERVER_ERROR(507), // IM服务器错误
//	NOT_MATCH_ERROR(508),// 数据不匹配
	LOGIN_OVER_ERROR(509, "login time out");//登录超时

	private int value;

	private String msg;

	HttpStatusCode(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public int value() {
		return this.value;
	}

	public String getMsg() {
		return msg;
	}
}
