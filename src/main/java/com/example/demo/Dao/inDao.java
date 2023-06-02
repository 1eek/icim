package com.example.demo.Dao;

import com.example.demo.pojo.Insurance;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class inDao {
    public static ArrayList<Insurance> inList = new ArrayList();
    String fileName = "data.txt";

    public inDao() throws FileNotFoundException {
    }

    //添加
    public static void addIn(Insurance in) {

        inList.add(in);

    }

    //从文件中读取数据
    public void readFile() throws IOException {


        Stream<String> lines = Files.lines(Paths.get(fileName));

        // 随机行顺序进行数据处理
        lines.forEach(ele -> {
            String[] temp;
            temp = ele.split(",");
            try {
                inList.add(transformation(temp));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        });

    }

    //字符串转类,用于文件读取
    public Insurance transformation(String[] str) throws ParseException {

        long ID = Long.parseLong(str[0]);
        int PolicyNumber = Integer.parseInt(str[1]);
        String typesOfInsurance = str[2];
        String ddl = str[3];
        int price = Integer.parseInt(str[4]);
        String way = str[5];
        int account = Integer.parseInt(str[6]);
        String date = str[7];
        boolean status = Boolean.valueOf(str[8]);
        String beneficiary = str[9];
        int bfAccount = Integer.parseInt(str[10]);
        String level = str[11];
        String remark = str[12];
        return new Insurance(ID, PolicyNumber, typesOfInsurance, ddl, price, way, account,
                date, status, beneficiary, bfAccount, level, remark
        );

    }

    //删除
    public void delete(int ID) {
        inList.remove(ID);
    }
    //修改

    //保存数据到文件

    /**
     * 输出到文件
     */
    @Test
    public void outFile() {

        File file = new File(fileName);

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            Insurance insurance;
            // get the content in bytes
            for (int i = 0; i < inList.size(); i++) {
                insurance = inList.get(i);
                fop.write(insurance.toString().getBytes());
            }

            fop.flush();
            fop.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

