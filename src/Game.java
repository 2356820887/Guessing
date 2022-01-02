import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Computer computer = new Computer();
    Person person = new Person();
    public void initial(){
        Person person = new Person();
        Computer computer = new Computer();
        System.out.print("请出拳:1.剪刀 2.石头 3.布 (输入相应数字) : ");
        person.setShow(scan.nextInt());
        person.showFist();
        computer.showFist();
    }
    public void startGame(){
        System.out.println("--------------------欢迎进入游戏世界--------------------");
        System.out.println("                 ******************");
        System.out.println("                 *****猜拳,开始******");
        System.out.println("                 ******************");
        System.out.println("出拳规则:1.剪刀 2.石头 3.布");
        System.out.print("请选择对方角色（1.刘备 2.孙权 3.曹操）: ");
        computer.setName(scan.nextInt());
        System.out.print("请输入你的名字: ");
        person.setName(scan.next());
        System.out.println(person.getName()+" VS "+computer.getName_());
    }
    public void showResult(){

    }
}
