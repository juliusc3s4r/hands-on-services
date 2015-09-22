package br.com.synchro.handson.exception;

/**
 * 
 * ServiceException.java Criado em Sep 20, 2014
 * 
 * @author Ciro S. Santos
 * @version 1.0
 * 
 *          Excecao a ser lancada nas classes de servico
 */
public class ServiceException extends Exception {

    /** Numero serial da classe **/
    private static final long serialVersionUID = 4597624410836835698L;

    /** Mensagem generica da excecao **/
    private String message;

    /**
     * Contrutor padrao que invoca a excecao da classe Exception
     */
    public ServiceException() {
	super();
    }

    /**
     * Construtor que adiciona a mensagem da excecao lancada
     * 
     * @param pMessage
     *            mensagem generica da excecao lancada
     */
    public ServiceException(final String pMessage) {
	this.message = pMessage;
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
	return message;
    }

    /**
     * @param pMessage
     *            the message to set
     */
    public void setMessage(final String pMessage) {
	message = pMessage;
    }

}