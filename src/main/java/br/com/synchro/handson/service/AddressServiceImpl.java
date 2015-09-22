package br.com.synchro.handson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.synchro.handson.dao.GenericDao;
import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.domain.dto.DTOConverter;
import br.com.synchro.handson.exception.ServiceException;

/**
 * @author cvs
 * @create Sep 18, 2015
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private GenericDao<Address, Long> genericDao;

    /*
     * (non-Javadoc)
     * @see br.com.synchro.handson.service.AddressService#loadAll()
     */
    @Override
    public List<AddressDTO> loadAll() throws ServiceException {
	try {
	    final List<Address> list = this.genericDao.loadAll(Address.class);
	    return DTOConverter.convertToList(list);
	} catch (final Exception ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }

    /*
     * (non-Javadoc)
     * @see br.com.synchro.handson.service.AddressService#loadByField(java.lang.String, java.lang.String)
     */
    @Override
    public Address loadByField(final String pKey, final String pValue) throws ServiceException {
	try {
	    return this.genericDao.loadByField(Address.class, pKey, pValue);
	} catch (final Exception ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }

    /*
     * (non-Javadoc)
     * @see br.com.synchro.handson.service.AddressService#persist(br.com.synchro.handson.domain.Address)
     */
    @Override
    public String persist(final Address pEntity) throws ServiceException {
	try {
	    this.genericDao.persist(pEntity);
	    return "SUCCESS_ADD";
	} catch (final Exception ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }

    /*
     * (non-Javadoc)
     * @see br.com.synchro.handson.service.AddressService#remove(br.com.synchro.handson.domain.Address)
     */
    @Override
    public String remove(final Address pEntity) throws ServiceException {
	try {
	    this.genericDao.delete(pEntity);
	    return "SUCCESS_DELETE";
	} catch (final Exception ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }

}