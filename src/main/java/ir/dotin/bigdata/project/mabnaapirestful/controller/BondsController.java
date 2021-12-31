package ir.dotin.bigdata.project.mabnaapirestful.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.BondInterestPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.service.bonds.BondInterestPaymentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bond")
public class BondsController {
    private final BondInterestPaymentsService bondAuthorityTypesService;

    public BondsController(BondInterestPaymentsService bondAuthorityTypesService) {
        this.bondAuthorityTypesService = bondAuthorityTypesService;
    }

    @GetMapping("/interestpayments")
    public ResponseEntity<Root<BondInterestPaymentsResponse>> getInterestPayments() throws JsonProcessingException {
        return new ResponseEntity<>(bondAuthorityTypesService.response(), HttpStatus.OK);
    }
}
