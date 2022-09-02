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
        System.out.print("你出拳: ");
        if (showFist == 1) {
            System.out.println("剪刀");
        } else if (showFist == 2) {
            System.out.println("石头");
        } else if (showFist == 3) {
            System.out.println("布");
        }
    }
}
