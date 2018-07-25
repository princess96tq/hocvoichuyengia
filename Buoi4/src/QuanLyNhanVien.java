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
        public void sapXep(){
            Collections.sort(danhSach, new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien nhanVien1, NhanVien nhanVien2) {
                    return (nhanVien1.getTenNV().compareTo(nhanVien2.getTenNV()));
                }
            });

            System.out.println("Danh sách sắp xếp theo tên: ");
            for (int i = 0; i < danhSach.size(); i++) {
                System.out.println("Tên: " + danhSach.get(i).getTenNV() + " Giới tính: " + danhSach.get(i).getGioiTinh());
            }

        }

//        public void timNhanVien() {
//            System.out.println("Tìm nhân viên theo giới tình nào?????");
//            System.out.println("Chọn 1 nếu là Nam, 0 là Nữ, -1 nếu không xác định ");
//            Scanner sc=new Scanner(System.in);
//            String chon=sc.nextLine();
//            switch(chon){
//                case"1":
//                    for (NhanVien nhanVien : list) {
//                        if (nhanVien.getGioiTinh() == GioiTinh.NAM) {
//                            danhSach.add(nhanVien);
//                        }
//                        sapXep();
//                    }
//
//                    break;
//                case "2":
//                    for (NhanVien nhanVien : list) {
//                        if (nhanVien.getGioiTinh() == GioiTinh.NU) {
//                            danhSach.add(nhanVien);
//                        }
//                        sapXep();
//                    }
//
//                    break;
//                case "3":
//                    break;
//
//            }
//        }
}

