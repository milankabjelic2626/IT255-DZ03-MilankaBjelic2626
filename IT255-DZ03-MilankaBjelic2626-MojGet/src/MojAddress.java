public class MojAddress 
{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private MojGeo geo;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getSuite() {
        return this.suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public MojGeo getGeo() {
        return this.geo;
    }

    public void setGeo(MojGeo geo) {
        this.geo = geo;
    }
}
