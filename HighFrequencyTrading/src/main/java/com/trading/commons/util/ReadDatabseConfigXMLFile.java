package com.trading.commons.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.inject.Inject;
import com.trading.commons.persistence.util.Config;

public class ReadDatabseConfigXMLFile {

	private static final String DATABASE_CONFIG_FILE = System.getProperty("user.dir")
			+ "/src/main/resources/DbConfig.xml";

	private final static Logger logger = LogManagerUtil.getLogger(ReadDatabseConfigXMLFile.class);

	public static final String DBType = "DBType";

	public static final String DBHost = "DBHost";

	public static final String DBPort = "DBPort";

	public static final String DBUser = "DBUser";

	public static final String DBPassword = "DBPassword";

	public static final String ServiceName = "ServiceName";

	public static final String DB_ORACLE = "DB_ORACLE";

	public static final String InstanceName = "InstanceName";

	@Inject
	public ReadDatabseConfigXMLFile() {

	}

	public Config parseConfigXMLToConfigObject() {

		Config config = new Config();
		try {
			File fXmlFile = new File(DATABASE_CONFIG_FILE);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("properties");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					// System.out.println("properties : " + eElement.getAttribute("id"));
					config.setDBType((eElement.getElementsByTagName(DBType).item(0).getTextContent()));
					config.setDBHost(eElement.getElementsByTagName(DBHost).item(0).getTextContent());
					config.setDBPort(eElement.getElementsByTagName(DBPort).item(0).getTextContent());
					config.setDBUser(eElement.getElementsByTagName(DBUser).item(0).getTextContent());
					config.setDBPassword(eElement.getElementsByTagName(DBPassword).item(0).getTextContent());
					config.setServiceName(eElement.getElementsByTagName(ServiceName).item(0).getTextContent());
					config.setInstanceName(eElement.getElementsByTagName(InstanceName).item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			logger.info("Dbconfig XML file parsing Failed " + e);
		}

		return config;
	}
}
