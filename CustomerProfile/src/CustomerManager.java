import java.lang.invoke.VarHandle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerManager {
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập thông tin khác hàng " + (i + 1));
            System.out.print("Mã khách hàng: ");
            int id = input.nextInt();
            System.out.print("Tên khách hàng: ");
            Scanner input1 = new Scanner(System.in);
            String name = input1.nextLine();
            System.out.print("Ngày sinh: ");
            int day = input.nextInt();
            System.out.print("Tháng sinh: ");
            int month = input.nextInt();
            System.out.print("Năm sinh: ");
            int year = input.nextInt();
            Customer customer = new Customer(id, name, new DateTime(day, month, year));
            list.add(customer);
        }
        compare(list.get(0), list.get(1));
    }

    public static void compare(Customer customer1, Customer customer2) {
        Date date1 = null;
        Date date2 = null;
        String date11 = customer1.getDateOfBirth().getDay() + "/" + customer1.getDateOfBirth().getMonth() + "/" + customer1.getDateOfBirth().getYear();
        String date22 = customer2.getDateOfBirth().getDay() + "/" + customer2.getDateOfBirth().getMonth() + "/" + customer2.getDateOfBirth().getYear();
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date11);
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date22);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1.compareTo(date2) > 0) {
            System.out.println("Khách hàng lớn tuổi hơn là " + customer2.getName());
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Khách hàng lớn tuổi hơn là " + customer1.getName());
        } else {
            System.out.println("Hai ông này bằng tuổi nhau =)))");
        }
    }
}
