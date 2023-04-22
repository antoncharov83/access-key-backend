package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.CheckSiteUrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
public class CheckSiteUrlController {
    final private CheckSiteUrlService checkSiteUrlService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String check(@RequestParam() String siteUrl){
        return checkSiteUrlService.check(siteUrl);
    }
}
