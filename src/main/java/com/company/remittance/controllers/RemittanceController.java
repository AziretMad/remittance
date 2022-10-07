package com.company.remittance.controllers;

import com.company.remittance.dto.RemittanceDto;
import com.company.remittance.dto.RemittanceFilter;
import com.company.remittance.dto.RemittanceGrantDto;
import com.company.remittance.exceptions.GrantImpossibleException;
import com.company.remittance.exceptions.NotEnoughFundsException;
import com.company.remittance.services.AuthService;
import com.company.remittance.services.RemittanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/remittances")
public class RemittanceController {
    private final RemittanceService remittanceService;
    private final AuthService authService;

    @GetMapping
    public String get(
            @ModelAttribute("filter") RemittanceFilter filter,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            Model model
    ) {
        int currentPage = page.map(i -> i - 1).orElse(0);
        int pageSize = size.orElse(10);
        model.addAttribute("remittances",
                remittanceService.findByFilter(filter, PageRequest.of(currentPage, pageSize)));
        model.addAttribute("fund", authService.getCurrentUser().getFund());
        model.addAttribute("filter", filter != null ? filter : new RemittanceFilter());
        return "remittances";
    }

    @GetMapping("/form")
    public String getFormPage(Model model) {
        model.addAttribute("remittance", new RemittanceDto());
        return "form";
    }

    @PostMapping
    public String save(
            @ModelAttribute("remittance") @Valid RemittanceDto remittanceDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (bindingResult.hasErrors()) return "form";
        try {
            var remittance = remittanceService.save(remittanceDto);
            redirectAttributes.addFlashAttribute("title", "Remittance successfully created");
            redirectAttributes.addFlashAttribute("message", "Remittance code: " + remittance.getCode());
            return "redirect:/remittances/success";
        } catch (EntityNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
            return "form";
        }
    }

    @GetMapping("/grant")
    public String getGrantPage(Model model) {
        model.addAttribute("grant", new RemittanceGrantDto());
        return "grant";
    }

    @GetMapping("/success")
    public String showSuccessPage(
            HttpServletRequest request,
            Model model
    ) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        model.addAttribute("title", inputFlashMap.get("title"));
        model.addAttribute("message", inputFlashMap.get("message"));
        return "success";
    }

    @PostMapping("/grant")
    public String grant(
            @ModelAttribute("grant") @Valid RemittanceGrantDto remittanceGrantDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (bindingResult.hasErrors()) return "grant";
        try {
            var remittance = remittanceService.grant(remittanceGrantDto.getCode());
            redirectAttributes.addFlashAttribute("title", "Remittance successfully granted");
            redirectAttributes.addFlashAttribute("message",
                    "Granted: " + remittance.getAmount() + " " + remittance.getCurrency().getCode());
            return "redirect:/remittances/success";
        } catch (EntityNotFoundException | GrantImpossibleException | NotEnoughFundsException ex) {
            model.addAttribute("error", ex.getMessage());
            return "grant";
        }
    }
}
