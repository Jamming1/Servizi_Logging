package co.develhope.Servizi_Logging;

import co.develhope.Servizi_Logging.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class HomeController {
    @Autowired
    HomeService service;
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/welcome")
    public String welcome(){
        try {
            logger.info("Starting Welcome method at: {}", OffsetDateTime.now());
            return "Welcome to my logExample application!";
        }finally {
            logger.info("Ending Welcome method execution at: {}", OffsetDateTime.now());
        }
    }
    @GetMapping("/power")
    public ResponseEntity<?> getPower(){
        double power = service.calculatePower();
        return ResponseEntity.ok(power);
    }

    @GetMapping("/get-errors")
    public void getErrors(){
        service.getErrors();
    }
}
//write a Spring Boot application with the necessary dependencies that:
//has two custom int environment variables with the values 2 and 8
//starts from INFO for root level logging
//starts from DEBUG for services level logging
//the logging info has ANSI colours enabled
//has a basic controller that has 3 mappings:
///: returns just a welcome message and logs it
///exp: returns a service that:
