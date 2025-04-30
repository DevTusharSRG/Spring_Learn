//package com.colabfarm;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import com.colabfarm.config.WebConfig;
//
//public class App extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;  // Root context configuration (none in this case)
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] { WebConfig.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };  // Servlet mapping for all requests
//    }
//}

//
//package com.colabfarm;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//public class App {
//
//    public static void main(String[] args) throws ServletException, IOException {
//        // Initialize Spring Application Context
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        // Start your Spring MVC DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        servlet.init();
//        
//        // Now the application is ready to handle requests
//        System.out.println("Spring application started successfully!");
//    }
//}

//
//package com.colabfarm;
//
//import com.colabfarm.config.AppConfig;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletException;
//
//public class App {
//
//    public static void main(String[] args) throws ServletException {
//        // Create the web application context
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfig.class);
//        context.refresh();
//
//        // Create and initialize the DispatcherServlet with the context
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        servlet.init();
//
//        // Application is initialized
//        System.out.println("Spring web application initialized successfully!");
//    }
//}
//


//package com.colabfarm;
//
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import com.colabfarm.config.AppConfig;
//
//import javax.servlet.ServletException;
//import java.io.File;
//
//public class App {
//    public static void main(String[] args) throws ServletException {
//        // Create the web application context
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfig.class);
//        context.refresh();
//
//        // Create the embedded Tomcat server
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//
//        // Set base directory for Tomcat to serve files from the correct location
//        File base = new File(".");
//        String webappDirLocation = "src/main/webapp/";
//        
//        // Configure the Tomcat context
//        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
//        
//        // Create the DispatcherServlet and initialize it with the Spring context
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        tomcat.getHost().addChild(servlet);
//        
//        // Start Tomcat
//        tomcat.start();
//
//        System.out.println("Spring web application initialized successfully!");
//
//        // Wait for the server to handle requests
//        tomcat.getServer().await();
//    }
//}

//package com.colabfarm;
//
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import com.colabfarm.config.AppConfig;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//import java.io.File;
//
//public class App {
//    public static void main(String[] args) throws ServletException {
//        // Create the web application context
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfig.class);
//        context.refresh();
//
//        // Create the embedded Tomcat server
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//
//        // Set base directory for Tomcat to serve files from the correct location
//        File base = new File(".");
//        String webappDirLocation = "src/main/webapp/";
//
//        // Configure the Tomcat context
//        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
//
//        // Create the DispatcherServlet and initialize it with the Spring context
//        DispatcherServlet servlet = new DispatcherServlet(context);
//
//        // Register the DispatcherServlet with Tomcat
//        ServletRegistration.Dynamic registration = tomcat.addServlet("", "dispatcher", servlet);
//        registration.addMapping("/");
//
//        // Start Tomcat
//        tomcat.start();
//
//        System.out.println("Spring web application initialized successfully!");
//
//        // Wait for the server to handle requests
//        tomcat.getServer().await();
//    }
//}
//


package com.colabfarm;

import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.colabfarm.config.AppConfig;

import javax.servlet.ServletRegistration;
import java.io.File;
import org.apache.catalina.LifecycleException;

public class App {
    public static void main(String[] args) {
        try {
            // Create the web application context
            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
            context.register(AppConfig.class);
            context.refresh();

            // Create the embedded Tomcat server
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);

            // Set base directory for Tomcat to serve files from the correct location
            String webappDirLocation = "src/main/webapp/";

            // Configure the Tomcat context
            tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());

            // Create the DispatcherServlet and initialize it with the Spring context
            DispatcherServlet servlet = new DispatcherServlet(context);

            // Register the DispatcherServlet with Tomcat
            tomcat.addServlet("", "dispatcher", servlet).addMapping("/");

            // Start Tomcat
            tomcat.start();

            System.out.println("Spring web application initialized successfully!");

            // Wait for the server to handle requests
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
