package com.company.remittance.controllers;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.services.RemittanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remittances")
public class RemittanceController {
    private final RemittanceService remittanceService;

    @GetMapping
    public String get(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            Model model
    ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        model.addAttribute("remittances", remittanceService.findAll(PageRequest.of(currentPage, pageSize)));
        return "remittances";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("remittance", new RemittanceDto());
        return "form";
    }

    @PostMapping
    public String save(@ModelAttribute("remittance") RemittanceDto remittanceDto) {
        System.out.println(remittanceDto);
        return "remittances";
    }
}
