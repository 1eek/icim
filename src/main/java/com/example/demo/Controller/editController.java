package com.example.demo.Controller;


import com.example.demo.Service.Service;
import com.example.demo.pojo.Insurance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editController {

    //当前选中元素
    private static Insurance in;
    @FXML
    private Button save;
    @FXML
    private TextField beneficiary;
    @FXML
    private TextField price;
    @FXML
    private TextField num;
    @FXML
    private TextField remark;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private TextField account;
    @FXML
    private ChoiceBox<String> way;
    @FXML
    private TextField bfAccount;
    @FXML
    private ChoiceBox<String> status;

    public static void setCurrent(Insurance in) {
        editController.in = in;
    }

    //初始化复选框
    public void initialize() {
        way.getItems().clear();
        way.getItems().addAll("微信", "支付宝");
        status.getItems().clear();
        status.getItems().setAll("已支付", "未支付");
        type.getItems().clear();
        type.getItems().addAll("财产保险", "人身保险");
        showData();
    }

    //数据回显
    public void showData() {

        num.setText(String.valueOf(in.getPolicyNumber()));
        type.setValue(in.getTypesOfInsurance());
        price.setText(String.valueOf(in.getPrice()));
        way.setValue(in.getWay());
        account.setText(String.valueOf(in.getAccount()));
        status.setValue(String.valueOf(in.getStatus()));
        beneficiary.setText(in.getBeneficiary());
        bfAccount.setText(String.valueOf(in.getBfAccount()));
        remark.setText(in.getRemark());
    }

    @FXML
    void save(ActionEvent event) {
        //数据整理
        boolean b;
        b = status.getValue().equals("已支付");
        int PolicyNumber = Integer.parseInt(num.getText());
        int inprice = Integer.parseInt(price.getText());
        int account1 = Integer.parseInt(account.getText());
        int bfaccount1 = Integer.parseInt(bfAccount.getText());

        //设置数据
        in.setAccount(account1);
        in.setPrice(in.getPrice());
        in.setPolicyNumber(PolicyNumber);
        in.setTypesOfInsurance(String.valueOf(type.getValue()));
        in.setWay(String.valueOf(way.getValue()));
        in.setStatus(b);
        in.setBeneficiary(String.valueOf(beneficiary.getText()));
        in.setBfAccount(bfaccount1);
        in.setRemark(String.valueOf(remark.getText()));

        Service.revised(in);


        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();


    }


}
