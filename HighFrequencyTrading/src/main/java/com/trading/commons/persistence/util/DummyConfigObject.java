package com.trading.commons.persistence.util;

public class DummyConfigObject {
	
	private String DBType;
	
    private String DBHost;
    
    private String DBPort;
    
    private String DBUser;
    
    private String DBPassword;
    
    private String ServiceName;
    
    private String InstanceName;

	public String getDBType() {
		return "mysql";
	}

	public void setDBType(String dBType) {
		DBType = dBType;
	}

	public String getDBHost() {
		return "localhost";
	}

	public void setDBHost(String dBHost) {
		DBHost = dBHost;
	}

	public String getDBPort() {
		return "3306";
	}

	public void setDBPort(String dBPort) {
		DBPort = dBPort;
	}

	public String getDBUser() {
		return "root";
	}

	public void setDBUser(String dBUser) {
		DBUser = dBUser;
	}

	public String getDBPassword() {
		return "password";
	}

	public void setDBPassword(String dBPassword) {
		DBPassword = dBPassword;
	}

	public String getServiceName() {
		return "hftdb";
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getInstanceName() {
		return "hftdb";
	}

	public void setInstanceName(String instanceName) {
		InstanceName = instanceName;
	}

}
