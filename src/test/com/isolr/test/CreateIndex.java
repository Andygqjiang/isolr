package com.isolr.test;

import com.alibaba.fastjson.JSON;
import com.isolr.service.SolrIndexManager;
import javacommon.util.SolrConstant;
import javacommon.util.Paginator;
import javacommon.util.SpringContextUtil;
import org.apache.solr.common.SolrDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Andy
 * @since 2016/8/24 0024.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-*.xml"})
public class CreateIndex {

    private static Logger log = LoggerFactory.getLogger(CreateIndex.class);

    @Test
    public void testCreateIndexHoliday() {
        try {
            SolrIndexManager solrIndexManager = SpringContextUtil.getBean("solrIndexManager");
            log.debug("========= 请假 ==============");
            //请假
            solrIndexManager.createWorkIndex(SolrConstant.HOLIDAY);
            log.debug("========= 公司通知 ==============");
            //公司通知
            solrIndexManager.createWorkIndex(SolrConstant.ANN);
            log.debug("========= 我的任务 ==============");
            //我的任务
            solrIndexManager.createWorkIndex(SolrConstant.ORDER);
            log.debug("========= 日志 ==============");
            //日志
            solrIndexManager.createWorkIndex(SolrConstant.REPORT);
            log.debug("========= 事务申请 ==============");
            //事务申请
            solrIndexManager.createWorkIndex(SolrConstant.AFFAIRS_REPORT);
            log.debug("========= 费用申请 ==============");
            //费用申请
            solrIndexManager.createWorkIndex(SolrConstant.COST);
            log.debug("========= 差旅申请 ==============");
            //差旅申请
            solrIndexManager.createWorkIndex(SolrConstant.TRAVEL);
            log.debug("========= 研发立项 ==============");
            //研发立项
            solrIndexManager.createWorkIndex(SolrConstant.YF_LX);
            log.debug("========= 研发进度一 ==============");
            //研发进度一
            solrIndexManager.createWorkIndex(SolrConstant.YF_JD_ONE);
            log.debug("========= 研发进度二 ==============");
            //研发进度二
            solrIndexManager.createWorkIndex(SolrConstant.YF_JD_TWO);
            log.debug("========= 研发进度三 ==============");
            //研发进度三
            solrIndexManager.createWorkIndex(SolrConstant.YF_JD_THREE);
            log.debug("========= 研发验收 ==============");
            //研发验收
            solrIndexManager.createWorkIndex(SolrConstant.YF_YS);
            log.debug("========= 我的客户 ==============");
            //我的客户
            solrIndexManager.createWorkIndex(SolrConstant.MY_CUS);
            log.debug("========= 客户关怀 ==============");
            //客户关怀
            solrIndexManager.createWorkIndex(SolrConstant.CUS_CARE);
            log.debug("========= 考勤 ==============");
            //考勤
            solrIndexManager.createWorkIndex(SolrConstant.ATTENDANCE);
            log.debug("========= 外勤 ==============");
            //外勤
            solrIndexManager.createWorkIndex(SolrConstant.TRACK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByQuery() {
        try {
            SolrIndexManager solrIndexManager = SpringContextUtil.getBean("solrIndexManager");
            solrIndexManager.deleteWorkByQuery("*:*");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindHoliday() {
        try {
            SolrIndexManager solrIndexManager = SpringContextUtil.getBean("solrIndexManager");
            Paginator<SolrDocument> solrPage = solrIndexManager.findWorkSolrPage(1);
            log.debug("==="+ JSON.toJSONString(solrPage.getDataList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @Test
    public void testEnum () {
   }
}
