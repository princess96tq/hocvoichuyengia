import java.util.*;

public class QuanLyNhanVien {
        List<QuanLy> list1 = new ArrayList<>();
        List<NhanVien> list = new ArrayList<>();
        List<CongNhan> list3 = new ArrayList<>();
        List<NhanVienVanPhong> list2 = new ArrayList<>();
        QuanLy quanLy;
        NhanVienVanPhong nhanVienVanPhong;
        CongNhan congNhan;
        ArrayList<NhanVien> danhSach = new ArrayList();
        public QuanLyNhanVien() {
        }
        public void nhapThongTin() {
            System.out.println("Mời chọn nhập loại nhân viên: ");
            System.out.println("1 - Quản lý");
            System.out.println("2 - Nhân viên văn phòng");
            System.out.println("3 - Công nhân");
            String chon=new Scanner(System.in).nextLine();
            int n;
            switch(chon){
                case "1":
                    System.out.println("Nhập vào số quản lý muốn thêm: ");
                    n = new Scanner(System.in).nextInt();
                    for (int i = n; i >0 ; i--) {
                        if(list.size()>0) {
                            quanLy = new QuanLy(list.get(list.size() - 1).getMaNV() + 1);
                        }else {
                            quanLy = new QuanLy(1);

                        }
                        quanLy.nhapTT();
                        list.add(quanLy);
                        list1.add(quanLy);
                    }
                    break;
                case "2":
                    System.out.println("Nhập vào số nhân viên văn phòng muốn thêm: ");
                    n = new Scanner(System.in).nextInt();
                    for (int i = n; i >0 ; i--) {
                        if(list.size()>0) {
                            nhanVienVanPhong = new NhanVienVanPhong(list.get(list.size() - 1).getMaNV() + 1);
                        }else {
                            nhanVienVanPhong = new NhanVienVanPhong();

                        }
                        nhanVienVanPhong.nhapTT();
                        list.add(nhanVienVanPhong);
                        list2.add(nhanVienVanPhong);
                    }
                    break;
                case "3":
                    System.out.println("Nhập vào số công nhân muốn thêm: ");
                    n = new Scanner(System.in).nextInt();
                    for (int i = n; i >0 ; i--) {
                        if(list.size()>0) {
                            congNhan = new CongNhan(list.get(list.size() - 1).getMaNV() + 1);
                        }else {
                            congNhan = new CongNhan();

                        }
                        congNhan.nhapTT();
                        list.add(congNhan);
                        list3.add(congNhan);
                    }
                    break;
                default:
                    System.out.println("Xin chân thành cảm ơn");
                    System.exit(0);
                    break;

            }
            System.out.println();
        }

        public void hienThongTin() {
            System.out.println("Danh sách nhân viên công ty HVAT");
            System.out.println("===========================================================");
            for (QuanLy quanLy : list1){
               quanLy.hienTT();
            }
            for (NhanVienVanPhong nhanVienVanPhong : list2){
               nhanVienVanPhong.hienTT();
            }
            for (CongNhan congNhan : list3){
               congNhan.hienTT();
            }

        }

        public void timNhanVien() {
            System.out.println("Tìm nhân viên có thu nhập cao nhất theo: ");
            System.out.println("1 - Giới tính");
            System.out.println("2 - Theo vị trí ( nv văn phòng, công nhân, quản lý)");
            Scanner sc=new Scanner(System.in);
            String chon=sc.nextLine();
            switch(chon){
                case"1":
                    timGT();
                    break;
                case "2":
                    timVT();
                    break;
                default:
                    break;

            }
        }

    private void timVT() {
        System.out.println("1 - Quan ly");
        System.out.println("2 - Nhan vien VP ");
        System.out.println("3 - Cong nhan ");
        float tmp;
        int mNV;
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();
        switch(chon){
            case"1":
                tmp = 0;
                mNV = -1;
                for (QuanLy quanLy : list1){
                    tmp = Math.max(tmp,quanLy.thuNhap());
                }
                for (QuanLy quanLy : list1){
                    if (quanLy.thuNhap() == tmp){
                        System.out.println("Quan ly co thu nhap cao nhat la: ");
                        quanLy.hienTT();
                    }
                }
                break;
            case "2":
                System.out.println("Tuong tu 1");
                break;
            case "3":
                System.out.println("Tuong tu 1");
                break;
            default:
                break;

        }
    }

    private void timGT() {
        float tmp;
        int mNV;
        System.out.println("1 - Nam");
        System.out.println("2 - Nu");
        System.out.println("3 - KXD");
        Scanner sc=new Scanner(System.in);
        String chon=sc.nextLine();
        switch(chon){
            case"1":
                tmp = 0.0f;
                mNV = -1;
                for (QuanLy quanLy : list1){
                    if(quanLy.getGioiTinh() == GioiTinh.NAM){
                        tmp = Math.max(tmp,quanLy.thuNhap());
                    }
                }
                for (NhanVienVanPhong nhanVienVanPhong : list2){
                    if(nhanVienVanPhong.getGioiTinh() == GioiTinh.NAM){
                        tmp = Math.max(tmp,nhanVienVanPhong.thuNhap());
                    }
                }
                for (CongNhan congNhan : list3){
                    if(congNhan.getGioiTinh() == GioiTinh.NAM){
                        tmp = Math.max(tmp,congNhan.thuNhap());
                    }
                }
                for (QuanLy quanLy : list1){
                    if(quanLy.thuNhap() == tmp){
                        System.out.println("NV Nam co thu nhap cao nhat la: ");
                        quanLy.hienTT();
                    }
                }
                for (NhanVienVanPhong nhanVienVanPhong : list2){
                    if(nhanVienVanPhong.thuNhap() == tmp){
                        System.out.println("NV Nam co thu nhap cao nhat la: ");
                        nhanVienVanPhong.hienTT();
                    }
                }
                for (CongNhan congNhan : list3){
                    if(congNhan.thuNhap() == tmp){
                        System.out.println("NV Nam co thu nhap cao nhat la: ");
                        congNhan.hienTT();
                    }
                }
                break;
            case "2":
                System.out.println("Tuong tu 1");
                break;
            case "3":
                System.out.println("Tuong tu 1");
                break;
            default:
                break;

        }
    }
}

