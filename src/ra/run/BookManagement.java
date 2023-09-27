package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    static Book[] arrBooks = new Book[100];
    static int currentIndex = 0;
    static Scanner scanner = new Scanner(System.in);
    static int idBook = 1;

    public static void main(String[] args) {
        int choice;


        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1.Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2.Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3.Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4.Xóa sách theo mã sách");
            System.out.println("5 .Tìm kiếm tương đối sách theo tên sách ");
            System.out.println("6.Thay đổi thông tin sách theo mã sách  ");
            System.out.println("7.Thoát");

            System.out.println("Nhập vào lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    BookManagement.createBook();
                    break;

                case 2:
                    BookManagement.displayBook();
                    break;

                case 3:
                    BookManagement.sortBook();
                    break;

                case 4:
                      BookManagement.deleteBook();
                    break;
                case 5:
                    BookManagement.searchBook();
                    break;
                case 6:
                    BookManagement.updateBook();
                    break;
                case 7:
                    System.out.println("Thoát chương trình: ");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 7);

    }


    public static void createBook() {

        System.out.print("Nhập số n lượng sách: ");
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            arrBooks[i] = new Book();
            arrBooks[i].inputData(scanner, arrBooks);
            currentIndex++;
            int idNew = idBook++;
            arrBooks[i].setBookId(idNew);

        }

    }

    public static void displayBook() {
        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].displayData();
        }
    }

    public static void sortBook() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrBooks[i].getInterest() < arrBooks[j].getInterest()) {
                    Book temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("Dach sách sách đc sắp xếp theo lợi nhuận tăng dần là : ");


        for (int i = 0; i < currentIndex; i++) {
            arrBooks[i].calProfit();
            System.out.printf("Tên sách: %s - lợi nhuận: %f%n", arrBooks[i].getBooName(), arrBooks[i].getInterest());
        }
    }

    public static void deleteBook() {

        System.out.print("Nhập mã sách cần xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        int indexBookDelete = -1;

        for (int i = 0; i < currentIndex; i++) {
           if(arrBooks[i].getBookId() ==idDelete){

               indexBookDelete=i;
               break;
           }
        }
        if(indexBookDelete>=0){
            for (int i =indexBookDelete ; i <currentIndex ; i++) {
                   arrBooks[i] = arrBooks[i+1];

            }
            arrBooks[arrBooks.length-1]=null;
        }else {
            System.out.println("ko tìm thấy sách cần xóa !!");
        }

    }

    public static void searchBook() {

        System.out.println("Nhập tên sách cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (arrBooks[i].getBooName().contains(searchName)) {
                arrBooks[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên: " + searchName);
        }
    }
    public  static  void updateBook() {

        System.out.print("Nhập mã sách cần cập nhập lại thông tin: ");
        int idBookUpdate = Integer.parseInt(scanner.nextLine());
        int foundBookToUpdate = -1;


        for (int i = 0; i < currentIndex; i++) {
            if (arrBooks[i].getBookId() ==idBookUpdate) {
                foundBookToUpdate=i;

                break;
            }
        }
        if (foundBookToUpdate >=0) {
            arrBooks[foundBookToUpdate].inputData(scanner, arrBooks);
        }else {
            System.out.println("ko tìm thấy mã sách cần update");
        }
    }

}
