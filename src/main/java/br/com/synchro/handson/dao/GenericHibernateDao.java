package br.com.synchro.handson.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author cvs
 * @create Feb 19, 2015
 * 
 * @param <T>
 *            Parametro de tipo para representar a classe de entidade a ser persistida
 * @param <ID>
 *            Parametro de tipo para representar o id do objeto a ser persistido
 */
@Repository("genericDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T, ID extends Serializable> extends AbstractHibernateDao<T, ID> implements GenericDao<T, ID> {

    /**
     * No implementation needed
     */
}
