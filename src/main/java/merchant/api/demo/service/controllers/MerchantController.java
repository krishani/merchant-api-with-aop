package merchant.api.demo.service.controllers;

import merchant.api.demo.service.models.Merchant;
import merchant.api.demo.service.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping("/api/v1/merchants")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Merchant createMerchant(@RequestBody final Merchant merchant) {
        return merchantService.createMerchant(merchant.getName(), merchant.getMerchantId());
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    public void deleteMerchant(@PathVariable Integer id) {
        merchantService.deleteMerchant(id);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Merchant getMerchant(@PathVariable Integer id) {
        return merchantService.getMerchant(id);
    }
}
