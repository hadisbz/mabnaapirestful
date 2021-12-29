package ir.dotin.bigdata.project.mabnaapirestful.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.BondAuthorityTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.BondAuthorityTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dotin")
public class MyController {
    private final BondAuthorityTypesService bondAuthorityTypesService;

    public MyController(BondAuthorityTypesService bondAuthorityTypesService) {
        this.bondAuthorityTypesService = bondAuthorityTypesService;
    }

    @GetMapping("/get")
    public ResponseEntity<BondAuthorityTypesResponse> set() throws JsonProcessingException {

        return new ResponseEntity<>(bondAuthorityTypesService.response(), HttpStatus.OK);
    }
}
