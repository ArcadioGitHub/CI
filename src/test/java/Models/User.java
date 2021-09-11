package Models;

import PageObjects.AppPage;

public class User extends AppPage {

    public static String id;
    public static String email;
    public static String pass;
    public static String name;
    public static String lastName;
    public static String age;
    public static String country;
    public static String role;
    public static String address1;
    public static String address2;
    public static String city;
    public static String state;
    public static String zipCode;
    public static String webSite;
    public static String picture;
    public static String phone;
    public static String note;

    public static void setUser(){
        setId(user.read("id"));
        setEmail(user.read("email"));
        setPass(user.read("pass"));
        setName(user.read("name"));
        setLastName(user.read("lastName"));
        setAge(user.read("age"));
        setCountry((user.read("country")));
        setRole(user.read("role"));
        setAddress1(user.read("Address1"));
        setAddress2(user.read("Address2"));
        setCity(user.read("City"));
        setState(user.read("State"));
        setZipCode(user.read("zipCode"));
        setWebSite(user.read("webSite"));
        setPicture(user.read("picture"));
        setPhone(user.read("phone"));
        setNote(user.read("note"));
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        User.pass = pass;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        User.age = age;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        User.country = country;
    }

    public static String getAddress1() {
        return address1;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        User.role = role;
    }

    public static void setAddress1(String address1) {
        User.address1 = address1;
    }

    public static String getAddress2() {
        return address2;
    }

    public static void setAddress2(String address2) {
        User.address2 = address2;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        User.city = city;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        User.state = state;
    }

    public static String getZipCode() {
        return zipCode;
    }

    public static void setZipCode(String zipCode) {
        User.zipCode = zipCode;
    }

    public static String getWebSite() {
        return webSite;
    }

    public static void setWebSite(String webSite) {
        User.webSite = webSite;
    }

    public static String getPicture() {
        return picture;
    }

    public static void setPicture(String picture) {
        User.picture = picture;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        User.phone = phone;
    }

    public static String getNote() {
        return note;
    }

    public static void setNote(String note) {
        User.note = note;
    }
}
