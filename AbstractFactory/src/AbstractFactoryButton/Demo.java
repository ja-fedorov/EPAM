package AbstractFactoryButton;

import java.util.Scanner;

public class Demo {


    private static Application configureApplication() {

        Application app;
        GUIFactory factory = null;

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();

        String osName = System.getProperty("os.name").toLowerCase(); // getProperty ("os.name") - это ключ к значению операционной системы
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        }
        if (osName.contains("windows")) {
            factory = new WindowsFactory();
        }
        if (osName.contains("linux")){
            factory = new LinuxFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

}
