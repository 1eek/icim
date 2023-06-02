package com.example.demo.Controller;

import com.example.demo.HelloApplication;
import com.example.demo.Service.Service;
import com.example.demo.pojo.Insurance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static com.example.demo.Dao.inDao.inList;


public class tableController {
    Service service = new Service();
    ArrayList<Insurance> data;


    @FXML
    private TableColumn<Insurance, String> date;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Insurance, Integer> PolicyNumber;

    @FXML
    private TableColumn<Insurance, Integer> level;

    @FXML
    private TableColumn<Insurance, String> remark;

    @FXML
    private TableColumn<Insurance, String> ddl;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<Insurance, String> way;

    @FXML
    private Button search;

    @FXML
    private TableColumn<Insurance, String> beneficiary;

    @FXML
    private TableColumn<Insurance, Integer> price;

    @FXML
    private TableColumn<Insurance, Long> ID;

    @FXML
    private Button revised;

    @FXML
    private TableColumn<Insurance, String> typesOfInsurance;

    @FXML
    private TableView<Insurance> table;

    @FXML
    private TableColumn<Insurance, Integer> account;

    @FXML
    private TextField typeofin;

    @FXML
    private TextField pricein;

    @FXML
    private TableColumn<Insurance, Boolean> status;

    @FXML
    private TableColumn<Insurance, Integer> bfAccount;

    public tableController() throws FileNotFoundException {
    }


    @FXML
    void search(ActionEvent event) throws IOException {
        String type = typeofin.getText();
        int price = Integer.parseInt(pricein.getText());
        data = Service.Search_Bin(type, price);
        getdata();
    }

    @FXML
    public void add(ActionEvent event) throws IOException {
        HelloApplication.addView("add.fxml");


    }

    //删除数据
    @FXML
    void delete(ActionEvent event) throws IOException {

        Insurance in = table.getSelectionModel().getSelectedItem();
        if (in != null) {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmation Dialog");
            alert1.setHeaderText("提示");
            alert1.setContentText("确定要删除吗");

            Optional<ButtonType> result = alert1.showAndWait();
            if (result.get() == ButtonType.OK) {
                inList.remove(in);
            } else {
                alert1.close();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("警告");
            alert.setHeaderText("警告");
            alert.setContentText("您尚未选中用户");
            alert.showAndWait();
        }
        getdata();//刷新数据
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        Insurance in = table.getSelectionModel().getSelectedItem();
        if (in != null) {
            editController.setCurrent(in);
            HelloApplication.addView("edit.fxml");
        }


    }

    @FXML
    public void initialize() throws IOException {
        data = inList;
        service.init();
        getdata();

    }

    public void flush(ActionEvent actionEvent) throws IOException {
        data = inList;
        getdata();
        typeofin.setText("");
        pricein.setText("");
    }

    public void getdata() throws IOException {


        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        PolicyNumber.setCellValueFactory(new PropertyValueFactory<>("PolicyNumber"));
        typesOfInsurance.setCellValueFactory(new PropertyValueFactory<>("typesOfInsurance"));
        ddl.setCellValueFactory(new PropertyValueFactory<>("ddl"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        way.setCellValueFactory(new PropertyValueFactory<>("way"));
        account.setCellValueFactory(new PropertyValueFactory<>("account"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        beneficiary.setCellValueFactory(new PropertyValueFactory<>("beneficiary"));
        bfAccount.setCellValueFactory(new PropertyValueFactory<>("bfAccount"));
        level.setCellValueFactory(new PropertyValueFactory<>("level"));
        remark.setCellValueFactory(new PropertyValueFactory<>("remark"));
        table.setItems(FXCollections.observableList(data));

    }


}
