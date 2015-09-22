package br.com.synchro.handson.domain.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.synchro.handson.domain.Address;

/**
 * 
 * 
 * @author cvs
 * @version 1.0
 */
public class DTOConverter {

    /**
     * @param list
     * @return dto list
     */
    public static List<AddressDTO> convertToList(final List<Address> list) {
	final List<AddressDTO> listVO = new ArrayList<AddressDTO>();
	if (list != null) {
	    for (final Address var : list) {
		final AddressDTO vo = new AddressDTO();
		vo.setId(var.getId());
		vo.setCity(var.getCity());
		vo.setDistrict(var.getDistrict());
		vo.setNumber(var.getNumber());
		vo.setStreet(var.getStreet());
		vo.setZipcode(var.getZipcode());
		listVO.add(vo);
	    }
	}
	return listVO;
    }
}