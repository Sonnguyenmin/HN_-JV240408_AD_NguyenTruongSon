package ra.model;

import ra.service.SingerService;

import java.util.Scanner;

public class Singer {
    //Khoi tao cac thuoc tinh
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    //Goi cac phuong thuc
    //Constructor Khong tham so

    public Singer() {
    }

    //Constructor co tham so

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }


    //Cac phuong thuc getter/setter

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Khoi tao phuong thuc inputData Cho phep nhap vao du lieu
    public void inputData(Scanner scanner) {
        this.singerId = SingerService.inputSingerId();
        this.singerName = SingerService.inputSingerName(scanner);
        this.age = SingerService.inputAge(scanner);
        this.nationality = SingerService.inputNationality(scanner);
        this.gender = SingerService.inputGender(scanner);
        this.genre = SingerService.inputGenre(scanner);
    }

    public void updateData(Scanner scanner) {
        this.singerName = SingerService.inputSingerName(scanner);
        this.age = SingerService.inputAge(scanner);
        this.nationality = SingerService.inputNationality(scanner);
        this.gender = SingerService.inputGender(scanner);
        this.genre = SingerService.inputGenre(scanner);
    }

    //Khoi tao phuong thuc displayData Cho phep hien thi thong tin
    public void displayData() {
        System.out.printf("Ma ca si: %d - Ten ca si: %s - Tuoi ca si: %d \n", this.singerId, this.singerName, this.age);
        System.out.printf("Quoc tich: %s - Gioi tinh: %s - The loai: %s \n", this.nationality, this.gender?"Nam":"Nữ", this.genre );
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
