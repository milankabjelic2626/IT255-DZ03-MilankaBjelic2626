public class MojObjekat 
{
    private int id;
    private String name;
    private String username;
    private String email;
    private MojAddress address;
    private String phone;
    private String website;
    private MojCompany company;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MojAddress getAddress() {
        return this.address;
    }

    public void setAddress(MojAddress address) {
        this.address = address;
    }


    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public MojCompany getCompany() {
        return this.company;
    }

    public void setCompany(MojCompany company) {
        this.company = company;
    }
}
