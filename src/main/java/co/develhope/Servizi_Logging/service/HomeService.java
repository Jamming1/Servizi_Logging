package co.develhope.Servizi_Logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
public class HomeService {
    @Autowired
    Environment env;
    Logger logger = LoggerFactory.getLogger(HomeService.class);

    public double calculatePower() {
        int base = Integer.parseInt(Objects.requireNonNull(env.getProperty("envVar_1")));
        int exponent = Integer.parseInt(Objects.requireNonNull(env.getProperty("envVar_2")));
        try {
            logger.info("Starting calculation at:{}", OffsetDateTime.now());
            return Math.pow(base, exponent);
        }finally {
            logger.info("End of calculation");
        }
    }

    public void getErrors(){
        Error error = new Error(" 'This is my customized error message' " , null);
        logger.error("Error:{}", error, "{}occurred{}at:{}", OffsetDateTime.now());
    }
}
//takes the 2 numeric env values, then logs and returns the power (exponent) of the 2 values
//logs when starting and when finishing the calculation
///get-errors: throws a new custom error that will be logged
//saves all the logs in a subfolder called myCustomLogs