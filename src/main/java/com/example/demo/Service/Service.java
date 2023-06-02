package com.example.demo.Service;

import com.example.demo.Dao.inDao;
import com.example.demo.pojo.Insurance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.demo.Dao.inDao.inList;

public class Service {

    inDao inDao = new inDao();


    public Service() throws FileNotFoundException {
    }

    //快排
    public static void quickSort(ArrayList<Insurance> arr) {
        qsort(arr, 0, arr.size() - 1);
    }

    private static void qsort(ArrayList<Insurance> arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = partition(arr, low, high);        //将数组分为两部分
        qsort(arr, low, pivot - 1);                   //递归排序左子数组
        qsort(arr, pivot + 1, high);                  //递归排序右子数组
    }

    private static int partition(ArrayList<Insurance> arr, int low, int high) {
        Insurance insuranceLow = arr.get(low);
        int pivot = insuranceLow.getPrice();     //基准
        while (low < high) {
            Insurance insuranceHigh = arr.get(high);
            while (low < high && insuranceHigh.getPrice() >= pivot) {
                --high;
                insuranceHigh = arr.get(high);
            }
            arr.set(low, arr.get(high));             //交换比基准小的记录到左端

            Insurance insuranceLow2 = arr.get(low);
            while (low < high && insuranceLow2.getPrice() <= pivot) {
                ++low;
                insuranceLow2 = arr.get(low);
            }
            arr.set(high, arr.get(low));           //交换比基准大的记录到右端
        }
        //扫描完成，基准到位
        arr.set(low, insuranceLow);
        //返回的是基准的位置
        return low;
    }


    /**
     * 二分查找
     *
     * @param typesOfInsurance 保险类型
     * @param price            投保金额
     * @return 一个列表
     */
    public static ArrayList<Insurance> Search_Bin(String typesOfInsurance, int price) {
        ArrayList<Insurance> result = new ArrayList<>();
        int l = -1, r = inList.size();
        int mid;
        Insurance temp;
        while (l + 1 != r) {

            mid = (l + r) / 2;
            temp = inList.get(mid);
            if (temp.getPrice() == price) {
                result.add(temp);
                //向左查询
                int tempNum1 = mid - 1;
                temp = inList.get(tempNum1);
                while (tempNum1 >= 0 && temp.getPrice() == price) {
                    if (temp.getTypesOfInsurance().equals(typesOfInsurance))
                        result.add(temp);
                    tempNum1--;
                    if (tempNum1 >= 0)
                        temp = inList.get(tempNum1);
                }
                //向右查询
                int tempNum2 = mid + 1;
                temp = inList.get(tempNum2);
                while (tempNum2 < r && temp.getPrice() == price) {
                    if (temp.getTypesOfInsurance().equals(typesOfInsurance))
                        result.add(temp);
                    tempNum2++;
                    if (tempNum2 < inList.size())
                        temp = inList.get(tempNum2);
                }
                return result;

            } else {
                if (temp.getPrice() > price)
                    r = mid;
                else {
                    l = mid;
                }

            }

        }
        return result;
    }

    public static void format() {
        quickSort(inList);
        //重新编号
        Insurance in;
        for (int i = 0; i < inList.size(); i++) {
            in = inList.get(i);
            in.setID(i);
            inList.set(i, in);
        }

    }

    //添加
    public static void add(int PolicyNumber, String typesOfInsurance, int price, String way,
                           int account, boolean status, String beneficiary, int bfAccount, String remark) {
        long ID = inList.size();
        //获取当前时间和截止时间
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now = sdf.format(new Date());
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.YEAR, 30);
        String ddl = sdf.format(nowTime.getTime());
        //计算等级
        String level;
        if (price > 10000) {
            level = "特优";
        } else if (price > 5000) {
            level = "优质";
        } else {
            level = "普通";
        }
        Insurance insurance = new Insurance(ID, PolicyNumber, typesOfInsurance, ddl, price, way, account, now,
                status, beneficiary, bfAccount, level, remark);
        inList.add(insurance);
        format();
    }

    //编辑
    public static void revised(Insurance insurance) {
        int ID = (int) insurance.getID();
        inList.set(ID, insurance);

    }

    //缴费提示
    public static ArrayList<Integer> tip() {

        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();//开始时间

        ArrayList<Integer> list = new ArrayList<>();
        try {
            for (Insurance i :
                    inList) {
                String end = i.getDate();
                Date endDay = dft.parse(end);//结束时间
                Long starTime = now.getTime();
                Long endTime = endDay.getTime();
                Long num = endTime - starTime;//时间戳相差的毫秒数
                int day = (int) (num / (24 * 60 * 60 * 1000));

                if (day <= 7 && day >= 0) {
                    if (!i.getStatus())
                        list.add((int) i.getID());
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();

        }
        return list;

    }

    //初始化顺序表,并对其排序
    public void init() throws IOException {
        inDao.readFile();

        format();

    }

    //文件保存
    public void save() {
        inDao.outFile();
    }
}
