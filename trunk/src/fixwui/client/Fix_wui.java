package fixwui.client;

import fixwui.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Fix_wui implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String        SERVER_ERROR    = "An error occurred while "
	                                                       + "attempting to contact the server. Please check your network "
	                                                       + "connection and try again.";
    
    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final FixGatewayServiceAsync fixGatewayService = GWT.create(FixGatewayService.class);
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
	// Use RootPanel.get() to get the entire body element
	RootPanel mainPanel = RootPanel.get("mainArea");
	mainPanel.setSize("800", "600");
	mainPanel.getElement().getStyle().setPosition(Position.RELATIVE);
	
	final ListBox listBox = new ListBox();
	listBox.setName("sessionlist");
	mainPanel.add(listBox, 18, 26);
	listBox.setSize("133px", "532px");
	listBox.setVisibleItemCount(500);

	
	fixGatewayService.getSessionList(new AsyncCallback<String[]>() {

	    @Override
            public void onFailure(Throwable caught) {
	        // TODO Auto-generated method stub
	        
            }

	    @Override
            public void onSuccess(String[] result) {
	        for(String session : result){
	            listBox.addItem(session);
		};
            }
	    
	});
    }
}
