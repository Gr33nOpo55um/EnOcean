package ch.bfh.gr33nopo55um.enocean.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by stegmuellerp on 26.01.2017.
 */
public class TimeLogger {

    long startTime = 0;
    String operationName = "";
    long stopTime = 0;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setApplicationStartTime() {
        this.startTime = startTime;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    private static Logger logger = LogManager.getLogger();

    public void startLogTime() {
        //Log current time for performance measurement
        this.startTime = System.currentTimeMillis();
    }

    public void endLogTime() {

        //Log current time for performance measurement

        this.setStopTime(System.currentTimeMillis());

        long elapsedTime = this.getStopTime() - this.getStartTime();
        logger.info(this.getOperationName() + " in: " + elapsedTime + " miliseconds.");
    }
}
