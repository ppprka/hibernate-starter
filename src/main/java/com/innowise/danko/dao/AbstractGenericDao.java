    package com.innowise.danko.dao;

import com.innowise.danko.util.SessionFactoryProvider;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractGenericDao<E> implements GenericDao<E> {

    private final Class<E> entityClass;

    public AbstractGenericDao() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public E findById(final Serializable id) {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            return (E) session.getSession().get(this.entityClass, id);
        }
    }

    @Override
    public void save(E entity) {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            session.getSession().save(entity);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void saveOrUpdate(E entity) {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            session.getSession().saveOrUpdate(entity);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(E entity) {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            session.getSession().delete(entity);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            List<E> entities = findAll();
            for (E entity : entities) {
                session.getSession().delete(entity);
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<E> findAll() {
        try(Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getSession().getCriteriaBuilder();
            CriteriaQuery<E> query = builder.createQuery(this.entityClass);
            Root<E> root = query.from(this.entityClass);
            query.select(root);
            return session.getSession().createQuery(query).getResultList();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
