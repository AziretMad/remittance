package com.company.remittance.controllers;

import com.company.remittance.services.RemittanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/remittance")
@RequiredArgsConstructor
public class RemittanceController {
    private final RemittanceService remittanceService;

    @GetMapping()
    public String get(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size
    ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        return "remittances";
    }
}
