package fixwui.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Fix_wui implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String          SERVER_ERROR      = "An error occurred while "
	    + "attempting to contact the server. Please check your network "
	    + "connection and try again.";
    
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final FixGatewayServiceAsync fixGatewayService = GWT.create(FixGatewayService.class);
    
    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
	// Use RootPanel.get() to get the entire body element
	RootPanel mainPanel = RootPanel.get("mainArea");
	mainPanel.setSize("800", "600");
	mainPanel.getElement().getStyle().setPosition(Position.RELATIVE);
	
	ScrollPanel scrollPanel = new ScrollPanel();
	mainPanel.add(scrollPanel, 10, 10);
	scrollPanel.setSize("258px", "19px");
	
	final ListBox listBox = new ListBox();
	scrollPanel.setWidget(listBox);
	listBox.setName("sessionlist");
	listBox.setSize("100%", "100%");
	
	fixGatewayService.getSessionList(new AsyncCallback<ArrayList<String>>() {
	    
	    @Override
	    public void onFailure(final Throwable caught) {
		// TODO Auto-generated method stub
		
	    }
	    
	    @Override
	    public void onSuccess(final ArrayList<String> result) {
		for ( String session : result ) {
		    listBox.addItem(session);
		}
		;
	    }
	    
	});
    }
}
