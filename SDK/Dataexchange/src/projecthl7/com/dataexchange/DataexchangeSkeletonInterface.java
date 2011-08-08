
/**
 * DataexchangeSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
    package projecthl7.com.dataexchange;
    /**
     *  DataexchangeSkeletonInterface java skeleton interface for the axisService
     */
    public interface DataexchangeSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         
                                    * @param authenticatonRequest
         */

        
                public projecthl7.com.dataexchange.AuthenticatonResponse authenticaton
                (
                  projecthl7.com.dataexchange.AuthenticatonRequest authenticatonRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         
                                    * @param requestpatientdataRequest
         */

        
                public projecthl7.com.dataexchange.RequestpatientdataResponse requestpatientdata
                (
                  projecthl7.com.dataexchange.RequestpatientdataRequest requestpatientdataRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         
                                    * @param sendpatientdataRequest
         */

        
                public projecthl7.com.dataexchange.SendpatientdataResponse sendpatientdata
                (
                  projecthl7.com.dataexchange.SendpatientdataRequest sendpatientdataRequest
                 )
            ;
        
         }
    