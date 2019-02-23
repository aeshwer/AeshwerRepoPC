package com.trading.commons.persistence.util;

public class Config {
	
	private String DBType;
	
    private String DBHost;
    
    private String DBPort;
    
    private String DBUser;
    
    private String DBPassword;
    
    private String ServiceName;
    
    private String InstanceName;

	public String getDBType() {
		return DBType;
	}

	public void setDBType(String dBType) {
		DBType = dBType;
	}

	public String getDBHost() {
		return DBHost;
	}

	public void setDBHost(String dBHost) {
		DBHost = dBHost;
	}

	public String getDBPort() {
		return DBPort;
	}

	public void setDBPort(String dBPort) {
		DBPort = dBPort;
	}

	public String getDBUser() {
		return DBUser;
	}

	public void setDBUser(String dBUser) {
		DBUser = dBUser;
	}

	public String getDBPassword() {
		return DBPassword;
	}

	public void setDBPassword(String dBPassword) {
		DBPassword = dBPassword;
	}

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getInstanceName() {
		return InstanceName;
	}

	public void setInstanceName(String instanceName) {
		InstanceName = instanceName;
	}
}