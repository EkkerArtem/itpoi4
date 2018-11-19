/**
 * HelloWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package generatedclasses;

public interface HelloWebService extends java.rmi.Remote {
    public java.lang.String getCalories(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public java.lang.String getByeString(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getHelloString(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getProteins(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public java.util.Calendar getCurrentTime() throws java.rmi.RemoteException;
    public java.lang.String getHarbohydrates(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public java.lang.String getFats(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
}
