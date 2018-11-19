/**
 * HelloWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package generatedclasses;

public class HelloWebServiceImplServiceLocator extends org.apache.axis.client.Service implements generatedclasses.HelloWebServiceImplService {

    // Use to get a proxy class for HelloWebServiceImplPort
    private final java.lang.String HelloWebServiceImplPort_address = "http://localhost:1986/wss/hello";

    public java.lang.String getHelloWebServiceImplPortAddress() {
        return HelloWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWebServiceImplPortWSDDServiceName = "HelloWebServiceImplPort";

    public java.lang.String getHelloWebServiceImplPortWSDDServiceName() {
        return HelloWebServiceImplPortWSDDServiceName;
    }

    public void setHelloWebServiceImplPortWSDDServiceName(java.lang.String name) {
        HelloWebServiceImplPortWSDDServiceName = name;
    }

    public generatedclasses.HelloWebService getHelloWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWebServiceImplPort(endpoint);
    }

    public generatedclasses.HelloWebService getHelloWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            generatedclasses.HelloWebServiceImplPortBindingStub _stub = new generatedclasses.HelloWebServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getHelloWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (generatedclasses.HelloWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                generatedclasses.HelloWebServiceImplPortBindingStub _stub = new generatedclasses.HelloWebServiceImplPortBindingStub(new java.net.URL(HelloWebServiceImplPort_address), this);
                _stub.setPortName(getHelloWebServiceImplPortWSDDServiceName());
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
        String inputPortName = portName.getLocalPart();
        if ("HelloWebServiceImplPort".equals(inputPortName)) {
            return getHelloWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.server/", "HelloWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("HelloWebServiceImplPort"));
        }
        return ports.iterator();
    }

}
