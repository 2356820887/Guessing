public class Computer {
    private int showFist;

    public Computer() {
    }

    public int getShow() {
        // 每次调用时都生成一个新的随机拳法
        this.showFist = (int) (Math.random() * 3 + 1);
        return showFist;
    }

    public void showFist() {
        System.out.print("出拳: " + getFistName(this.showFist));
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
