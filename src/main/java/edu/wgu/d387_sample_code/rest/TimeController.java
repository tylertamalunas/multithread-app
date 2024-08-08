package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/")
public class TimeController {

    @RequestMapping(path = "/timezones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String convertTime() {
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUniversal = ZoneId.of("Etc/GMT");
        ZoneId zDefault = ZoneId.systemDefault();

        // Local Time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local Time: " + localDateTime.now());
        ZonedDateTime zonedDateTime = localDateTime.atZone(zDefault);
        // Eastern Time
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        System.out.println("Eastern time: " + localDateTimeEastern.toString());
        // Mountain Time
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        System.out.println("Mountain time: " + localDateTimeMountain.toString());
        // UTC time
        ZonedDateTime zonedDateTimeUniversal = zonedDateTime.withZoneSameInstant(zUniversal);
        LocalDateTime localDateTimeUniversal = zonedDateTimeUniversal.toLocalDateTime();
        System.out.println("Universal time: " + localDateTimeUniversal.toString());

        return localDateTimeUniversal.toString() + " " + localDateTimeMountain.toString() + " " + localDateTimeEastern.toString();
    }
}
