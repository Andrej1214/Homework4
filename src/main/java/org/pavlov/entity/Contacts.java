package org.pavlov.entity;

public class Contacts {
    private String address;
    private String tel;
    private String email;
    private String url;

    public Contacts() {
    }

    public Contacts(String address, String tel, String email, String url) {
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (!address.equals(contacts.address)) return false;
        if (!tel.equals(contacts.tel)) return false;
        if (!email.equals(contacts.email)) return false;
        return url.equals(contacts.url);
    }

    @Override
    public int hashCode() {
        int result = address.hashCode();
        result = 31 * result + tel.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contacts{");
        sb.append("address='").append(address).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append("} ");
        return sb.toString();
    }
}
