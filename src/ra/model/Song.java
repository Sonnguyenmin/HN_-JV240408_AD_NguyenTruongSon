package ra.model;

import ra.run.MusicManagement;
import ra.service.SingerService;
import ra.service.SongService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    //Khoi tao cac thuoc tinh
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    //Goi cac phuong thuc
    //Constructor Khong tham so
    public Song() {

    }
    //Constructor co tham so

    public Song(String songId, String songName, String description, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    //Cac phuong thuc getter/setter


    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    //Khoi tao phuong thuc inputData Cho phep nhap vao du lieu
    public void inputData(Scanner scanner) {
        this.songId = SongService.inputSongId(scanner);
        this.songName = SongService.inputSongName(scanner);
        this.description = SongService.inputDescription(scanner);
        this.singer = SongService.inputSinger(scanner);
        this.songWriter = SongService.inputSongWriter(scanner);
        this.createdDate = new Date();
        this.songStatus = SongService.inputSongStatus(scanner);
    }


    //Khoi tao phuong thuc displayData Cho phep hien thi thong tin
    public void displayData() {

        System.out.printf("Ma bai hat: %s - Ten bai hat: %s - Ca si: %s - Nguoi sang tac: %s \n",
                this.songId , this.songName, this.singer.getSingerName() , this.songWriter);
        System.out.printf("Mo ta bai hat: %s \n", this.description);
        System.out.printf("Ngay tao: %s - Trang thai: %s \n", this.createdDate, this.songStatus);
        System.out.println("------------------------------------------------------------------------------");
    }
}
