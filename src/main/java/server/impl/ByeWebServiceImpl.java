package server.impl;

import server.ByeWebService;

import javax.jws.WebService;

@WebService(endpointInterface = "server.ByeWebService")
public class ByeWebServiceImpl implements ByeWebService {

    @Override
    public String getByeString(String name) {
        return "Bye, " + name + ":)";
    }
}
