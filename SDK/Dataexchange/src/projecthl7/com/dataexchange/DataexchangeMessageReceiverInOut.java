
/**
 * DataexchangeMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
        package projecthl7.com.dataexchange;

        /**
        *  DataexchangeMessageReceiverInOut message receiver
        */

        public class DataexchangeMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutSyncMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        DataexchangeSkeletonInterface skel = (DataexchangeSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("authenticaton".equals(methodName)){
                
                projecthl7.com.dataexchange.AuthenticatonResponse authenticatonResponse7 = null;
	                        projecthl7.com.dataexchange.AuthenticatonRequest wrappedParam =
                                                             (projecthl7.com.dataexchange.AuthenticatonRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    projecthl7.com.dataexchange.AuthenticatonRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               authenticatonResponse7 =
                                                   
                                                   
                                                         skel.authenticaton(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), authenticatonResponse7, false);
                                    } else 

            if("requestpatientdata".equals(methodName)){
                
                projecthl7.com.dataexchange.RequestpatientdataResponse requestpatientdataResponse9 = null;
	                        projecthl7.com.dataexchange.RequestpatientdataRequest wrappedParam =
                                                             (projecthl7.com.dataexchange.RequestpatientdataRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    projecthl7.com.dataexchange.RequestpatientdataRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               requestpatientdataResponse9 =
                                                   
                                                   
                                                         skel.requestpatientdata(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), requestpatientdataResponse9, false);
                                    } else 

            if("sendpatientdata".equals(methodName)){
                
                projecthl7.com.dataexchange.SendpatientdataResponse sendpatientdataResponse11 = null;
	                        projecthl7.com.dataexchange.SendpatientdataRequest wrappedParam =
                                                             (projecthl7.com.dataexchange.SendpatientdataRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    projecthl7.com.dataexchange.SendpatientdataRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               sendpatientdataResponse11 =
                                                   
                                                   
                                                         skel.sendpatientdata(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), sendpatientdataResponse11, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.AuthenticatonRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.AuthenticatonRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.AuthenticatonResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.AuthenticatonResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.SendpatientdataRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.SendpatientdataRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.SendpatientdataResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.SendpatientdataResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.RequestpatientdataRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.RequestpatientdataRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(projecthl7.com.dataexchange.RequestpatientdataResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(projecthl7.com.dataexchange.RequestpatientdataResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, projecthl7.com.dataexchange.AuthenticatonResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(projecthl7.com.dataexchange.AuthenticatonResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, projecthl7.com.dataexchange.SendpatientdataResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(projecthl7.com.dataexchange.SendpatientdataResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, projecthl7.com.dataexchange.RequestpatientdataResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(projecthl7.com.dataexchange.RequestpatientdataResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (projecthl7.com.dataexchange.AuthenticatonRequest.class.equals(type)){
                
                           return projecthl7.com.dataexchange.AuthenticatonRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (projecthl7.com.dataexchange.AuthenticatonResponse.class.equals(type)){
                
                           return projecthl7.com.dataexchange.AuthenticatonResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (projecthl7.com.dataexchange.SendpatientdataRequest.class.equals(type)){
                
                           return projecthl7.com.dataexchange.SendpatientdataRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (projecthl7.com.dataexchange.SendpatientdataResponse.class.equals(type)){
                
                           return projecthl7.com.dataexchange.SendpatientdataResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (projecthl7.com.dataexchange.RequestpatientdataRequest.class.equals(type)){
                
                           return projecthl7.com.dataexchange.RequestpatientdataRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (projecthl7.com.dataexchange.RequestpatientdataResponse.class.equals(type)){
                
                           return projecthl7.com.dataexchange.RequestpatientdataResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    