package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Path = /home/gabriel/IdeaProjects/BathroomStalls/src/com/company/input.txt

        List<Long> caseValues = new ArrayList<>();

        Scanner pathReader = new Scanner(System.in);

        Path filePath = Paths.get(pathReader.nextLine());

        try {
            Scanner scanner = new Scanner(filePath);
            while (scanner.hasNext()) {
                if (scanner.hasNextLong()) {
                    caseValues.add(scanner.nextLong());
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Scanner sc = new Scanner(System.in);
        //System.out.println("Number of cases?");

        //int numberOfCases = sc.nextInt();
        long numberOfCases = caseValues.get(0);
        long counterStalls=1;
        long counterPeople=2;
        long caseNumber = 1;

        while (caseNumber < numberOfCases){


            long firstStall = 1;
            long lastStall;

            //System.out.println("How many bathroom stalls?");
            long numberOfStalls = caseValues.get((int) counterStalls);
            lastStall = numberOfStalls+2;
            counterStalls=counterStalls+2;

            //System.out.println("How many people?");
            long numberOfPeople = caseValues.get((int) counterPeople);
            counterPeople=counterPeople+2;

            while (numberOfPeople>0){

                long middlePos;
                numberOfPeople--;

                if (numberOfPeople==0){

                    middlePos = (long) Math.ceil((firstStall + lastStall)/2.0);
                    //System.out.println("L  /  R");
                    long Ls = middlePos-(firstStall+1);
                    long Rs;
                    if (lastStall == middlePos){Rs = (lastStall)-middlePos;}
                    else{Rs = (lastStall-1)-middlePos;}

                    System.out.println("Case #"+ caseNumber +":"+ Ls +"  "+Rs);

                }
                else {
                    middlePos = (long) Math.ceil((firstStall + lastStall)/2);
                }

                firstStall = middlePos;

            }
            numberOfCases--;
            caseNumber++;
        }
    }
}