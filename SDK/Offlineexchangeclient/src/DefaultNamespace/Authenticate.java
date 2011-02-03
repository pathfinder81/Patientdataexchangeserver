/**
 * Authenticate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface Authenticate extends java.rmi.Remote {
    public boolean authentication(java.lang.String user, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String[] partener(java.lang.String users) throws java.rmi.RemoteException;
    public java.lang.String emailfinder(java.lang.String name) throws java.rmi.RemoteException;
    public void sendemail(java.lang.String receiptent, java.lang.String firstname, java.lang.String lastname, java.lang.String age, java.lang.String sex) throws java.rmi.RemoteException;
    public void uplaod(byte[] upl, java.lang.String fname, java.lang.String recpt) throws java.rmi.RemoteException;
}
