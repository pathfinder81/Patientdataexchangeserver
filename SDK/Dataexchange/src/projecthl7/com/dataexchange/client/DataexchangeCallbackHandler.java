
/**
 * DataexchangeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

    package projecthl7.com.dataexchange.client;

    /**
     *  DataexchangeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DataexchangeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DataexchangeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DataexchangeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for authenticaton method
            * override this method for handling normal response from authenticaton operation
            */
           public void receiveResultauthenticaton(
                    projecthl7.com.dataexchange.client.DataexchangeStub.AuthenticatonResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authenticaton operation
           */
            public void receiveErrorauthenticaton(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for requestpatientdata method
            * override this method for handling normal response from requestpatientdata operation
            */
           public void receiveResultrequestpatientdata(
                    projecthl7.com.dataexchange.client.DataexchangeStub.RequestpatientdataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from requestpatientdata operation
           */
            public void receiveErrorrequestpatientdata(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendpatientdata method
            * override this method for handling normal response from sendpatientdata operation
            */
           public void receiveResultsendpatientdata(
                    projecthl7.com.dataexchange.client.DataexchangeStub.SendpatientdataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendpatientdata operation
           */
            public void receiveErrorsendpatientdata(java.lang.Exception e) {
            }
                


    }
    