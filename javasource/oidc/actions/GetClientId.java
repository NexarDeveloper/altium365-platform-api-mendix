// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetClientId extends CustomJavaAction<java.lang.String>
{
	private final java.lang.String DecodedAccesstoken;

	public GetClientId(
		IContext context,
		java.lang.String _decodedAccesstoken
	)
	{
		super(context);
		this.DecodedAccesstoken = _decodedAccesstoken;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		HashMap<String, String> readValue = new ObjectMapper().readValue(DecodedAccesstoken, HashMap.class);
		String sub = readValue.get("sub");
		String clientId = readValue.get("client_id");
	    String appId = readValue.get("appid");
	    String cid = readValue.get("cid");
	    if (sub != null && !sub.isEmpty()) {
	        return sub;
	      }else if (clientId != null && !clientId.isEmpty()) {
	        return clientId;
	      }else if (appId != null && !appId.isEmpty()) {
	        return appId;
	      } else if (cid != null && !cid.isEmpty()) {
	        return cid;
	      } else {
	        return null;
	      }
	    
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetClientId";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
