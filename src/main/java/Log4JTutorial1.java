import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

public class Log4JTutorial1 {

	 static final Logger log = LogManager.getLogger(Log4JTutorial1.class.getName());
	 
    public static void main(String[] args) {
        //BasicConfigurator.configure();
        log.debug("Sample debug message");
        log.info("Sample info message");
        log.warn("Sample warn message");
        log.error("Sample error message");
        log.fatal("Sample fatal message");
    }
	
}
