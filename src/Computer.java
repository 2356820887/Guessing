public class Computer {
    private final int show = (int) (Math.random() * 3 + 1);

    public Computer() {
    }

    public int getShow() {
        return show;
    }

    public void showFist() {
        System.out.print("出拳: ");
        if (show == 1) {
            System.out.println("剪刀");
        } else if (show == 2) {
            System.out.println("石头");
        } else if (show == 3) {
            System.out.println("布");
        }
    }
}
