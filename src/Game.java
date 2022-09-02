import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Computer computer = new Computer();
    Person person = new Person();
    private String ComputerName;
    private int PersonScore = 0;
    private int ComputerScore = 0;

    public String getComputerName() {
        return ComputerName;
    }

    public void setComputerName(String computerName) {
        ComputerName = computerName;
    }

    public void initial() {
        System.out.println("--------------------欢迎进入游戏世界--------------------");
        System.out.println("                 ******************");
        System.out.println("                 *****猜拳，开始*****");
        System.out.println("                 ******************");
        System.out.println("出拳规则:1.剪刀 2.石头 3.布");
        System.out.print("请选择对方角色（1.刘备 2.孙权 3.曹操）: ");
        setComputerName(scan.next());
        switch (getComputerName()) {
            case "1":
                setComputerName("刘备");
                break;
            case "2":
                setComputerName("孙权");
                break;
            case "3":
                setComputerName("曹操");
                break;
        }
        System.out.print("请输入你的名字: ");
        person.setName(scan.next());
        System.out.println(person.getName() + " VS " + getComputerName());
    }

    public void startGame() {
        int Count = 0;
        while (Count < 3) {
            Count++;
            System.out.print("请出拳:1.剪刀 2.石头 3.布 (输入相应数字) : ");
            person.setShow(scan.nextInt());
            person.showFist();
            System.out.print(getComputerName());
            computer.showFist();
            if (person.getShow() == 1) {
                if (computer.getShow() == 1) {
                    System.out.println("平局");
                } else if (computer.getShow() == 2) {
                    ComputerScore++;
                    System.out.println("你输了");
                } else if (computer.getShow() == 3) {
                    PersonScore++;
                    System.out.println("你赢了");
                }
            } else if (person.getShow() == 2) {
                if (computer.getShow() == 2) {
                    System.out.println("平局");
                } else if (computer.getShow() == 3) {
                    ComputerScore++;
                    System.out.println("你输了");
                } else if (computer.getShow() == 1) {
                    PersonScore++;
                    System.out.println("你赢了");
                }
            } else if (person.getShow() == 3) {
                if (computer.getShow() == 3) {
                    System.out.println("平局");
                } else if (computer.getShow() == 1) {
                    ComputerScore++;
                    System.out.println("你输了");
                } else if (computer.getShow() == 2) {
                    PersonScore++;
                    System.out.println("你赢了");
                }
            }
        }
    }

    public void showResult() {
        System.out.println(person.getName() + "得分：" + PersonScore);
        System.out.println(getComputerName() + "得分：" + ComputerScore);
        if (PersonScore > ComputerScore) {
            System.out.println("你赢了 :)");
        } else if (PersonScore < ComputerScore) {
            System.out.println("你输了 :(");
        } else {
            System.out.println("平局 =-=");
        }
    }
}
