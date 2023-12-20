package taixiu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
    public static void main(String[] args) {
        double taiKhoanNguoiChoi = 5000000;
        Scanner sc = new Scanner(System.in);
        Locale lc = new Locale("vn", "VN");
        NumberFormat numf = NumberFormat.getInstance(lc);
        int luaChon = 1;
        do{
            System.out.println("-------moi ban lua chon-----");
            System.out.println("Chon (1) de tiep tuc choi.");
            System.out.println("Chon (phim bki) de thoat.");
            luaChon = sc.nextInt();
            if(luaChon==1){
                System.out.println("****Bat Dau Choi: ");
                System.out.println("****Tai khoan cua ban"+ taiKhoanNguoiChoi+ ", ban muon cuoc bao nhieu? ");
                double datcuoc;
                do {
                    System.out.println("****Dat cuoc(0<so tien cuoc<=)"+ taiKhoanNguoiChoi+ ":");
                    datcuoc = sc.nextDouble();                    
                } while (datcuoc<=0 || datcuoc>taiKhoanNguoiChoi);
                int luaChonTaiXiu = 0;
                do {
                    System.out.println("******Chon: 1 <-> Tai hoac 2 <-> Xiu");
                    luaChonTaiXiu = sc.nextInt();
                } while (luaChonTaiXiu != 1 && luaChonTaiXiu !=2);

                //Tung xuc xac
                Random xucxac1 = new Random();
                Random xucxac2 = new Random();
                Random xucxac3 = new Random();

                int giaTri1 = xucxac1.nextInt(5)+1;
                int giaTri2 = xucxac2.nextInt(5)+1;
                int giaTri3 = xucxac3.nextInt(5)+1;
                int tong = giaTri1+giaTri2+giaTri3;

                //Tinh toan ket qua
                System.out.println("Ket qua: "+ giaTri1+ " - "+giaTri2+"0"+giaTri3);
                if(tong==3 || tong==18){
                    taiKhoanNguoiChoi-=datcuoc;
                    System.out.println("*****tong la: "+tong+ "=> Nha cai an het, ban da thua!");
                    System.out.println("****Tai khoan cua ban la: "+taiKhoanNguoiChoi);
                }else if(tong>4 || tong <=10){
                    System.out.println("*****Tong la: "+tong+ "=> Xiu");
                    if(luaChonTaiXiu==2){
                        System.out.println("Ban da thang cuoc ");
                        taiKhoanNguoiChoi+=datcuoc;
                        System.out.println("*****Tai khoan cua ban la "+taiKhoanNguoiChoi);
                    }else{
                        System.out.println("*****Ban da thua cuoc ");
                        taiKhoanNguoiChoi-=datcuoc;
                        System.out.println("*****Tai khoan cua ban la: "+taiKhoanNguoiChoi);
                    }
                }
            }
        }while(luaChon!=1);
    }
}
