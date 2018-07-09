package com.lilian.base;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * jpa-demo
 *
 * @Author 孙龙
 * @Date 2018/7/2
 */
public class SimpleBaseRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

//    @PersistenceContext
    private final EntityManager entityManager;

    private Class<T> clazz;

    public SimpleBaseRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.clazz = domainClass;
        this.entityManager = em;
    }

    @Override
    public List<Object[]> sqlArrayList(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public List sqlObjectList(String sql, Object obj) {
        Query query = entityManager.createNativeQuery(sql, obj.getClass());
        List list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public List sqlSingleList(String sql) {
        Query query=entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        entityManager.close();
        return  list;
    }
}
