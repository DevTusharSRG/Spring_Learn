import org.apache.catalina.startup.Tomcat;
import java.io.File;

public class EmbeddedTomcatRunner {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Ensure the path to your webapp is correct
        String webAppDir = "src/main/webapp";
        tomcat.addWebapp("/", new File(webAppDir).getAbsolutePath());

        System.out.println("Starting on http://localhost:8080/");
        tomcat.start();
        tomcat.getServer().await();
    }
}
