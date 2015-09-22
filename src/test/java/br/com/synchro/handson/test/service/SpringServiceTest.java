package br.com.synchro.handson.test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.ServiceException;
import br.com.synchro.handson.service.AddressService;

/**
 * @author cvs
 * @create Sep 18, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringServiceTest {

    @Autowired
    private AddressService addressService;

    /**
     * 
     */
    @Test
    public void testAPersistEntity() {
	try {
	    final Address address = new Address();
	    address.setStreet("Rua Samuel Morse");
	    address.setNumber(74);
	    address.setCity("SP");
	    address.setDistrict("SP");
	    address.setZipcode("12345-678");
	    final String ret = this.addressService.persist(address);
	    assertEquals("SUCCESS_ADD", ret);
	} catch (final ServiceException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     */
    @Test
    public void testBLoadAll() {
	List<AddressDTO> list = null;
	try {
	    list = this.addressService.loadAll();
	    for (final AddressDTO var : list) {
		System.out.println(var);
	    }
	    assertEquals(1, list.size());
	} catch (final ServiceException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     */
    //@Test
    public void testCLoadAndRemoveEntity() {
	try {
	    final Address a = this.addressService.loadByField("street", "Rua Samuel Morse");
	    final String ret = this.addressService.remove(a);
	    assertEquals("SUCCESS_DELETE", ret);
	} catch (final ServiceException e) {
	    e.printStackTrace();
	}
    }
}