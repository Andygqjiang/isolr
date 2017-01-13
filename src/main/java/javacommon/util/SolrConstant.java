package javacommon.util;

/**
 * 类描述:
 *
 * @author Andy
 */
public enum SolrConstant {

	AFFAIRS_REPORT("事务申请", 1, "AffairsReportMapper"), // 事务申请
	ANN("公司通知", 2, "AnnMapper"), // 公司通知
//	CAR("员工用车", 3), // 员工用车
	COST("费用申请", 4, "CostMapper"), // 费用申请
//	DEPT_ANN("部门通知", 5), // 部门通知
//	GOODS_BORROW("物品借用", 6), // 物品借用
	HOLIDAY("请假", 7, "HolidayMapper"), // 员工请假
	ORDER("我的任务", 8, "OrderMapper"), // 我的任务
//	OVERTIME("加班申请", 9), // 加班申请
	REPORT("日志", 10, "ReportMapper"), // 工作日志
	TRAVEL("差旅申请", 12, "TravelMapper"), // 差旅申请
//	SALE_ORDER("销售订单", 13), // 销售-销售订单
//	CUS_VISIT("客户拜访", 14), // 销售-客户拜访
//	CUS_SUPPORT("客户支持", 15), // 销售-客户支持
	CUS_CARE("客户关怀", 16, "CusCareMapper"), // 销售-客户关怀
//	CUS_CHANCE("客户机会", 17), // 销售-客户机会
//	CUS_CONTRACT("客户合同", 18), // 销售-客户合同
//	RETURN_GOODS("退货管理", 19), // 销售-退货管理
	MY_CUS("我的客户", 20, "MycusMapper"), // 销售-我的客户
//	TDS_CUS_VISIT("客户拜访", 21), // 电商客户拜访
//	TDS_CUS_SUPPORT("客户支持", 22), // 电商客户支持
//	TDS_CUS_CARE("客户关怀", 23), // 电商客户关怀
//	TDS_ORDER("销售订单", 24), // 电商销售订单
//	TDS_CUS_CHANCE("销售机会", 25), // 电商销售机会
//	PERFORMANCE("业绩管理", 26), // 业绩管理
//	TDS_RETURN_GOODS("退货管理", 27), // 电商退货管理
//	CG_ORDER("采购入库", 28), // 采购订单 采购入库
//	CG_MYCUS("我的客户", 29), // 采购我的客户
//	DS_MYCUS("我的客户", 30), // 电商我的客户
//	CG_CUSJW("客户交往", 31), // 采购客户交往
//	CG_CONTRACT("采购合同", 32), // 采购合同
//	CG_RETURN_GOODS("采购出库", 33), // 采购退货管理 采购出库
//	MK_HYDT("行业动态", 34), // 行业动态
//	MK_JZBG("竞争报告", 35), // 竞争报告
//	MK_SCDC("市场调查", 36), // 市场调查
//	MK_PR("PR业务", 37), // PR业务
//	MK_GGYW("广告业务", 38), // 广告业务
//	MK_HDYW("活动业务", 39), // 活动业务
//	MK_JJTG("竞价推广", 40), // 竞价推广
//	MK_KBTG("口碑推广", 41), // 口碑推广
//	MK_WMTG("网盟推广", 42), // 网盟推广
//	CW_REPORT("财务简报", 43), // 财务简报
//	CW_SY_REPORT("损益简报", 44), // 损益简报
//	CW_COST_REPORT("费用简报", 45), // 费用简报
//	CW_GSS_REPORT("工资/社保/税金简报", 46), // 工资/社保/税金简报
//	CW_RMB_REPORT("资金报告", 47), // 资金报告(人民币)
//	CW_WB_REPORT("资金报告", 48), // 资金报告(外币)
//	CW_XJLL_REPORT("资金流量", 49), // 资金流量表
	YF_JD_ONE("研发进度", 50, "YfjdOneMapper"), // 研发进度一
	YF_JD_TWO("研发进度", 51, "YfjdTwoMapper"), // 研发进度二
	YF_JD_THREE("研发进度", 52, "YfjdThreeMapper"), // 研发进度三
	YF_LX("研发立项", 53, "YflxMapper"), // 研发立项
	YF_YS("研发验收", 54, "YfysMapper"), // 研发验收
//	CK_MY_CUS("我的客户", 55), // 仓库-我的客户
//	CK_CUS_VISIT("客户拜访", 56), // 仓库-客户拜访
//	CK_CUS_SUPPORT("客户支持", 57), // 仓库-客户支持
//	CW_CUS_VISIT("客户拜访", 58), // 财务-客户拜访
//	CW_CUS_SUPPORT("客户支持", 59), // 财务-客户支持
//	CW_CUS_CARE("客户关怀", 60), // 财务-客户关怀
//	CK_OUT_STORE_APPLY("出库申请", 61), // 仓库-出库申请
//	CK_IN_STORE_APPLY("入库申请", 62), // 仓库-入库申请
//	MK_CUS_VISIT("客户拜访", 63), // 市场-客户拜访
//	MK_CUS_SUPPORT("客户支持", 64), // 市场-客户支持
//	MK_CUS_CARE("客户关怀", 65), // 市场-客户关怀
//	CK_CUS_CARE("客户关怀", 66), // 仓库-客户关怀
	ATTENDANCE("考勤", 67, "AttendanceMapper"), // 考勤
//	CG_CUS_VISIT("客户拜访", 68), // 采购-客户拜访
//	CG_CUS_SUPPORT("客户支持", 69), // 采购-客户支持
//	CG_CUS_CARE("客户关怀", 70), // 采购-客户关怀
//	XZ_GSZZ("公司证照", 71), // 行政-公司证照
//	XZ_ORDER("文具采购", 72), // 行政-文具采购
//	XZ_YZSY("印章使用", 73), // 行政-印章使用
//	XZ_JBHZ("加班汇总", 74), // 行政-加班汇总
//	XZ_KQHZ("考勤汇总", 75), // 行政-考勤汇总
//	XZ_QJHZ("请假汇总", 76), // 行政-请假汇总
//	DS_PERFORMANCE("业绩管理", 77), // 电商业绩管理
//	YF_CUS_VISIT("客户拜访", 78), // 研发-客户拜访
//	YF_CUS_SUPPORT("客户支持", 79), // 研发-客户支持
//	YF_CUS_CARE("客户关怀", 80), // 研发-客户关怀
//	CW_MYCUS("我的客户", 81), // 财务-我的客户
//	MK_MYCUS("我的客户", 82), // 市场-我的客户
//	YF_MYCUS("我的客户", 83), // 研发-我的客户
//	XZ_LZSQ("离职申请", 84), // 行政-离职申请
//	XZ_RLZK("人力状况", 85), // 行政-人力状况
//	XZ_RZSQ("入职申请", 86), // 行政-入职申请
//	XZ_XJTZ("薪金调整", 87), // 行政-薪金调整
//	XZ_RSZP("人事招聘", 88), // 行政-人事招聘
//	XZ_ZPGG("招聘广告", 89), // 行政-招聘广告
//	XZ_MYCUS("我的客户", 90), // 行政-我的客户
//	XZ_CUS_SUPPORT("客户支持", 91), // 行政-客户支持
//	XZ_CUS_CARE("客户关怀", 92), // 行政-客户关怀
//	XZ_CUS_VISIT("客户拜访", 93), // 行政-客户拜访
//	XZ_GZYD("工作异动", 94), // 行政-工作异动
//	SC_CUS_SUPPORT("客户支持", 95), // 生产-客户支持
//	SC_CUS_CARE("客户关怀", 96), // 生产-客户关怀
//	SC_CUS_VISIT("客户拜访", 97), // 生产-客户拜访
//	SC_MYCUS("我的客户", 98), // 生产-我的客户
//	SC_JGSQ("加工申请", 99), // 生产-加工申请
//	SC_LLSQ("领料申请", 100), // 生产-领料申请
//	SC_YSSQ("验收申请", 101), // 生产-验收申请
//	SC_NJH("年计划", 102), // 生产-年计划
//	SC_YJH("月计划", 103), // 生产-月计划
//	SC_ZJH("周计划", 104), // 生产-周计划
//	SC_WLQD_ONE("一级物料", 105), // 一级物料
//	SC_WLQD_TWO("二级物料", 106), // 二级物料
//	SC_WLQD_THREE("三级物料", 107), // 三级物料
//	SC_WLQD_FOUR("四级物料", 108), // 四级物料
//	SC_WLQD_FIVE("五级物料", 109), // 五级物料
//	PRODUCTS_TYPE("货品类型", 110), // 货品类型
//	PRODUCTS_BRANDS("货品品牌", 111), // 货品品牌
//	PRODUCTS("货品资料", 112), // 货品资料
//	CUS_TYPE("客户类型", 113), // 客户类型
//	CUS_LEVEL("客户级别", 114),// 客户级别
//	SYS_USER_CUS("外部客户", 115), //外部客户
	TRACK("外勤轨迹", 116, "TrackMapper"); //外勤轨迹
//	CONTACT("通讯录", 117);//通讯录

	private int value;

	private String name;

	private String mapper;

	SolrConstant(String name, int value, String mapper) {
		this.name = name;
		this.value = value;
		this.mapper = mapper;
	}

	public int value() {
		return this.value;
	}

	public String getName(){
		return this.name;
	}

	public String getMapper() {
		return this.mapper;
	}

	public static SolrConstant getApiConstant(int value) {
		SolrConstant[] values = SolrConstant.values();
		for (SolrConstant solrConstant : values) {
			if (value == solrConstant.value()) {
				return solrConstant;
			}
		}
		return null;
	}
}
