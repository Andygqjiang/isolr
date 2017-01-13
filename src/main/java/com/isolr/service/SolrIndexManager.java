package com.isolr.service;

import com.isolr.dao.SolrIndexDao;
import com.isolr.model.SolrIndex;
import javacommon.base.BaseMybatis3Dao;
import javacommon.base.BaseSolrManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Andy
 * @since 2016/8/31 0031.
 */
@Service
public class SolrIndexManager extends BaseSolrManager<SolrIndex> {

    @Inject
    private SolrIndexDao solrIndexDao;

    @Override
    protected BaseMybatis3Dao<SolrIndex> getDao() {
        return solrIndexDao;
    }
}
