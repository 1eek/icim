package com.example.demo.Controller;

import com.example.demo.Service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addController {

    @FXML
    private Button add;

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

    public void initialize() {
        way.getItems().clear();
        way.getItems().addAll("微信", "支付宝");
        status.getItems().clear();
        status.getItems().setAll("已支付", "未支付");
        type.getItems().clear();
        type.getItems().addAll("财产保险", "人身保险");
    }

    @FXML
    void add(ActionEvent event) {
        Boolean b;
        if (status.getValue().equals("已支付")) {
            b = true;
        } else {
            b = false;
        }
        int PolicyNumber = Integer.parseInt(num.getText());
        int inprice = Integer.parseInt(price.getText());
        int account1 = Integer.parseInt(account.getText());
        int bfaccount1 = Integer.parseInt(bfAccount.getText());

        Service.add(PolicyNumber, type.getValue(), inprice, way.getValue(), account1,
                b, beneficiary.getText(), bfaccount1, remark.getText());

        //关闭窗口
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();


    }

}
