package AbstractFactoryFurniture;

public class BarocoFactory implements Furniture{
    @Override
    public Chair createChair() {
        return new BarocoChair();
    }

    @Override
    public Table createTable() {
        return new BarocoTable();
    }
}
