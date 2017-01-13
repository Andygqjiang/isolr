package javacommon.base;

import javacommon.util.Paginator;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author Andy
 * @since 2016/4/10
 */
public abstract class BaseMybatis3Dao<T> {

    public static final String MAPPER_SAVE = "insert";

    public static final String MAPPER_DELETE = "delete";

    public static final String MAPPER_UPDATE = "update";

    public static final String MAPPER_GET = "findById";

    public static final String MAPPER_FINDLIST = "findList";

    public static final String MAPPER_FINDALL = "findAll";

    public static final String MAPPER_FINDPAGEDLIST = "findPagedList";

    public static final String MAPPER_FINDPAGECOUNT = "findPagedCount";

    @Inject
    protected SqlSessionTemplate sqlSessionTemplate;

    protected String generateStatement (String sql) {
        return generateStatement(this.getClass().getSimpleName(), sql);
    }

    protected String generateStatement (String namespace, String sql) {
        return namespace + "." + sql;
    }

    public T get (long id) {
        return sqlSessionTemplate.selectOne(generateStatement(MAPPER_GET), id);
    }

    public T get(long id, String namespace) {
        return sqlSessionTemplate.selectOne(generateStatement(namespace, MAPPER_GET), id);
    }

    public void save (T t) {
        sqlSessionTemplate.insert(generateStatement(MAPPER_SAVE), t);
    }

    public void update(T t) {
        sqlSessionTemplate.update(generateStatement(MAPPER_UPDATE), t);
    }

    public void delete(long id) {
        sqlSessionTemplate.delete(generateStatement(MAPPER_DELETE), id);
    }

    public List<T> findAll() {
        return sqlSessionTemplate.selectList(generateStatement(MAPPER_FINDALL));
    }

    public List<T> findAll(String namespace) {
        return sqlSessionTemplate.selectList(generateStatement(namespace, MAPPER_FINDALL));
    }

    public List<T> findList(Map<String, Object> param) {
        List<T> list = sqlSessionTemplate.selectList(generateStatement(MAPPER_FINDLIST), param);
        return list;
    }

    public void findPage(Paginator<T> paginator) {
        long count = sqlSessionTemplate.selectOne(generateStatement(MAPPER_FINDPAGECOUNT), paginator);
        paginator.setTotal(count);
        if (count > 0) {
            int offset = (paginator.getCurrentPage() - 1) * paginator.getPageSize();
            List<T> list = sqlSessionTemplate.selectList(generateStatement(MAPPER_FINDPAGEDLIST), paginator, new RowBounds(offset, paginator.getPageSize()));
            paginator.setDataList(list);
        }
    }

    public void findPage(Paginator<T> paginator, String sqlid) {
        String countSql = sqlid + "Count"; //findMonthCount
        String listSql = sqlid + "List"; //findMonthList
        long count = sqlSessionTemplate.selectOne(generateStatement(countSql), paginator);
        paginator.setTotal(count);
        if (count > 0) {
            int offset = (paginator.getCurrentPage() - 1) * paginator.getPageSize();
            List<T> list = sqlSessionTemplate.selectList(generateStatement(listSql), paginator, new RowBounds(offset, paginator.getPageSize()));
            paginator.setDataList(list);
        }
    }
}
