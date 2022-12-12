package merchant.api.demo.service.services;

import merchant.api.demo.service.custom.exceptions.MerchantException;
import merchant.api.demo.service.models.Merchant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Override
    public Merchant createMerchant(String name, int merchantId) {
        Merchant newMerchant = new Merchant(merchantId, name);
        // TODO create merchant in the repository
        return newMerchant;
    }

    @Override
    public void deleteMerchant(int merchantId ) {
        // TODO delete merchant from repository
    }

    @Override
    public Merchant getMerchant(int merchantId) {
        throw new MerchantException("error thrown at get merchant for " + merchantId, HttpStatus.NOT_FOUND);
    }
}
