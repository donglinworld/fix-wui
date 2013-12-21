package fixwui.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("FixGatewayService")
public interface FixGatewayService extends RemoteService {
    
    String[] getSessionList() throws IllegalArgumentException;
}
