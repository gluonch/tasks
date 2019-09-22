package com.stasks.task6;

import com.stasks.output;

import java.util.ArrayList;

public class BagProblem implements output {
    private int[][] list;
    /*
       bagSize - вместимость рюкзака
       BagItem weight - вес
       BagItem cost - стоимость предметов
     */
    public int getBagVariations(int bagSize, ArrayList<BagItem> items) {
        int n = items.size();

        int[][] K = new int[n + 1][bagSize + 1];
        String[][] I = new String[n + 1][bagSize + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= bagSize; w++) {
                if (items.get(i - 1).weight <= w) {
                    K[i][w] = Math.max(items.get(i - 1).cost + K[i - 1][w - items.get(i - 1).weight], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }

            }
        }

        this.list = K;
        return K[n][bagSize];
    }
    private void printItems(int bagWeight, int res, ArrayList<BagItem> items){
        for(int i = items.size(); i > 0 && res > 0; i--){
            if(res != this.list[i-1][bagWeight]){
                res = res - items.get(i-1).cost;

                System.out.println("Название:" + items.get(i-1).name + "; Ценность: "+items.get(i-1).cost);
                bagWeight = bagWeight - items.get(i-1).weight;
            }
        }
    }
    @Override
    public void printTask() {
        ArrayList<BagItem> items = new ArrayList<>();
        items.add(new BagItem("Apple", 5, 10));
        items.add(new BagItem("Book", 15, 80));
        items.add(new BagItem("Orange", 10, 15));
        items.add(new BagItem("Laptop", 20, 130));
        items.add(new BagItem("Phone", 20, 75));

        int bagWeight = 40;
        int result = this.getBagVariations(bagWeight, items);
        System.out.println("Оптимальный набор вещей в рюкзаке:");
        System.out.println("---------------------------------");
        this.printItems(bagWeight, result, items);
        System.out.println("---------------------------------");
        System.out.println("Максимальная стоимость вещей в рюкзаке: " + result);
    }

    public static class BagItem {
        String name;
        int weight;
        int cost;

        BagItem(String name, int weight, int cost){
            this.name = name;
            this.weight = weight;
            this.cost = cost;
        }
    }
}

