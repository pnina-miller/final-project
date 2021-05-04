package com.wuwei.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.wuwei.entity.Option;
import com.wuwei.entity.User;
import com.wuwei.entity.Value;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 


public class HibernateUtil {
	private static SessionFactory sessionFactory;
static {
Configuration configuration = new Configuration();
configuration.setProperty(
	"hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
configuration.setProperty(
	"hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
configuration.setProperty(
	"hibernate.connection.url", "jdbc:sqlserver://DESKTOP-2UL5JQF:1433");
configuration.setProperty("hibernate.connection.databasename", "QuickForm");
configuration.setProperty("hibernate.connection.username", "myLogin");
configuration.setProperty("hibernate.connection.password", "123456");
configuration.setProperty("connection.characterEncoding", "true");
configuration.setProperty("hibernate.hbm2ddl.auto", "update");
configuration.setProperty("hibernate.show_sql", "true");
configuration.addAnnotatedClass(User.class);
configuration.addAnnotatedClass(Option.class);
configuration.addAnnotatedClass(Value.class);

ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
}
public static SessionFactory getSessionFactory() {
	return sessionFactory;
}
} //;integratedSecurity=true     