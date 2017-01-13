package javacommon.base;

import com.alibaba.fastjson.JSONObject;
import javacommon.util.Paginator;

import java.util.List;
import java.util.Map;

/**
 * @author Andy
 * @since 2016/4/10
 */
public abstract class BaseManager<T> {

    protected abstract BaseMybatis3Dao<T> getDao();

    public T get(long id) {
        return getDao().get(id);
    }

    public T get(long id, String namespace) {
        return getDao().get(id, namespace);
    }

    public void save(T t) {
        getDao().save(t);
    }

    public void update(T t) {
        getDao().update(t);
    }

    public void delete(long id) {
        getDao().delete(id);
    }

    public List<T> findAll() throws Exception {
        return getDao().findAll();
    }

    public List<T> findList(Map<String, Object> param) throws Exception {
        return getDao().findList(param);
    }

    public void findPage(Paginator<T> paginator,String sqlid) {
        getDao().findPage(paginator,sqlid);
    }

    public void findPage(Paginator<T> paginator) {
        getDao().findPage(paginator);
    }

}
