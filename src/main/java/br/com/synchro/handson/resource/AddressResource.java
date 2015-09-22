package br.com.synchro.handson.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.CustomNotFoundException;
import br.com.synchro.handson.exception.ServiceException;
import br.com.synchro.handson.service.AddressService;

/**
 * @author cvs
 * @create Sep 18, 2015
 */
@Component
@Path("/handson-service")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    private static Logger logger = Logger.getLogger(AddressResource.class);

    /**
     * @param address
     * @return status code
     */
    @POST
    @Path("/post")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addAddress(final Address address) {
	String res = "";
	try {
	    res = this.addressService.persist(address);
	    return Response.status(200).entity(res).build();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + ex.getMessage());
	    throw new CustomNotFoundException(res);
	}
    }

    /**
     * @return json
     */
    @GET
    @Path("/get-all")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<AddressDTO> getAddresses() {
	String res = "";
	try {
	    return this.addressService.loadAll();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + ex);
	    throw new CustomNotFoundException(res);
	}
    }
}
