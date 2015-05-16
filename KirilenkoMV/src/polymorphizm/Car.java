package polymorphizm;

/**
 * Created by User on 16.05.2015.
 */
public abstract class Car {
    private String type;
    private String brandName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
