// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import usercommons.proxies.UserClaim;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.thirdparty.org.json.JSONObject;

public class CreateClaimsWithJSON extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private final java.lang.String OpenIDTokenJSON;

	public CreateClaimsWithJSON(
		IContext context,
		java.lang.String _openIDTokenJSON
	)
	{
		super(context);
		this.OpenIDTokenJSON = _openIDTokenJSON;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		IContext context = Core.createSystemContext();
		String jsonString = OpenIDTokenJSON;
	    JSONObject jsonObject = new JSONObject(jsonString);
	    String[] fieldNames = JSONObject.getNames(jsonObject);
	    java.util.List<IMendixObject> userClaims = new java.util.ArrayList<>();
	    if (fieldNames != null) {
	    	 for (String fieldName : fieldNames) {
	             IMendixObject userClaim = Core.instantiate(context, UserClaim.getType());
	             userClaim.setValue(getContext(), UserClaim.MemberNames.Name.name(), fieldName);
	             Object obj = jsonObject.get(fieldName);
	             if (obj != null) {
	                 String value = String.valueOf(obj);
	                 userClaim.setValue(getContext(), UserClaim.MemberNames.Value.name(), value);
	                 userClaims.add(userClaim);
	             }
	             }

	    	  }
	    else {
            System.out.println("No fields found in the JSON object.");
	    }
		return userClaims;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "CreateClaimsWithJSON";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}