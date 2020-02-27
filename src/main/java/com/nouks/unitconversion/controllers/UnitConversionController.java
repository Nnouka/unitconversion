package com.nouks.unitconversion.controllers;

import com.nouks.unitconversion.dtos.UnitConversionDTO;
import com.nouks.unitconversion.services.Convertible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitConversionController {
    private Convertible convertible;

    @Autowired
    public UnitConversionController(Convertible convertible) {
        this.convertible = convertible;
    }

    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok(
                "Welcome to UnitConversion Api: Lookup project on GitHub https://github.com/Nnouka/unitconversion"
        );
    }

    @PostMapping("/api/verify/response")
    public ResponseEntity<String> convert(@RequestBody UnitConversionDTO unitConversionDTO) {
        return ResponseEntity.ok(
                convertible.respond(
                        unitConversionDTO.getInputUnit(),
                        unitConversionDTO.getInputValue(),
                        unitConversionDTO.getTargetUnit(),
                        unitConversionDTO.getResponse()
                )
        );
    }
}
