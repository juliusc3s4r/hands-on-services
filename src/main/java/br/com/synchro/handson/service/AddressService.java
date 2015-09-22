package br.com.synchro.handson.service;

import java.util.List;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.ServiceException;

/**
 * @author cvs
 * @create Sep 18, 2015
 */
public interface AddressService {

    /**
     * @return all addresses
     * @throws ServiceException
     */
    public List<AddressDTO> loadAll() throws ServiceException;

    /**
     * 
     * @param key
     * @param value
     * @return address
     * @throws ServiceException
     */
    public Address loadByField(String key, String value) throws ServiceException;

    /**
     * @param entity
     * @return status
     * @throws ServiceException
     */
    public String persist(Address entity) throws ServiceException;

    /**
     * @param entity
     * @return status
     * @throws ServiceException
     */
    public String remove(Address entity) throws ServiceException;

}	