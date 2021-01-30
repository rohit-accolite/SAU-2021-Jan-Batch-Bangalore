package question_two;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Loggers {

    private static Logger logger = Logger.getLogger(Loggers.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Scanner sc = new Scanner(System.in);

        System.out.println("(1)Fatal -> (2)Error -> (3)Warn -> (4)Info -> (5)Debug -> (6)Trace -> (7)All");
        System.out.print("Enter Logger Level: ");
        int level = sc.nextInt();

        switch (level) {
            case 1:
                logger.setLevel(Level.FATAL);
                break;
            case 2:
                logger.setLevel(Level.ERROR);
                break;
            case 3:
                logger.setLevel(Level.WARN);
                break;
            case 4:
                logger.setLevel(Level.INFO);
                break;
            case 5:
                logger.setLevel(Level.DEBUG);
                break;
            case 6:
                logger.setLevel(Level.TRACE);
                break;
            case 7:
                logger.setLevel(Level.ALL);
                break;
            default:
                logger.setLevel(Level.OFF);
        }

        System.out.println("Logger level set to " + logger.getLevel());

        logger.fatal("Fatal Message");
        logger.error("Error Message");
        logger.warn("Warn Message");
        logger.info("Info Message");
        logger.debug("Debug Message");
        logger.trace("Trace Message");

        return;
    }
}
