package com.training;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReaderMain {


    public static void main(String[] args) throws Exception {
        File file = new File("app.properties");

        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        PropertyServer propertyReader = new PropertyServer();
        propertyReader.setPort(Integer.parseInt(properties.getProperty("server.port")));
        propertyReader.setIp(properties.getProperty("server.ip"));


        File file2 = new File("core.properties");

        Properties propertiesCore = new Properties();
        propertiesCore.load(new FileInputStream(file));
        PropertyCore coreProperties = new PropertyCore();
        coreProperties.setRequestTimeout(Long.parseLong(properties.getProperty("core.timeout")));
        coreProperties.setApplicationName(properties.getProperty("core.application.name"));


        // Annotation lib
        PropertyReaderLib<PropertyCore> propertyReaderLib = new PropertyReaderLib<>();
        PropertyCore propertyCore = propertyReaderLib.fillObject(PropertyCore.class);

        PropertyReaderLib<PropertyServer> propertyServerLib = new PropertyReaderLib<>();
        PropertyServer propertyServer = propertyServerLib.fillObject(PropertyServer.class);


    }

}
