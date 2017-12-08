package database;

public class BasicInfo {

    public String firstName;
    public String lastName;
    public String gender;
    public String birthday;
    public String telephone1;
    public String telephone2;
    public String email1;
    public String email2;
    public String address;
    public String nationality;

    public BasicInfo(String firstName, String lastName, String gender,
            String birthday, String telephone1, String telephone2,
            String email1, String email2, String address, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.email1 = email1;
        this.email2 = email2;
        this.address = address;
        this.nationality = nationality;
    }

    public BasicInfo() {
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.birthday = "";
        this.telephone1 = "";
        this.telephone2 = "";
        this.email1 = "";
        this.email2 = "";
        this.address = "";
        this.nationality = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
