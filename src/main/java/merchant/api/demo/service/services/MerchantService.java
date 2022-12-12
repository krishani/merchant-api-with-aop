package merchant.api.demo.service.services;

import merchant.api.demo.service.models.Merchant;

public interface MerchantService {

    public Merchant createMerchant(String name, int merchantId);

    public void deleteMerchant(int merchantId );

    public Merchant getMerchant(int merchantId);
}
