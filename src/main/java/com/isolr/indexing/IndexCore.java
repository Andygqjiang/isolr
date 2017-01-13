package com.isolr.indexing;

import javacommon.util.Paginator;
import javacommon.util.SolrCriteriaKeys;
import javacommon.util.SolrStaticConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.data.solr.core.schema.SolrSchemaRequest;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;

/**
 * @author Andy
 * @since 2016/8/22 0022.
 */
@Component
public class IndexCore {

    @Inject
    private SolrClient solrClient;

    /**
     * work版建立索引
     * @param document
     * @return
     * @throws Exception
     */
    public UpdateResponse createWorkIndex(SolrInputDocument document) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.WORK_CORE,document);
        solrClient.commit(SolrStaticConstant.WORK_CORE);
        return updateResponse;
    }

    /**
     * work版建立索引
     * @param documents
     * @return
     * @throws Exception
     */
    public UpdateResponse createWorkIndex(Collection documents) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.WORK_CORE, documents);
        solrClient.commit(SolrStaticConstant.WORK_CORE);
        return updateResponse;
    }

    /**
     * sale版建立索引
     * @param document
     * @return
     * @throws Exception
     */
    public UpdateResponse createSaleIndex(SolrInputDocument document) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.SALE_CORE,document);
        solrClient.commit(SolrStaticConstant.SALE_CORE);
        return updateResponse;
    }

    /**
     * sale版建立索引
     * @param documents
     * @return
     * @throws Exception
     */
    public UpdateResponse createSaleIndex(Collection documents) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.SALE_CORE, documents);
        solrClient.commit(SolrStaticConstant.SALE_CORE);
        return updateResponse;
    }

    /**
     * crm版建立索引
     * @param document
     * @return
     * @throws Exception
     */
    public UpdateResponse createCrmIndex(SolrInputDocument document) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.CRM_CORE,document);
        solrClient.commit(SolrStaticConstant.CRM_CORE);
        return updateResponse;
    }

    /**
     * crm版建立索引
     * @param documents
     * @return
     * @throws Exception
     */
    public UpdateResponse createCrmIndex(Collection documents) throws Exception {
        UpdateResponse updateResponse = solrClient.add(SolrStaticConstant.SALE_CORE, documents);
        solrClient.commit(SolrStaticConstant.SALE_CORE);
        return updateResponse;
    }


    /**
     * 删除work版索引
     * @param query
     * @return
     * @throws Exception
     */
    public UpdateResponse deleteWorkByQuery(String query) throws Exception {
        UpdateResponse updateResponse = solrClient.deleteByQuery(SolrStaticConstant.WORK_CORE, query);
        solrClient.commit(SolrStaticConstant.WORK_CORE);
        return updateResponse;
    }

    /**
     * 删除 sale 版索引
     * @param query
     * @return
     * @throws Exception
     */
    public UpdateResponse deleteSaleByQuery(String query) throws Exception {
        UpdateResponse updateResponse = solrClient.deleteByQuery(SolrStaticConstant.SALE_CORE, query);
        solrClient.commit(SolrStaticConstant.SALE_CORE);
        return updateResponse;
    }

    /**
     * 删除 sale 版索引
     * @param query
     * @return
     * @throws Exception
     */
    public UpdateResponse deleteCrmByQuery(String query) throws Exception {
        UpdateResponse updateResponse = solrClient.deleteByQuery(SolrStaticConstant.CRM_CORE, query);
        solrClient.commit(SolrStaticConstant.CRM_CORE);
        return updateResponse;
    }

    /**
     * work 版搜索
     * @param page
     * @throws Exception
     */
    public void findWork(Paginator<SolrDocument> page) throws Exception {
        findCommon(page, SolrStaticConstant.WORK_CORE);
    }

    /**
     * sale 版搜索
     * @param page
     * @throws Exception
     */
    public void findSale(Paginator<SolrDocument> page) throws Exception {
        findCommon(page, SolrStaticConstant.SALE_CORE);
    }

    /**
     * crm 版搜索
     * @param page
     * @throws Exception
     */
    public void findCrm(Paginator<SolrDocument> page) throws Exception {
        findCommon(page, SolrStaticConstant.CRM_CORE);
    }

    private void findCommon(Paginator<SolrDocument> page, String collection) throws Exception {
        Map<String, Object> solrCriteria = page.getCriteria();
        SolrQuery query = new SolrQuery();
        for (String key : solrCriteria.keySet()) {
            query.set(key, (String[])solrCriteria.get(key));
        }
        query.set(SolrCriteriaKeys.fl.name(), page.getSolrField());
        query.setStart((int)page.getStart());
        query.setRows(page.getPageSize());
        if (StringUtils.isNotBlank(page.getSolrSortCriteria())) {
            SolrQuery.ORDER order = page.isSortDesc() ? SolrQuery.ORDER.desc  : SolrQuery.ORDER.asc;
            query.addSort(page.getSolrSortCriteria(), order);
        }
        QueryResponse response = solrClient.query(collection, query);
        SolrDocumentList results = response.getResults();
        page.setTotal(results.getNumFound());
        page.setDataList(results);
    }
}
