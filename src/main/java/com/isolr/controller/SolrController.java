package com.isolr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sys.manager.model.LoginUser;
import com.isolr.model.SolrIndex;
import com.isolr.service.SolrIndexManager;
import javacommon.base.BaseManager;
import javacommon.base.BaseSpringController;
import javacommon.util.SolrConstant;
import javacommon.util.HttpStatusCode;
import javacommon.util.GZIPCompress;
import javacommon.util.Paginator;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.common.SolrDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Andy
 * @since 2016/8/31 0031.
 */
@RestController
@RequestMapping("/search")
public class SolrController extends BaseSpringController<SolrIndex> {

    private static Logger log = LoggerFactory.getLogger(SolrController.class);

    @Inject
    private SolrIndexManager solrIndexManager;

    @Override
    protected BaseManager<SolrIndex> getManager() {
        return solrIndexManager;
    }

    @RequestMapping(value = "/work/{page}/{q}", method = RequestMethod.GET)
    public void searchWork(@PathVariable String q, @PathVariable int page,
                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginUser loginUser = getLoginUser(request);
        Paginator<SolrDocument> solrPage = solrIndexManager.findWorkSolrPage(new String[]{q},
                new String[]{"userId:"+ loginUser.getId()}, page);
        /*Paginator<SolrDocument> solrPage = solrIndexManager.findWorkSolrPage(new String[]{q},
                null, page);*/
        GZIPCompress.pages(solrPage, response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void indexing(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data = request.getParameter("datas");
        if (StringUtils.isNotBlank(data)) {
            JSONObject jsonData = (JSONObject) JSON.parse(data);
            int type = jsonData.getIntValue("type");
            long id = jsonData.getLongValue("id");
            SolrConstant solrConstant = SolrConstant.getApiConstant(type);
            if (null != solrConstant && id > 0) {
                SolrIndex solrIndex = getManager().get(id, solrConstant.getMapper());
                if (null != solrIndex) {
                    solrIndexManager.createWorkIndex(solrConstant, solrIndex);
                    GZIPCompress.success(response);
                    return;
                }
            }
            GZIPCompress.fail(HttpStatusCode.NOT_EXIST_ERROR,response);
            return;
        }
        GZIPCompress.fail(HttpStatusCode.VALIDATOR_ERROR, response);
    }

}
