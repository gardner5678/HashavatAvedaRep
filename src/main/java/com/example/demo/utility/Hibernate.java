//package com.example.demo.utility;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//
//public class Hibernate {
//    public static final SessionFactory sessionFactory = buildSessionFactory();
//    public HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory) ;
//
//    public static SessionFactory buildSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        return configuration.buildSessionFactory(serviceRegistryBuilder
//                .buildServiceRegistry());
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
////    public static HibernateTransactionManager buildTransactionManager() {
////        Configuration configuration = new Configuration();
////        configuration.configure("hibernate.cfg.xml");
////        
////    }
//}
