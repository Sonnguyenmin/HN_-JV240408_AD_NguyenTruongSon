package ra.service;

import ra.model.Singer;

import java.util.Arrays;
import java.util.Scanner;

public class SearchService {
    // case 1: Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại
    public static void searchSong(Scanner scanner) {
        System.out.println("Nhập tên bài hát hoặc thể loại bài hát:");
        String inputSong = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < SongService.arrSong.length; i++) {
            if (SongService.arrSong[i] != null && (SongService.arrSong[i].getSongName().equalsIgnoreCase(inputSong)
                    || SongService.arrSong[i].getSinger().getGenre().equalsIgnoreCase(inputSong))) {
                SongService.arrSong[i].displayData();
                count++;
            }
        }
        if(count == 0) {
            System.err.println("Không có bài hát nào");
        }
        else {
            System.out.println("Có " + count + " Bài hát");
        }
    }

    //case 2: Tìm kiếm ca sĩ theo tên hoặc thể loại
    public static void searchSinger(Scanner scanner) {
        System.out.println("Nhập tên ca sĩ hoặc thể loại: ");
        String inputSinger = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < SingerService.arrSinger.length; i++) {
            if (SingerService.arrSinger[i] != null && (SingerService.arrSinger[i].getSingerName().equalsIgnoreCase(inputSinger)
                    || SingerService.arrSinger[i].getGenre().equalsIgnoreCase(inputSinger))) {
                SingerService.arrSinger[i].displayData();
                count++;
            }
        }
        if(count == 0) {
            System.err.println("Không có ca sĩ nào");
        }
        else {
            System.out.println("Có " + count + " ca sĩ");
        }
    }

    //case 3: Hiển thị danh sách bài hát theo thứ tự tên tăng dần
    public static void sortAscendingSong() {
        for(int i = 0; i < SingerService.arrSinger.length;i++){
            for(int j = i+1; j < SingerService.arrSinger.length;j++){
                if(SingerService.arrSinger[i].getSingerName().compareTo(SingerService.arrSinger[j].getSingerName())>0){
                    Singer temp = SingerService.arrSinger[i];
                    SingerService.arrSinger[i] = SingerService.arrSinger[j];
                    SingerService.arrSinger[j] = temp;
                }
            }
        }

        System.out.println("Đã sắp xếp xong bài hát theo thứ tự tăng dần");
    }

    //case 4: Hiển thị 10 bài hát được đăng mới nhất
    public static void displayLatestSongs(Scanner scanner) {
        int count = 0;
        System.out.println("List 10 Newest Song.");
        for (int i = SongService.arrSong.length - 1; i >= 0; i--) {
            SongService.arrSong[i].displayData();
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}
