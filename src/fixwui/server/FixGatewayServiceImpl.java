package fixwui.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import simplefix.Application;
import simplefix.Engine;
import simplefix.EngineFactory;
import simplefix.Message;
import simplefix.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fixwui.client.FixGatewayService;

/**
 * The server side implementation of the RPC service.
 */

@SuppressWarnings("serial")
public class FixGatewayServiceImpl extends RemoteServiceServlet implements
        FixGatewayService {
    
    private static EngineFactory _engineFact;
    
    @Override
    public void init(final ServletConfig config) throws ServletException {
	super.init(config);
	
	try {
	    
	    Class<?> classobj = Class.forName("simplefix.quickfix.EngineFactory");
	    Object engineobj = classobj.newInstance();
	    
	    if ( engineobj instanceof EngineFactory ) {
		
		_engineFact = (EngineFactory) engineobj;
		Engine engine = _engineFact.createEngine();
		engine.initEngine("banzai.cfg");
		
		Application application = new _Application();
		
		engine.startInProcess(application);
		
		System.out.println("engine started");
	    }
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
	
    }
    
    @Override
    public String[] getSessionList() throws IllegalArgumentException {
	return new String[] { "Dummy1", "Dummy2" };
    }
    
    private static class _Application implements Application {
	
	public _Application() {
	}
	
	@Override
	public void onAppMessage(final Message arg0, final Session arg1) {
	    // TODO Auto-generated method stub
	    
	}
	
	@Override
	public void onLogon(final Session arg0) {
	    // TODO Auto-generated method stub
	    
	}
	
	@Override
	public void onLogout(final Session arg0) {
	    // TODO Auto-generated method stub
	    
	}
    };
    
}
