package DefaultNamespace;

public class AuthenticateProxy implements DefaultNamespace.Authenticate {
  private String _endpoint = null;
  private DefaultNamespace.Authenticate authenticate = null;
  
  public AuthenticateProxy() {
    _initAuthenticateProxy();
  }
  
  public AuthenticateProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticateProxy();
  }
  
  private void _initAuthenticateProxy() {
    try {
      authenticate = (new DefaultNamespace.AuthenticateServiceLocator()).getAuthenticate();
      if (authenticate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticate != null)
      ((javax.xml.rpc.Stub)authenticate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Authenticate getAuthenticate() {
    if (authenticate == null)
      _initAuthenticateProxy();
    return authenticate;
  }
  
  public boolean authentication(java.lang.String user, java.lang.String password) throws java.rmi.RemoteException{
    if (authenticate == null)
      _initAuthenticateProxy();
    return authenticate.authentication(user, password);
  }
  
  public java.lang.String[] partener(java.lang.String users) throws java.rmi.RemoteException{
    if (authenticate == null)
      _initAuthenticateProxy();
    return authenticate.partener(users);
  }
  
  public java.lang.String emailfinder(java.lang.String name) throws java.rmi.RemoteException{
    if (authenticate == null)
      _initAuthenticateProxy();
    return authenticate.emailfinder(name);
  }
  
  public void sendemail(java.lang.String receiptent, java.lang.String firstname, java.lang.String lastname, java.lang.String age, java.lang.String sex) throws java.rmi.RemoteException{
    if (authenticate == null)
      _initAuthenticateProxy();
    authenticate.sendemail(receiptent, firstname, lastname, age, sex);
  }
  
  public void uplaod(byte[] upl, java.lang.String fname, java.lang.String recpt) throws java.rmi.RemoteException{
    if (authenticate == null)
      _initAuthenticateProxy();
    authenticate.uplaod(upl, fname, recpt);
  }
  
  
}