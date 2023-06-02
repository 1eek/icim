package com.example.demo.pojo;

public class Insurance {
    private long ID;
    private int PolicyNumber;
    private String typesOfInsurance;
    private String ddl;
    private int price;
    private String way;
    private int account;
    private String date;
    private boolean status;
    private String beneficiary;
    private int bfAccount;
    private String level;
    private String remark;

    public Insurance(long ID, int policyNumber, String typesOfInsurance, String ddl, int price, String way, int account, String date, boolean status, String beneficiary, int bfAccount, String level, String remark) {
        this.ID = ID;
        this.PolicyNumber = policyNumber;
        this.typesOfInsurance = typesOfInsurance;
        this.ddl = ddl;
        this.price = price;
        this.way = way;
        this.account = account;
        this.date = date;
        this.status = status;
        this.beneficiary = beneficiary;
        this.bfAccount = bfAccount;
        this.level = level;
        this.remark = remark;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getTypesOfInsurance() {
        return typesOfInsurance;
    }

    public void setTypesOfInsurance(String typesOfInsurance) {
        this.typesOfInsurance = typesOfInsurance;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public int getBfAccount() {
        return bfAccount;
    }

    public void setBfAccount(int bfAccount) {
        this.bfAccount = bfAccount;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ID +
                "," + PolicyNumber +
                "," + typesOfInsurance +
                "," + ddl +
                "," + price +
                "," + way +
                "," + account +
                "," + date +
                "," + status +
                "," + beneficiary +
                "," + bfAccount +
                "," + level +
                "," + remark +
                "\n";
    }
}
