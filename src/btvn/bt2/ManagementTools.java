package btvn.bt2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementTools extends Material implements Discount {
    public Scanner scanner = new Scanner(System.in);
    ArrayList<Material> listMaterial = new ArrayList<>();
    private int idNumber = 10;

    public void ListMaterial() {
        listMaterial.add(new Meat("1", "thịt lợn", LocalDate.of(2023, 6, 15), 16000, 2.0));
        listMaterial.add(new Meat("2", "thịt gà", LocalDate.of(2023, 6, 16), 16500, 3.0));
        listMaterial.add(new Meat("3", "thịt chó", LocalDate.of(2023, 5, 17), 17000, 4.0));
        listMaterial.add(new Meat("4", "thịt mèo", LocalDate.of(2023, 5, 18), 17500, 5.0));
        listMaterial.add(new Meat("5", "thịt vịt", LocalDate.of(2023, 4, 19), 19000, 6.0));
        listMaterial.add(new CrispyFlour("6", "bột lợn", LocalDate.of(2022, 1, 10), 26000, 20));
        listMaterial.add(new CrispyFlour("7", "bột gà", LocalDate.of(2022, 2, 11), 26500, 30));
        listMaterial.add(new CrispyFlour("8", "bột chó", LocalDate.of(2023, 3, 12), 27000, 40));
        listMaterial.add(new CrispyFlour("9", "bột mèo", LocalDate.of(2023, 4, 13), 27500, 50));
        listMaterial.add(new CrispyFlour("10", "bột vịt", LocalDate.of(2023, 5, 14), 29000, 60));
    }
    public void showListMaterial () {
        for (Material value :
                listMaterial) {
            System.out.println(value);
        }
    }

    public void addCrispyFlour() {
        idNumber++;
        System.out.println("nhập tên bột");
        String newName = scanner.nextLine();
        System.out.println("nhập ngày sản xuất");
        int newDay = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tháng sản xuất");
        int newMonth = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập năm sản xuất");
        int newYear = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập giá");
        int newCost = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập số lượng");
        int newQuantity =  Integer.parseInt(scanner.nextLine());
        listMaterial.add(new CrispyFlour(idNumber+"", newName, LocalDate.of(newYear, newMonth, newDay), newCost, newQuantity));
        System.out.println("đã thêm thành công");
        System.out.println("danh sách sản phẩm mới là :");
        showListMaterial();
    }

    public void addMeat() {
        idNumber++;
        System.out.println("nhập tên thịt");
        String newName = scanner.nextLine();

        System.out.println("nhập ngày sản xuất");
        int newDay =  Integer.parseInt(scanner.nextLine());

        System.out.println("nhập tháng sản xuất");
        int newMonth =  Integer.parseInt(scanner.nextLine());

        System.out.println("nhập năm sản xuất");
        int newYear =  Integer.parseInt(scanner.nextLine());

        System.out.println("nhập giá");
        int newCost =  Integer.parseInt(scanner.nextLine());

        System.out.println("nhập số lượng");
        double newWeight = Integer.parseInt(scanner.nextLine());

        listMaterial.add(new Meat(idNumber+"", newName, LocalDate.of(newYear, newMonth, newDay), newCost, newWeight));
        System.out.println("đã thêm thành công");
        System.out.println("danh sách sản phẩm mới là :");
        showListMaterial();
    }

    public void repairMaterial() {
        System.out.println("nhập id cần sửa");
        String count = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < listMaterial.size(); i++) {
            if (listMaterial.get(i).getId().equals(count)) {
                System.out.println("nhập tên bột sửa lại");
                listMaterial.get(i).setName(scanner.nextLine());

                System.out.println("nhập ngày sản xuất sửa lại");
                int newDay =  Integer.parseInt(scanner.nextLine());

                System.out.println("nhập tháng sản xuất sửa lại ");
                int newMonth =  Integer.parseInt(scanner.nextLine());

                System.out.println("nhập năm sản xuất sửa lại");
                int newYear =  Integer.parseInt(scanner.nextLine());

                listMaterial.get(i).setManufacturingDate(LocalDate.of(newYear, newMonth, newDay));

                System.out.println("nhập giá sửa lại");
                listMaterial.get(i).setCost( Integer.parseInt(scanner.nextLine()));

                if (listMaterial.get(i) instanceof CrispyFlour) {
                    System.out.println("nhập số lượng sửa lại");
                    ((CrispyFlour) listMaterial.get(i)).setQuantity( Integer.parseInt(scanner.nextLine()));
                } else if (listMaterial.get(i) instanceof Meat) {
                    System.out.println("nhập số cân nặng sửa lại");
                    ((Meat) listMaterial.get(i)).setWeight( Integer.parseInt(scanner.nextLine()));
                }
                flag = false;
                System.out.println("danh sách sản phẩm mới là :");
                showListMaterial();
            }
        }
        if (flag) {
            System.out.println("không có sản phẩm nào có id vừa nhập");
        }
    }

    public void removeMaterial() {
        System.out.println("nhập id cần xoa");
        String count = scanner.nextLine();
                boolean flag = true;
        for (int i = 0; i < listMaterial.size(); i++) {
            if (listMaterial.get(i).getId().equals(count)) {
                listMaterial.remove(i);
                System.out.println("đã xóa thành công ");
                flag = false;
                System.out.println("danh sách sản phẩm mới là :");
                showListMaterial();
            }
        }
        if (flag){
            System.out.println("id vừa nhập k có trong danh sách");
        }

    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }

    @Override
    public double getRealMoney() {
        double realMoney ;
        for (Material product : listMaterial) {
            if(product instanceof Meat){
                System.out.println(product);
                System.out.println("giá trước chiết khấu là :" + product.getAmount());
                if ( ChronoUnit.DAYS.between(LocalDate.now() , product.getExpiryDate()) <=5) {
                    realMoney = product.getAmount() * 0.7 ;
                    System.out.println("giá sau chiết khấu là :" + realMoney);
                }else {
                    realMoney = product.getAmount() * 0.9 ;
                    System.out.println("giá sau chiết khấu là:" + realMoney);
                }

            }
            if(product instanceof CrispyFlour){
                System.out.println(product);
                System.out.println("giá trước chiết khấu là :" + product.getAmount());
                if ( ChronoUnit.MONTHS.between(LocalDate.now() , product.getExpiryDate()) <=2) {
                    realMoney = product.getAmount() * 0.6 ;
                    System.out.println("giá sau chiết khấu là :" + realMoney);
                }else if( ChronoUnit.MONTHS.between(LocalDate.now() , product.getExpiryDate()) <= 4) {
                    realMoney = product.getAmount() * 0.8 ;
                    System.out.println("giá sau chiết khấu là :" + realMoney);
                }else {
                    realMoney = product.getAmount() * 0.95 ;
                    System.out.println("giá sau chiết khấu là :" + realMoney);
                }

            }

        }
        return 0;
    }
}
