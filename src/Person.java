public class Person {
    private int showFist;
    private String name;

    public Person() {
    }

    public int getShow() {
        return showFist;
    }

    public void setShow(int show) {
        this.showFist = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showFist() {
        System.out.print("你出拳: " + getFistName(this.showFist));
    }

    public String getFistName(int showFist) {
        switch (showFist) {
            case 1:
                return "剪刀";
            case 2:
                return "石头";
            case 3:
                return "布";
            default:
                return "未知出拳";
        }
    }
}
