package edu.emory.cci.bindaas.webconsole.servlet.views;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import edu.emory.cci.bindaas.core.api.IManagementTasks;
import edu.emory.cci.bindaas.framework.model.Workspace;
import edu.emory.cci.bindaas.installer.command.VersionCommand;
import edu.emory.cci.bindaas.security.api.BindaasUser;
import edu.emory.cci.bindaas.webconsole.AbstractRequestHandler;
import edu.emory.cci.bindaas.webconsole.ErrorView;
import edu.emory.cci.bindaas.webconsole.util.VelocityEngineWrapper;

public class WorkspaceView extends AbstractRequestHandler {

	private static String templateName = "workspace.vt";
	private  Template template;
	private String uriTemplate;
	private Log log = LogFactory.getLog(getClass());
	private VelocityEngineWrapper velocityEngineWrapper;
	private IManagementTasks managementTasks;
	private VersionCommand versionCommand;

public IManagementTasks getManagementTasks() {
	return managementTasks;
}

public void setManagementTasks(IManagementTasks managementTasks) {
	this.managementTasks = managementTasks;
}

public VersionCommand getVersionCommand() {
	return versionCommand;
}

public void setVersionCommand(VersionCommand versionCommand) {
	this.versionCommand = versionCommand;
}


	
	public VelocityEngineWrapper getVelocityEngineWrapper() {
		return velocityEngineWrapper;
	}

	public void setVelocityEngineWrapper(VelocityEngineWrapper velocityEngineWrapper) {
		this.velocityEngineWrapper = velocityEngineWrapper;
	}

	public String getUriTemplate() {
		return uriTemplate;
	}

	public void setUriTemplate(String uriTemplate) {
		this.uriTemplate = uriTemplate;
	}

	public void init() throws Exception
	{
		template = velocityEngineWrapper.getVelocityTemplateByName(templateName);
	}

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> pathParameters)
			throws Exception {

		if (request.getMethod().equalsIgnoreCase("get")) {
			generateView(request, response, pathParameters);
		}

		else if (request.getMethod().equalsIgnoreCase("delete")) {
			deleteWorkspace(request, response, pathParameters);
		} else {
			throw new Exception("Http Method [" + request.getMethod()
					+ "] not allowed here");
		}

	}

	public void generateView(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> pathParameters)
			throws Exception {
		
		if (managementTasks != null) {
			Workspace workspace = managementTasks.getWorkspace(pathParameters
					.get("workspace"));
			VelocityContext context = new VelocityContext();
			context.put("workspace", workspace);
			context.put(
					"bindaasUser",
					BindaasUser.class.cast(
							request.getSession().getAttribute("loggedInUser"))
							.getName());
			/**
			 * Add version information
			 */
			String versionHeader = "";
			
			if(versionCommand!=null)
			{
				String frameworkBuilt = "";
			
				String buildDate = "";
				try{
					Properties versionProperties = versionCommand.getProperties();
					frameworkBuilt = String.format("%s.%s.%s", versionProperties.get("bindaas.framework.version.major") , versionProperties.get("bindaas.framework.version.minor") , versionProperties.get("bindaas.framework.version.revision") );
			
					buildDate = versionProperties.getProperty("bindaas.build.date");
				}catch(NullPointerException e)
				{
					log.warn("Version Header not set");
				}
				versionHeader = String.format("System built <strong>%s</strong>  Build date <strong>%s<strong>", frameworkBuilt,buildDate);
			}
			else
			{
				log.warn("Version Header not set");
			}
			context.put("versionHeader", versionHeader);
			template.merge(context, response.getWriter());
		} else {
			log.error("IManagementTasks service not available");
			throw new Exception("Service not available");
		}
	}

	public void deleteWorkspace(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> pathParameters) {
		String workspace = pathParameters.get("workspace");

		try {
			if (managementTasks != null) {
				managementTasks.deleteWorkspace(workspace);
				response.getWriter().append("success");
				response.getWriter().flush();
			} else {
				log.error("IManagementTasks service not available");
				throw new Exception("Service not available");
			}

		} catch (Exception e) {
			log.error(e);
			ErrorView.handleError(response, e);
		}

	}

}
