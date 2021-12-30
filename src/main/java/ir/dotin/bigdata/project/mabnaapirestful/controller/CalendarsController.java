package ir.dotin.bigdata.project.mabnaapirestful.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.OccasionTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarsController {
    private final OccasionTypesService occasionTypesService;

    public CalendarsController(OccasionTypesService occasionTypesService) {
        this.occasionTypesService = occasionTypesService;
    }

    @GetMapping("/occasiontypes")
    public ResponseEntity<Root<OccasionTypesResponse>> getOccasionTypes() throws JsonProcessingException {
        return new ResponseEntity<>(occasionTypesService.response(), HttpStatus.OK);
    }
}
