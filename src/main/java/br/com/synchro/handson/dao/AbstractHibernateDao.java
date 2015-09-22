package br.com.synchro.handson.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cvs
 * @create Feb 19, 2015
 * 
 * @param <T>
 *            Parametro de tipo para representar a classe de entidade a ser persistida
 * @param <ID>
 *            Parametro de tipo para representar o id do objeto a ser persistido
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public abstract class AbstractHibernateDao<T, ID extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * Remove uma entidade
     * 
     * @param clazz
     *            classe a deletar
     * 
     * @param id
     *            id da entidade a ser persistida
     */
    @Transactional
    public void delete(final Class<T> clazz, final ID id) {
	final T entity = this.loadById(clazz, id);
	this.getCurrentSession().delete(entity);
    }

    /**
     * Remove uma entidade
     * 
     * @param entity
     *            entidade a ser deletada
     */
    @Transactional
    public void delete(final T entity) {
	this.getCurrentSession().delete(entity);
    }

    /**
     * Executa uma instrucao SQL
     * 
     * TO-DO alterar local desse metodo
     * 
     * @param sql
     *            a ser executado
     */
    public void executeUpdateSql(final String sql) {
	this.getCurrentSession().createSQLQuery(sql).executeUpdate();

    }

    /**
     * Busca uma entidade filtrando pelo id. Usa o metodo get do Hibernate (Sempre acessa o banco de dados)
     * 
     * @param clazz
     *            classe a ser buscada
     * 
     * @param id
     *            id da entidade para busca
     * @return retorna a entidade encontrada
     */
    @SuppressWarnings("unchecked")
    public T getById(final Class<T> clazz, final ID id) {
	return (T) this.getCurrentSession().get(clazz, id);
    }

    /**
     * 
     * @return current session
     */
    protected final Session getCurrentSession() {
	return this.sessionFactory.getCurrentSession();
    }

    /**
     * Busca todas as entidades
     * 
     * @param clazz
     *            utilizada para fazer a busca
     * 
     * @return retorna a lista de entidades
     */
    @SuppressWarnings("unchecked")
    // @Transactional
    public List<T> loadAll(final Class<T> clazz) {
	return this.getCurrentSession().createCriteria(clazz).list();
    }

    /**
     * Executa busca executando o criterio passado
     * 
     * @param clazz
     * @param field
     * @param value
     * 
     * @return lista de entidades
     */
    @SuppressWarnings("unchecked")
    public T loadByField(final Class<T> clazz, final String field, final String value) {
	return (T) this.getCurrentSession().createCriteria(clazz).add(Restrictions.eq(field, value)).uniqueResult();
    }

    /**
     * Busca uma entidade filtrando pelo id. Usa o metodo load do hibernate (Cria um proxy)
     * 
     * @param clazz
     *            utilizada para fazer a busca
     * 
     * @param id
     *            id da entidade para busca
     * @return retorna a entidade encontrada
     */
    @SuppressWarnings("unchecked")
    public T loadById(final Class<T> clazz, final ID id) {
	return (T) this.getCurrentSession().load(clazz, id);
    }

    /**
     * Persiste uma entidade
     * 
     * @param entity
     *            entidade a ser persistida
     */
    @Transactional(readOnly = false)
    public void persist(final T entity) {
	this.getCurrentSession().persist(entity);
    }

    /**
     * Atualiza uma entidade
     * 
     * @param entity
     *            id da entidade a ser persistida
     */
    @Transactional(readOnly = false)
    public void update(final T entity) {
	this.getCurrentSession().merge(entity);
    }

}
