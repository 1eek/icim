package com.example.demo;

import com.example.demo.Dao.inDao;
import com.example.demo.Service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    public static void addView(String fxml) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(HelloApplication.class.getResource(fxml));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("缴费提示");

        alert.setHeaderText("以下编号额客户需要缴费");
        ArrayList<Integer> res;
        res = Service.tip();
        if (res.isEmpty())
            alert.setContentText("暂无用户需要缴费");
        else
            alert.setContentText(res.toString());

        alert.showAndWait();

    }

    @Override
    public void stop() throws Exception {
        inDao inDao = new inDao();
        inDao.outFile();
        System.out.println("已退出");

    }

}