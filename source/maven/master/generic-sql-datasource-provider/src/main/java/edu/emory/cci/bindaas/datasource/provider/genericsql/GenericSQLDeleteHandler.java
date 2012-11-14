package edu.emory.cci.bindaas.datasource.provider.genericsql;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.JsonObject;


import edu.emory.cci.bindaas.datasource.provider.genericsql.model.DataSourceConfiguration;
import edu.emory.cci.bindaas.framework.api.IDeleteHandler;
import edu.emory.cci.bindaas.framework.model.ProviderException;
import edu.emory.cci.bindaas.framework.model.QueryResult;
import edu.emory.cci.bindaas.framework.util.GSONUtil;

public class GenericSQLDeleteHandler implements IDeleteHandler {
	private AbstractSQLProvider provider;
	private Log log = LogFactory.getLog(getClass());
	
	public AbstractSQLProvider getProvider() {
		return provider;
	}
	public void setProvider(AbstractSQLProvider provider) {
		this.provider = provider;
	}
	
	@Override
	public QueryResult delete(JsonObject dataSource, String deleteQueryToExecute)
			throws ProviderException {
		try {
			Connection connection = null;
			try {
				DataSourceConfiguration configuration = GSONUtil
						.getGSONInstance().fromJson(dataSource,
								DataSourceConfiguration.class);
				connection = provider.getConnection(configuration);
				Statement statement = connection.createStatement();
				int status = statement.executeUpdate(deleteQueryToExecute);
				QueryResult queryResult = new QueryResult();
				queryResult.setCallback(false);
				queryResult.setError(false);
				queryResult.setData(String.format(
						"{ 'result' : 'success' , 'rowsDeleted' : '%s' }",
						status + "").getBytes());
				return queryResult;
			} catch (Exception er) {
				log.error(er);
				throw er;
			} finally {
				if (connection != null)
					connection.close();
			}

		} catch (Exception e) {
			log.error(e);
			throw new ProviderException("Delete operation failed", e);
		}
		
	}

}