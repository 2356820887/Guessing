public class Computer {
    private final int show = (int)(Math.random()*3)+1;
    private int name;
    private String name_;
    public int getName() {
        return name;
    }
    public void setName(int name) {
        this.name = name;
    }
    public String getName_() {
        if (getName() == 1){
            setName_("刘备");
        } else if (getName() == 2) {
            setName_("孙权");
        } else if (getName() == 3) {
            setName_("曹操");
        }
        return name_;
    }
    public void setName_(String name_) {
        this.name_ = name_;
    }
    public void showFist(){
        System.out.print(this.name_+"出拳: ");
        if (show == 1) {
            System.out.println("剪刀");
        } else if (show == 2) {
            System.out.println("石头");
        } else if (show == 3) {
            System.out.println("布");
        }
    }
}
