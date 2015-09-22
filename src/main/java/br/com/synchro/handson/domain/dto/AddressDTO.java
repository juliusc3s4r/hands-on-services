package br.com.synchro.handson.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author cvs
 * @create Sep 18, 2015
 */
@SuppressWarnings("serial")
@XmlRootElement
public class AddressDTO implements Serializable {

    private Long id;

    private String street;

    private Integer number;

    private String district;

    private String city;

    private String zipcode;

    /**
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
	return district;
    }

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
	return number;
    }

    /**
     * @return the street
     */
    public String getStreet() {
	return street;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
	return zipcode;
    }

    /**
     * @param pCity
     *            the city to set
     */
    public void setCity(final String pCity) {
	city = pCity;
    }

    /**
     * @param pDistrict
     *            the district to set
     */
    public void setDistrict(final String pDistrict) {
	district = pDistrict;
    }

    /**
     * @param pId
     *            the id to set
     */
    public void setId(final Long pId) {
	id = pId;
    }

    /**
     * @param pNumber
     *            the number to set
     */
    public void setNumber(final Integer pNumber) {
	number = pNumber;
    }

    /**
     * @param pStreet
     *            the street to set
     */
    public void setStreet(final String pStreet) {
	street = pStreet;
    }

    /**
     * @param pZipcode
     *            the zipcode to set
     */
    public void setZipcode(final String pZipcode) {
	zipcode = pZipcode;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AddressDTO [id=" + id + ", street=" + street + ", number=" + number + ", district=" + district + ", city=" + city
		+ ", zipcode=" + zipcode + "]";
    }
}