package AbstractFactoryFurniture;

public class RococoFactory implements Furniture{
    @Override
    public Chair createChair() {
        return new RococoChair();
    }

    @Override
    public Table createTable() {
        return new RococoTable();
    }
}
