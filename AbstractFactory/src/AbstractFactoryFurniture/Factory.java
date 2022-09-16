package AbstractFactoryFurniture;

public class Factory {

    private Chair chair;
    private Table table;

    public Factory(Furniture furniture) {
        chair = furniture.createChair();
        table = furniture.createTable();
    }

    public void methodInFactoryToShowWhatYouChoose() {
        chair.doSomeThing();
        table.doSomeThing();
    }

}
