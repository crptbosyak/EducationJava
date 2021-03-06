package basics.of.oop.flower_composition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlowerComposition {

    Flowers[] flowers;
    Scanner scanner = new Scanner(System.in);
    Package packaging;

    public FlowerComposition() {
    }

    @Override
    public String toString() {
        return "FlowerComposition{" +
                "flowers=" + Arrays.toString(flowers) +
                ", packaging=" + packaging +
                '}';
    }

    public FlowerComposition createComposition() {
        FlowerComposition composition = new FlowerComposition();
        System.out.println("enter count of Flowers");
        String choice;
        int count = scanner.nextInt();
        composition.flowers = new Flowers[count];
        for (int i = 0; i < composition.flowers.length; i++) {
            composition.flowers[i] = chooseFlower();


        }
        composition=choosePackage(composition);
        outPut(composition);
        return composition;

    }

    public FlowerComposition choosePackage(FlowerComposition composition) {
        boolean flag = true;
        System.out.println("Pls enter packaging:\nCraft, Cellophane or without");
        String choice = scanner.next();
        while (flag) {
            if (check(choice)) {

                if (choice.equals("Craft") | choice.equals("craft")) {
                    composition.packaging = Package.Craft;
                    break;
                }
                 if (choice.equals("Cellophane") | choice.equals("cellophane")) {
                    composition.packaging = Package.Cellophane;
                    break;
                }
                if (choice.equals("without") | choice.equals("Without")) {
                    composition.packaging = null;
                    break;
                }

                else {
                    System.out.println("Input Error");
                    continue;
                }
            } else {
                System.out.println("Input Error");
                continue;
            }
        }
        return composition;
    }

    public void outPut(FlowerComposition composition) {
        System.out.println(composition);
    }

    public boolean check(String s) {
        boolean check = true;
        Pattern pattern = Pattern.compile("\\W|\\d");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            check = false;
            System.out.println("Input Error");
        }


        return check;
    }

    public Flowers chooseFlower() {
        boolean flag = true;
        while (flag) {
            System.out.println("Pls enter flowers:\nRose, Camomile or Cactus");
            String choice = scanner.next();
            if (check(choice)) {

                if (choice.equals("rose") | choice.equals("Rose")) {
                    flag = false;
                    return new Rose();

                }
                if (choice.equals("cactus") | choice.equals("Cactus")) {
                    flag = false;
                    return new Cactus();

                }
                if (choice.equals("camomile") | choice.equals("Camomile")) {
                    flag = false;
                    return new Camomile();

                } else {
                    System.out.println("Input Error");
                    continue;
                }

            } else {

                System.out.println("Input Error");
                continue;

            }

        }

        return null;
    }
}



