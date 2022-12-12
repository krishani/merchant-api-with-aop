package merchant.api.demo.service.models;

public class Merchant {
    private int merchantId;
    private String name;
    private String department;
    private String title;

    public Merchant(int merchantId, String name) {
        this.merchantId = merchantId;
        this.name = name;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId=" + merchantId +
                ", name=" + name +
                ", department=" + department +
                ", title=" + title +
                '}';
    }
}
