package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SongService {
    public static Song[] arrSong = new Song[100];
    public static int indexSong = 0;

    //Case 1: Nhập vào số lượng bai hat cần thêm và nhập thông tin cần thêm mới
    public static void inputAddSong(Scanner scanner) {
        System.out.println("Nhập vào số bài hát cần nhập: ");
        int countSong = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSong; i++) {
            //Nhap thong tin cho bai hat co chi so index trong mang
            arrSong[indexSong] = new Song();
            arrSong[indexSong].inputData(scanner);
            indexSong++;
        }
    }

    //Case 2: Hiển thị danh sách tất cả bai hat đã lưu trữ
    public static void displayListSong() {
        for (int i = 0; i < indexSong; i++) {
            arrSong[i].displayData();
        }
    }

    //Lay vi tri id
    public static int getIndexBySongId(String songId) {
        for (int i = 0; i < indexSong; i++) {
            if(arrSong[i].getSongId().equals(songId)) {
                return i;
            }
        }
        return -1;
    }

    //Case 3: Thay đổi thông tin bai hat theo mã id
    public static void changInfoSong(Scanner scanner) {
        while (true) {
            System.out.println("Nhập ID bai hat muốn thay đổi thông tin: ");
            String changeId = scanner.nextLine();
            for (int i = 0; i < indexSong; i++) {
                if (arrSong[i].getSongId().equals(changeId)) {
                    arrSong[i].inputData(scanner);
                    return;
                }
            }
            System.err.println("Khong tim thay id bài hát");
        }
    }

    //Case 4: Xóa ca sĩ theo mã id
    public static void deleteSong(Scanner scanner) {
        System.out.println("Mời nhập vào bài hát cần xóa: ");
        String songId = scanner.nextLine();
        int indexDelete = getIndexBySongId(songId);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexSong; i++) {
                arrSong[i] = arrSong[i + 1];
            }
            indexSong--;
            System.out.println(" Đã xóa bài hát có ID:" + songId);
        }
        else  {
            System.err.println("Mã bài hát không tồn tại");
        }
    }

    //validate du lieu dau vao cua bai hat
    //Nhap ma bai hat
    public static String inputSongId(Scanner scanner) {
        String songIdRegex = "S\\w{3}";
        System.out.println("Mời nhập vào mã bài hát: ");
        do{
            String songId = scanner.nextLine();
            if (Pattern.matches(songIdRegex, songId)) {
                boolean isExist = false;
                for (int i = 0; i < indexSong; i++) {
                    if (arrSong[i].getSongId().equals(songId)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Mã bài hát đã tồn tại, vui lòng nhập lại");
                }
                else  {
                    return songId;
                }
            }
            else {
                System.err.println("Mã bài hát gồm 4 ký tự bắt đầu là S, vui lòng nhập lại");
            }
        } while (true);
    }

    //Nhap ten bai hat
    public static String inputSongName (Scanner scanner) {
        System.out.println("Mời nhập vào tên bài hát: ");
        do {
            String songName = scanner.nextLine();
            if (songName.trim().isEmpty()) {
                System.err.println("* Tên bài hát không được để trống ");
            }
            else  {
                return songName;
            }
        } while (true);
    }

    //Nhap vao mo ta
    public static String inputDescription (Scanner scanner) {
        System.out.println("Mời nhập vào mô tả bài hát");
        return scanner.nextLine();
    }

    // nhap singer
    public static Singer inputSinger (Scanner scanner) {
        System.out.println("Chọn ca sĩ của bài hát:");
        for (int i = 0; i < SingerService.indexSinger; i++) {
            System.out.printf("%d. %s\n", (i + 1), SingerService.arrSinger[i].getSingerName());
        }

        while (true) {
            System.out.print("Nhập số thứ tự ca sĩ: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= SingerService.indexSinger) {
                return SingerService.arrSinger[choice - 1];
            } else {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    //Nhap songWriter nguoi sang tac
    public static String inputSongWriter (Scanner scanner) {
        System.out.println("Mời nhập vào tên người sáng tác: ");
        do {
            String songWrite = scanner.nextLine();
            if (songWrite.trim().isEmpty()) {
                System.err.println("* Tên người sáng tác không được để trống ");
            }
            else  {
                return songWrite;
            }
        } while (true);
    }

    //Nhap trang thai bai hat
    public static boolean inputSongStatus (Scanner scanner) {
        System.out.println("Mời nhập vào trang thái bài hát: ");
        do {
            String songStatus = scanner.nextLine();
            if( songStatus.equals("true") || songStatus.equals("false")) {
                return Boolean.parseBoolean(songStatus);
            } else  {
                System.err.println("Trạng thái bài hát chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        } while (true);

    }
}
