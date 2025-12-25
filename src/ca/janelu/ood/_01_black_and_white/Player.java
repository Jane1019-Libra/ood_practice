package ca.janelu.ood._01_black_and_white;

public class Player {
    private String name;
    private GridType gridType;

    public Player(String name, GridType gridType) {
        this.name = name;
        this.gridType = gridType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GridType getGridType() {
        return gridType;
    }

    public void setGridType(GridType gridType) {
        this.gridType = gridType;
    }
}
