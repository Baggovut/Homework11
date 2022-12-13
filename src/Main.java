import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Задание 1
        int year;
        System.out.println("\033[4mЗадание 1\033[0m \nУкажите год: ");
        while(!scan.hasNextInt()){
                System.out.println("Введено недопустимое значение, попробуйте снова: ");
                scan.nextLine();
        }
        year=scan.nextInt();
        checkForLeapYear(year);

        //Задание 2
        byte clientOS;
        short telephoneReleaseDate;
        System.out.println("\033[4mЗадание 2\033[0m \nУкажите тип ОС (iOS - 0, Android - 1): ");
        while (true){
            while(!scan.hasNextByte()){
                System.out.println("Введено недопустимое значение, попробуйте снова: ");
                scan.nextLine();
            }
            clientOS=scan.nextByte();
            if (clientOS == 0 || clientOS == 1){
                break;
            }
            else{
                System.out.println("Значение должно быть 0 или 1");
                scan.nextLine();
            }
        }
        System.out.println("Введите год выпуска телефона: ");
        while(!scan.hasNextShort()){
            System.out.println("Введено недопустимое значение, попробуйте снова: ");
            scan.nextLine();
        }
        telephoneReleaseDate=scan.nextShort();

        programSelector(clientOS,telephoneReleaseDate);

        //Задача 3
        short deliveryDistance, deliveryPeriod;
        System.out.println("\033[4mЗадание 3\033[0m \nУкажите расстояние для доставки: ");
        while (true){
            while(!scan.hasNextShort()){
                System.out.println("Введено недопустимое значение, попробуйте снова: ");
                scan.nextLine();
            }
            deliveryDistance=scan.nextShort();
            if (deliveryDistance >= 0){
                break;
            }
            else{
                System.out.println("Значение должно быть больше или равно 0 ");
                scan.nextLine();
            }
        }
        deliveryPeriod = calculateDelivery(deliveryDistance);
        System.out.println("Потребуется дней: "+deliveryPeriod);

        scan.close();
    }

    public static void checkForLeapYear(int year){
        if(year%4 == 0 && (year%100 != 0 || year%400 == 0)){
            System.out.println(year+" — високосный год");
        }
        else{
            System.out.println(year+"  — не високосный год");
        }
    }

    public static void programSelector(byte clientOS, short telephoneReleaseDate){
        if(clientOS == 0 && telephoneReleaseDate >= 2015){
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if(clientOS == 0){
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if(clientOS == 1 && telephoneReleaseDate >= 2015){
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        else if(clientOS == 1){
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else{
            System.out.println("Неизвестная ОС");
        }
    }

    public static short calculateDelivery(short deliveryDistance){
        return (short)Math.ceil(1+(((float)deliveryDistance-20)/40));
    }
}