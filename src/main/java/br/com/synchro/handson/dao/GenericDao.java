package br.com.synchro.handson.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author cvs
 * @create Feb 19, 2015
 * 
 * @param <T>
 *            Parametro de tipo para representar a classe de entidade a ser persistida
 * @param <ID>
 *            Parametro de tipo para representar o id do objeto a ser persistido
 */
public interface GenericDao<T, ID extends Serializable> {

    /**
     * Remove uma entidade
     * 
     * @param clazz
     *            classe a deletar
     * 
     * @param id
     *            id da entidade a ser deletada
     */
    void delete(Class<T> clazz, ID id);

    /**
     * Remove uma entidade
     * 
     * @param entity
     *            entidade a ser deletada
     */
    void delete(T entity);

    /**
     * Executa uma instrucao SQL
     * 
     * @param sql
     *            a ser executado
     */
    void executeUpdateSql(String sql);

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
    T getById(Class<T> clazz, ID id);

    /**
     * Busca todas as entidades
     * 
     * @param clazz
     *            classe a listar
     * 
     * @return retorna a lista de entidades
     */
    List<T> loadAll(Class<T> clazz);

    /**
     * Executa busca executando o criterio passado
     * 
     * @param clazz
     * @param field
     * @param value
     * 
     * @return lista de entidades
     */
    T loadByField(final Class<T> clazz, final String field, final String value);

    /**
     * Busca uma entidade filtrando pelo id. Usa o metodo load do hibernate (Cria um proxy)
     * 
     * @param clazz
     *            classe a ser buscada
     * 
     * @param id
     *            id da entidade para busca
     * @return retorna a entidade encontrada
     */
    T loadById(Class<T> clazz, ID id);

    /**
     * Persiste uma entidade
     * 
     * @param entity
     *            entidade a ser persistida
     */
    void persist(T entity);

    /**
     * Atualiza uma entidade
     * 
     * @param entity
     *            id da entidade a ser persistida
     */
    void update(T entity);
}
