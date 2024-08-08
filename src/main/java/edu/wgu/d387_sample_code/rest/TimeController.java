package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/")
public class TimeController {

    @RequestMapping(path = "/timezones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String convertTime() {
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUniversal = ZoneId.of("Etc/GMT");
        ZoneId zDefault = ZoneId.of("America/Chicago");
        ZonedDateTime zonedDateTimeDefault = ZonedDateTime.of(LocalDateTime.of(2024 ,8,7,10,0), zDefault);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Eastern Time
        ZonedDateTime zonedDateTimeEastern = zonedDateTimeDefault.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        // Mountain Time
        ZonedDateTime zonedDateTimeMountain = zonedDateTimeDefault.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        // UTC time
        ZonedDateTime zonedDateTimeUniversal = zonedDateTimeDefault.withZoneSameInstant(zUniversal);
        LocalDateTime localDateTimeUniversal = zonedDateTimeUniversal.toLocalDateTime();

        return "UTC: " + localDateTimeUniversal.format(formatter) + "<br/>" +
                "MT:" + localDateTimeMountain.format(formatter) + "<br/>" +
                "ET:" + localDateTimeEastern.format(formatter);
    }
}
