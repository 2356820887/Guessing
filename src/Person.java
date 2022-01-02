public class Person {
    private int show;
    private String name;
    public int getShow() {
        return show;
    }
    public void setShow(int show) {
        this.show = show;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void showFist(){
        System.out.print("你出拳: ");
        if (show == 1) {
            System.out.println("剪刀");
        } else if (show == 2) {
            System.out.println("石头");
        } else if (show == 3) {
            System.out.println("布");
        }
    }
}
