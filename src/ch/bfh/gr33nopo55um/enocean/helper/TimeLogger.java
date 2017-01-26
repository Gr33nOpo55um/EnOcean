package ch.bfh.gr33nopo55um.enocean.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Time logger for performance measurement
 *
 * @author silas
 */
public class TimeLogger {

    private static Logger logger = LogManager.getLogger();
    private long startTime = 0;
    private String operationName = "";
    private long stopTime = 0;

    private long getStopTime() {
        return stopTime;
    }

    private void setStopTime() {
        this.stopTime = System.currentTimeMillis();
    }

    private long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    private String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void startLogTime() {
        //Log current time for performance measurement
        this.startTime = System.currentTimeMillis();
    }

    public void endLogTime() {

        //Log current time for performance measurement

        this.setStopTime();

        long elapsedTime = this.getStopTime() - this.getStartTime();
        logger.info(this.getOperationName() + " in: " + elapsedTime + " miliseconds.");
    }
}
