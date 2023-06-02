package com.example.demo.pojo;

public class Customer {
    private long ID;
    private String name;
    private String adress;
    private int phoneNum;
    private int Doc;

    public Customer(long ID, String name, String adress, int phoneNum, int doc) {
        this.ID = ID;
        this.name = name;
        this.adress = adress;
        this.phoneNum = phoneNum;
        Doc = doc;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getDoc() {
        return Doc;
    }

    public void setDoc(int doc) {
        Doc = doc;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNum=" + phoneNum +
                ", Doc=" + Doc +
                '}';
    }
}
