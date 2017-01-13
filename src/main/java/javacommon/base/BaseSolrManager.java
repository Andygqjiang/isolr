package javacommon.base;

import com.isolr.indexing.IndexCore;
import javacommon.util.SolrConstant;
import javacommon.util.Paginator;
import javacommon.util.SolrCriteriaKeys;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy
 * @since 2016/8/26 0026.
 */
public abstract class BaseSolrManager<T> extends BaseManager {

    @Inject
    private IndexCore indexCore;

    public UpdateResponse createWorkIndex(SolrConstant constant, T t) throws Exception {
        SolrInputDocument solrInputFields = new SolrInputDocument();
        newDocument(constant, t, solrInputFields);
        return indexCore.createWorkIndex(solrInputFields);
    }

    @SuppressWarnings("unchecked")
    public UpdateResponse createWorkIndex(SolrConstant constant) throws Exception {
        List<T> lists = getDao().findAll(constant.getMapper());
        SolrInputDocument solrInputFields;
        List<SolrInputDocument> solrInputDocuments = new ArrayList<>();
        for (T list : lists) {
            solrInputFields = new SolrInputDocument();
            newDocument(constant, list, solrInputFields);
            solrInputDocuments.add(solrInputFields);
            System.out.println();
        }
        return indexCore.createWorkIndex(solrInputDocuments);
    }

    private void newDocument(SolrConstant constant, T t, SolrInputDocument solrInputFields) throws Exception {
        Class clazz = t.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
                final Object invoke = method.invoke(t);
                if (null != invoke) {
                    String srcfieldName = StringUtils.substring(method.getName(), 3);
                    String firstChar = StringUtils.substring(srcfieldName, 0, 1);
                    srcfieldName = srcfieldName.replace(firstChar, firstChar.toLowerCase());
                    solrInputFields.addField(srcfieldName, invoke);
                }
            }
        }
        solrInputFields.addField("bTypeName", constant.getName());
        solrInputFields.addField("bType", constant.value());
    }

    public UpdateResponse deleteWorkByQuery(String query) throws Exception {
        UpdateResponse updateResponse = indexCore.deleteWorkByQuery(query);
        System.out.println(updateResponse);
        return updateResponse;
    }

    /**
     * work 版搜索
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findWorkSolrPage(int pageNumber) throws Exception {
        return this.findWorkSolrPage(null, null, null, null, null, null, pageNumber);
    }

    /**
     * work 版搜索
     * @param q 查询关键字
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findWorkSolrPage(String[] q, String[] fq, int pageNumber) throws Exception {
        return this.findWorkSolrPage(q, fq, null, null, null, null, pageNumber);
    }

    /**
     * work 版搜索
     * @param q 查询关键字
     * @param fq 过虑查询， 在 q 结果集中过滤出符合 fq 的数据
     * @param sortField 指定排序字段
     * @param fl 指定返回那些字段内容
     * @param df 默认的查询字段
     * @param wt 指定输出格式，可以有 xml, json， 默认：json
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findWorkSolrPage(String[] q, String[] fq,
                                                    String[] fl, String[] df, String wt,
                                                    String sortField, int pageNumber) throws Exception {
        Paginator<SolrDocument> page = findCommon(q, fq, fl, df, wt, sortField, pageNumber);
        indexCore.findWork(page);
        return page;
    }

    /**
     * sale 版搜索
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findSaleSolrPage(int pageNumber) throws Exception {
        return this.findSaleSolrPage(null, null, null, null, null, null, pageNumber);
    }

    /**
     * sale 版搜索
     * @param q 查询关键字
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findSaleSolrPage(String[] q, int pageNumber) throws Exception {
        return this.findSaleSolrPage(q, null, null, null, null, null, pageNumber);
    }

    /**
     * sale 版搜索
     * @param q 查询关键字
     * @param fq 过虑查询， 在 q 结果集中过滤出符合 fq 的数据
     * @param sortField 指定排序字段
     * @param fl 指定返回那些字段内容
     * @param df 默认的查询字段
     * @param wt 指定输出格式，可以有 xml, json， 默认：json
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findSaleSolrPage(String[] q, String[] fq,
                                                    String[] fl, String[] df, String wt,
                                                    String sortField, int pageNumber) throws Exception {
        Paginator<SolrDocument> page = findCommon(q, fq, fl, df, wt, sortField, pageNumber);
        indexCore.findSale(page);
        return page;
    }

    /**
     * crm 版搜索
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findCrmSolrPage(int pageNumber) throws Exception {
        return this.findCrmSolrPage(null, null, null, null, null, null, pageNumber);
    }

    /**
     * crm 版搜索
     * @param q 查询关键字
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findCrmSolrPage(String[] q, int pageNumber) throws Exception {
        return this.findCrmSolrPage(q, null, null, null, null, null, pageNumber);
    }

    /**
     * crm 版搜索
     * @param q 查询关键字
     * @param fq 过虑查询， 在 q 结果集中过滤出符合 fq 的数据
     * @param sortField 指定排序字段
     * @param fl 指定返回那些字段内容
     * @param df 默认的查询字段
     * @param wt 指定输出格式，可以有 xml, json， 默认：json
     * @param pageNumber 页码
     * @return 分页搜索结果集
     * @throws Exception
     */
    public Paginator<SolrDocument> findCrmSolrPage(String[] q, String[] fq,
                                                    String[] fl, String[] df, String wt,
                                                    String sortField, int pageNumber) throws Exception {
        Paginator<SolrDocument> page = findCommon(q, fq, fl, df, wt, sortField, pageNumber);
        indexCore.findCrm(page);
        return page;
    }

    private Paginator<SolrDocument> findCommon (String[] q, String[] fq,
                             String[] fl, String[] df, String wt,
                             String sortField, int pageNumber) throws Exception {
        Paginator<SolrDocument> page = new Paginator<>(pageNumber);
        if (q != null && q.length > 0)
            page.setParam(SolrCriteriaKeys.q.name(), q);
        else
            page.setParam(SolrCriteriaKeys.q.name(), new String[]{"*:*"});

        if (fq != null && fq.length > 0)
            page.setParam(SolrCriteriaKeys.fq.name(), fq);

        if (StringUtils.isNotBlank(sortField))
            page.setSolrSortCriteria(sortField);
        else
            page.setSolrSortCriteria("createTime");

        if (fl != null && fl.length > 0)
            page.setParam(SolrCriteriaKeys.fl.name(), fl);

        if (df != null && df.length > 0)
            page.setParam(SolrCriteriaKeys.df.name(),df);

        if (StringUtils.isNotBlank(wt))
            page.setParam(SolrCriteriaKeys.wt.name(), wt);
        else
            page.setParam(SolrCriteriaKeys.wt.name(), new String[]{"json"});

        return page;
    }

}
