package ra.service;

import ra.model.Singer;

import java.util.Scanner;

public class SingerService {
    public static Singer[] arrSinger = new Singer[100];
    public static int indexSinger = 0;

//    static {
//        Singer Singer = new Singer(1, "Son tung", 30, "Viet Nam", true, "Nhac tre");
//        Singer Singer2 = new Singer(2, "Hương Tràm", 34, "Viet Nam", false, "Nhac trữ tình");
//        Singer Singer3 =new Singer(3, "Cam ly", 26, "Viet Nam", false, "Nhac bolero");
//        arrSinger[0]= Singer;
//        arrSinger[1]=Singer2;
//        arrSinger[2]=Singer3;
//        indexSinger=3;
//    }


    //Case 1: Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới
    public static void inputAddSinger(Scanner scanner) {
        System.out.println("Nhập vào số ca sĩ cần nhập: ");
        int countSinger = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSinger; i++) {
            //Nhap thong tin cho ca si co chi so index trong mang
            arrSinger[indexSinger] = new Singer();
            arrSinger[+indexSinger].inputData(scanner);
            indexSinger++;
        }
    }

    //Case 2: Hiển thị danh sách tất cả ca sĩ đã lưu trữ
    public static void displayListSinger() {
        for (int i = 0; i < indexSinger; i++) {
            arrSinger[i].displayData();
        }
    }

    //Lay vi tri id
    public static int getIndexById(int singerId) {
        for (int i = 0; i < indexSinger; i++) {
            if(arrSinger[i].getSingerId() == singerId) {
                return i;
            }
        }
        return -1;
    }

    //Case 3: Thay đổi thông tin ca sĩ theo mã id
    public static void changInfoSinger(Scanner scanner) {
        System.out.println("Nhập ID ca sĩ muốn thay đổi thông tin: ");
        int changeId = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < indexSinger; i++) {
            if(arrSinger[i].getSingerId() == changeId) {
                System.out.println("Nhập thông tin mới cho ca si: ");
                arrSinger[i].updateData(scanner);
                found = true;
            }
        }
        if(!found) {
            System.err.println("Không tìm thấy bài hát với mã ca sĩ đã nhập.");
        }
    }

    //Case 4: Xóa ca sĩ theo mã id
    public static void deleteSinger(Scanner scanner) {
        System.out.println("Mời nhập vào ca si cần xóa: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexById(singerId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexSinger; i++) {
                arrSinger[i] = arrSinger[i + 1];
            }
            indexSinger--;
            System.out.println(" Đã xóa ca sĩ có ID:" + singerId);
        }
        else  {
            System.err.println("Mã ca si không tồn tại");
        }
    }



    //Validate du lieu cua ca si
    //Nhap vao ma ca si tu tang
    public static int inputSingerId() {
        if (indexSinger == 0) {
            return 1;
        }
        else {
            int maxId = arrSinger[0].getSingerId();
            for (int i = 0; i < indexSinger; i++) {
                if(maxId < arrSinger[i].getSingerId()) {
                    maxId = arrSinger[i].getSingerId();
                }
            }
            return maxId + 1;
        }
    }

    //Nhap vao ten ca si
    public static String inputSingerName(Scanner scanner) {
        System.out.println("Mời nhập vào tên ca sĩ: ");
        do {
            String singerName = scanner.nextLine();
            if (singerName.trim().isEmpty()) {
                System.err.println("* Tên ca sĩ không được để trống");
            } else {
                return singerName;
            }
        } while (true);
    }

    //Nhap vao tuoi ca si
    public static int inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi ca sĩ: ");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if (age > 0) {
                return age;
            }
            else {
                System.err.println("Tuổi ca sĩ phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    //Nhap vao quoc tich ca si
    public static String inputNationality(Scanner scanner) {
        System.out.println("Mời nhập vào quốc tịch ca sĩ: ");
        do {
            String nationality = scanner.nextLine();
            if (nationality.trim().isEmpty()) {
                System.err.println("* Quốc tịch ca sĩ không được để trống");
            } else {
                return nationality;
            }
        } while (true);
    }

    //Nhap vao gioi tinh ca si
    public static boolean inputGender (Scanner scanner) {
        System.out.println("Mời nhập vào giới tính ca sĩ: ");
        do {
            String gender = scanner.nextLine();
            if (gender.equals("true") || gender.equals("false")) {
                return Boolean.parseBoolean(gender);
            } else {
                System.err.println("Giới tính ca sĩ chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        }
        while (true);
    }

    //Nhap vao the loai
    public static String inputGenre(Scanner scanner) {
        System.out.println("Mời nhập vào thể loại: ");
        do {
            String genre = scanner.nextLine();
            if (genre.trim().isEmpty()) {
                System.err.println("* Thể loại không được để trống");
            } else {
                return genre;
            }
        } while (true);
    }
}
