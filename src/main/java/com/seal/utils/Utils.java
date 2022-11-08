package com.seal.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author SEAL
 */
public class Utils {

    public static final DateTimeFormatter DAYTIMEFORMATYYYYMMDD = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"); //format cho Date
    public static final DateTimeFormatter DAYFORMATDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String message, int oldData) {
        String tmp;
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) { //neu khong nhap thi gan gtr cu
                    value = oldData;
                } else {
                    value = Integer.parseInt(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true);
        return value;
    }

    public static int getInt(String message, int min, int max, int oldData) {
        String tmp;
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) {//neu khong nhap thi gan gtr cu
                    value = oldData;
                } else {
                    value = Integer.parseInt(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }

    public static int getInt(String message, int min, int max) {
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                value = Integer.parseInt(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }

    public static int getInt(String message) {
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                value = Integer.parseInt(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true);
        return value;
    }

    public static double getDouble(String message, double min, double max) {
        double value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                value = Double.parseDouble(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }

    public static double getDouble(String message) {
        double value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                value = Double.parseDouble(sc.nextLine());
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true);
        return value;
    }

    public static double getDouble(String message, double min, double max, double oldData) {
        String tmp;
        double value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty() == true) {
                    return oldData;
                } else {
                    value = Double.parseDouble(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }

    public static String getString(String message) {
        String str;
        boolean cont = true;
        do {
            System.out.print(message);
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("Input text please!!!");
            } else {
                cont = false;
            }
        } while (cont == true);
        return str;
    }

    public static String getString(String message, String oldData) {
        String str;
        boolean cont = true;
        do {
            System.out.print(message);
            str = sc.nextLine();
            if (str.isEmpty()) {//neu khong nhap thi gan gtr cu
                str = oldData;
            }
            cont = false;
        } while (cont == true);
        return str;
    }

    public static String getEmail(String message) {
        String email;
        boolean cont = false;
        System.out.print(message);
        do {
            email = sc.nextLine();
            Pattern patternEmail = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"); //Regex ktra format email
            if (patternEmail.matcher(email).matches() == true) {
                cont = true;
            } else {
                System.out.print("Please retype correct email: ");
            }
        } while (cont == false);
        return email;
    }

    public static String getEmail(String message, String oldData) {
        String email;
        boolean cont = false;
        System.out.print(message);
        do {
            email = sc.nextLine();
            if (email.isEmpty()) {//neu khong nhap thi gan gtr cu
                email = oldData;
                cont = true;
            } else {
                Pattern patternEmail = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"); //Regex ktra format email
                if (patternEmail.matcher(email).matches() == true) {
                    cont = true;
                } else {
                    System.out.print("Please retype correct email: ");
                }
            }
        } while (cont == false);
        return email;
    }

    public static LocalDate getDate(String message) {
        LocalDate date;
        String tmp;
        boolean cont;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); //định dạng ngày theo cú pháp này
        format.setLenient(false);
        System.out.print(message + " in (" + ((SimpleDateFormat) format).toPattern() + ") format: "); //in ra mời nhập
        do {
            cont = true;
            tmp = sc.nextLine();
            Pattern patternDate = Pattern.compile("^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");  //Regex ktra format
            if (patternDate.matcher(tmp).matches() == true) { //Đúng format thì ktra đúng hay sai
                try {
                    format.parse(tmp);  //Ktra đúng hay sai
                } catch (ParseException e) {
                    System.out.println("Date " + tmp + " is not valid according to "
                            + ((SimpleDateFormat) format).toPattern() + " pattern.");   //Nếu sai báo lỗi
                    System.out.print("Please retype correct date: ");
                    cont = false;
                }
            } else {
                System.out.print("Please retype correct date: ");
                cont = false;
            }

        } while (cont == false);
        date = LocalDate.parse(tmp, DAYTIMEFORMATYYYYMMDD);
        return date;
    }

    public static LocalDate getDate(String message, LocalDate oldData) {
        LocalDate date;
        String tmp;
        boolean cont;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); //định dạng ngày theo cú pháp này
        format.setLenient(false);
        System.out.print(message + " in (" + ((SimpleDateFormat) format).toPattern() + ") format: "); //in ra mời nhập
        do {
            cont = true;
            tmp = sc.nextLine();
            if (tmp.isEmpty()) {
                date = oldData;
            } else {
                Pattern patternDate = Pattern.compile("^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");  //Regex ktra format
                if (patternDate.matcher(tmp).matches() == true) { //Đúng format thì ktra đúng hay sai
                    try {
                        format.parse(tmp);  //Ktra đúng hay sai
                    } catch (ParseException e) {
                        System.out.println("Date " + tmp + " is not valid according to "
                                + ((SimpleDateFormat) format).toPattern() + " pattern.");   //Nếu sai báo lỗi
                        System.out.print("Please retype correct date: ");
                        cont = false;
                    }
                } else {
                    System.out.print("Please retype correct date: ");
                    cont = false;
                }
            }
        } while (cont == false);
        date = LocalDate.parse(tmp, DAYTIMEFORMATYYYYMMDD);
        return date;
    }

    public static void showCandidateMenu() {
        System.out.println("===============================");
        System.out.println("Welcome to Candidate Management");
        System.out.println("===============================");
        System.out.println("Select your choice: ");
        System.out.println("1. Add candidate");
        System.out.println("2. Update by ID");
        System.out.println("3. Search by ID");
        System.out.println("4. Remove by ID");
        System.out.println("5. Display");
        System.out.println("6. Quit");
        System.out.println("===============================");
    }

    public static void showVehicleSubMenu() {
        System.out.println("Select vehicle type: ");
        System.out.println("1. Car");
        System.out.println("2. Motorbike");
    }

    public static void showMenu() {
        System.out.println("===============================");
        System.out.println("Welcome to Array Management");
        System.out.println("===============================");
        System.out.println("1. Enter elements");
        System.out.println("2. Display array");
        System.out.println("3. Sort array");
        System.out.println("4. Find index");
        System.out.println("5. Quit");
        System.out.println("===============================");
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static boolean confirmYesNo(String welcome, boolean oldData) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if (confirm.isEmpty()) {//neu khong nhap thi gan gtr cu
            result = oldData;
            return result;
        }
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
}

