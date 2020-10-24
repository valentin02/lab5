package ua.politeh;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Minfin minfin = new Minfin();
        String API;
        // https://developers.minfin.com.ua/registration/
        // only 10 requests for one API key
        API = "5896bcd083708cd767ab67c8449ff5cdd89ba4de";
        //API = "8ba46a60ae6dc224f9dc29778990ecbe45bbcb6f";
        //API = "04ff7968c342cc04b266199980c36e239a38855d";
        //API = "2aaa2b607434459d3a61be7410a4e79a4ff71531";

        minfin.run("https://api.minfin.com.ua/mb/" + API + "/");
        while (true) {
            System.out.println("Enter number from the list: \n" +
                    " 1 -> Sort by USD\n" +
                    " 2 -> Sort by RUB\n" +
                    " 3 -> Sort by EUR\n" +
                    " 4 -> Sort rates by name of currency from A to Z \n" +
                    " 5 -> Sort rates by name of currency from Z to A\n" +
                    " 6 -> Sort rates by ID from low to high\n" +
                    " 7 -> Sort rates by ID from high to low\n" +
                    " 0 -> Exit");
            switch (checkNum()) {
                case 1:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort by USD");
                    System.out.println(minfin.filterByCurrency("usd").toString());
                    break;
                case 2:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort by RUB");
                    System.out.println(minfin.filterByCurrency("rub").toString());
                    break;
                case 3:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort by EUR");
                    System.out.println(minfin.filterByCurrency("eur").toString());
                    break;
                case 4:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort rates by name of currency from A to Z");
                    minfin.getMinfin().sort(Currency.byNameAsc);
                    System.out.println(minfin.toString());
                    break;
                case 5:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort rates by name of currency from Z to A");
                    minfin.getMinfin().sort(Currency.byNameDesc);
                    System.out.println(minfin.toString());
                    break;
                case 6:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort rates by ID from low to high");
                    minfin.getMinfin().sort(Currency.byIdAsc);
                    System.out.println(minfin.toString());
                    break;
                case 7:
                    System.out.println(minfin.toString());
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    System.out.println("Sort rates by ID from high to low");
                    minfin.getMinfin().sort(Currency.byIdDesc);
                    System.out.println(minfin.toString());
                    break;
                case 0:
                    return;
            }
        }

    }

    static int checkNum() {
        while (true) {
            String s = in.nextLine();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again!");
            }
        }
    }
}
