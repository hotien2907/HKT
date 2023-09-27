package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String booName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookStatus = true;
    }

    public Book(int bookId, String booName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.booName = booName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBooName() {
        return booName;
    }

    public void setBooName(String booName) {
        this.booName = booName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner, Book[] arrBooks) {


        do {
            System.out.print("Tên sách: ");
            this.booName = scanner.nextLine();
            if (this.booName.trim().isEmpty()) {
                System.out.println("Tên sách không được để trống.");
            }
        } while (this.booName.trim().isEmpty());


        do {
            System.out.print("Tên Tác Giả: ");
            this.author = scanner.nextLine();
            if (this.author.trim().isEmpty()) {
                System.out.println("Tên Tác Giả không được để trống.");
            }
        } while (this.author.trim().isEmpty());

        boolean check = false;
        do {
            // Nhập mô tả
            System.out.print("Mô tả, ít nhất 10 ký tu: : ");
            this.descriptions = scanner.nextLine();

            if (!this.descriptions.trim().isEmpty()) {
                if (this.descriptions.length() >= 10) {
                    check = true;
                } else {
                    check = false;
                }

            } else {
                check = false;
            }
            if (!check) {
                System.out.println("Mô tả không đươc để trống, ít nhất có 10 ký tự.");
            }
        } while (!check);


        do {
            System.out.println("Giá nhập: ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (this.importPrice <= 0) {
                System.out.println("Giá nhập phải lớn hơn 0.");
            }

        } while (this.importPrice <= 0);

        do {
            System.out.println("Giá Xuất: ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (this.exportPrice <= 1.2 * this.importPrice) {
                System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập");
            }

        } while (this.exportPrice <= 1.2 * this.importPrice);
        // Trạng thái
        System.out.print("Trạng thái (true: đang bán, false: hết bán): ");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public void displayData() {
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.booName);
        System.out.println("Tác giả: " + this.author);

        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);


        System.out.println("Trạng thái: " + (this.bookStatus ? "Đang bán" : "Không bán"));
        System.out.println("------------------------------");
    }

    public void calProfit() {
        this.interest = (float) (this.exportPrice - this.importPrice);

    }


}
