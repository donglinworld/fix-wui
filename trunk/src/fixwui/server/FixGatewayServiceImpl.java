package fixwui.server;

import fixwui.client.FixGatewayService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class FixGatewayServiceImpl extends RemoteServiceServlet implements
        FixGatewayService {
    
    public String[] getSessionList() throws IllegalArgumentException {
	return new String[] {"Dummy1","Dummy2"};
    }
    
}
