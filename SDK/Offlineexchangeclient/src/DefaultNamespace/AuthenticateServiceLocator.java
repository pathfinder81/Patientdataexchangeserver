/**
 * AuthenticateServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class AuthenticateServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.AuthenticateService {

    public AuthenticateServiceLocator() {
    }


    public AuthenticateServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthenticateServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Authenticate
    private java.lang.String Authenticate_address = "http://localhost:8080/Offlineexchange/services/Authenticate";

    public java.lang.String getAuthenticateAddress() {
        return Authenticate_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthenticateWSDDServiceName = "Authenticate";

    public java.lang.String getAuthenticateWSDDServiceName() {
        return AuthenticateWSDDServiceName;
    }

    public void setAuthenticateWSDDServiceName(java.lang.String name) {
        AuthenticateWSDDServiceName = name;
    }

    public DefaultNamespace.Authenticate getAuthenticate() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Authenticate_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthenticate(endpoint);
    }

    public DefaultNamespace.Authenticate getAuthenticate(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.AuthenticateSoapBindingStub _stub = new DefaultNamespace.AuthenticateSoapBindingStub(portAddress, this);
            _stub.setPortName(getAuthenticateWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthenticateEndpointAddress(java.lang.String address) {
        Authenticate_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.Authenticate.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.AuthenticateSoapBindingStub _stub = new DefaultNamespace.AuthenticateSoapBindingStub(new java.net.URL(Authenticate_address), this);
                _stub.setPortName(getAuthenticateWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Authenticate".equals(inputPortName)) {
            return getAuthenticate();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "AuthenticateService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "Authenticate"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Authenticate".equals(portName)) {
            setAuthenticateEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
