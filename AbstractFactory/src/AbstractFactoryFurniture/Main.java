package AbstractFactoryFurniture;

import java.util.Scanner;

public class Main {


    private static Factory factoryGetResult() {
        Factory factory;
        Furniture furniture;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();

        if(s.contains("bar")){
            furniture = new BarocoFactory();
        }
        else {
            furniture = new RococoFactory();
        }
        factory = new Factory(furniture);

        return factory;
    }


    public static void main(String[] args) {
        System.out.println("Choose what style of furniture you want, i'll tell you what type we have");
        Factory factory = factoryGetResult();
        factory.methodInFactoryToShowWhatYouChoose();
    }
}
