package thanhpm.example;

import thanhpm.example.util.Canvas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("------Drawing program------");

        Scanner scanner = new Scanner(System.in);
        Canvas canvas = new Canvas();
        String choice;
        do{
            System.out.print("enter command:");
            String command = scanner.nextLine().trim();
            String[] words = command.split(" ");
            choice = words[0];
            switch (choice){
                case "C":
                    try {
                        int wight = Integer.parseInt(words[1]);
                        int height = Integer.parseInt(words[2]);
                        canvas.createCanvas(wight, height);
                    }catch (Exception ex){
                        System.out.println("error command");
                    }
                    break;
                case "L":
                    try{
                        int x1 = Integer.parseInt(words[1]);
                        int y1 = Integer.parseInt(words[2]);
                        int x2 = Integer.parseInt(words[3]);
                        int y2 = Integer.parseInt(words[4]);
                        canvas.createLine(x1, y1, x2, y2);
                    }catch (Exception ex){
//                        ex.printStackTrace();
                        System.out.println("error command");
                    }
                    break;
                case "R":
                    try{
                        int x1 = Integer.parseInt(words[1]);
                        int y1 = Integer.parseInt(words[2]);
                        int x2 = Integer.parseInt(words[3]);
                        int y2 = Integer.parseInt(words[4]);
                        canvas.createRectangle(x1, y1, x2, y2);
                    }catch (Exception ex){
                        System.out.println("error command");
                    }
                    break;
                case "B":
                    try {
                        int x1 = Integer.parseInt(words[1]);
                        int y1 = Integer.parseInt(words[2]);
                        char c = words[3].charAt(0);
                        canvas.fillColor(x1, y1, c);
                    }catch (Exception ex){
                        ex.printStackTrace();
                        System.out.println("error command");
                    }
                    break;
                case "Q":
                    break;
            }
        }while(!choice.equals("Q"));


    }
}
