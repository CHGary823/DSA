public class Donor {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String donorType; // e.g., government, private, public
    private String ArrayListKey; // Foreign Key

    // Constructor
    public Donor(String id, String name, String phoneNumber, String email, String donorType, String ArrayListKey) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donorType = donorType;
        this.ArrayListKey = ArrayListKey;
    }

    // Getters for all fields
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDonorType() {
        return donorType;
    }

    public String getArrayListKey() {
        return ArrayListKey;
    }

    //Setter for all fields


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public void setArrayListKey(String ArrayListKey) {
        this.ArrayListKey = ArrayListKey;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", donorType='" + donorType + '\'' +
                ", avlTreeKey='" + ArrayListKey + '\'' +
                '}';
    }
}
