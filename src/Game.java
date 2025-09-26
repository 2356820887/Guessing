import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Scanner scan = new Scanner(System.in);
    private final Computer computer = new Computer();
    private final Person person = new Person();
    private String computerName;
    private int personScore;
    private int computerScore;

    /**
     * 游戏的主入口，控制整体流程，包括是否重复游戏。
     */
    public void play() {
        boolean playAgain = true;
        welcomeMessage(); // Show welcome message once.

        while (playAgain) {
            initial();
            int rounds = askForRounds();
            startGame(rounds);
            showResult();

            System.out.print("\n是否要再玩一局？ (y/n): ");
            String choice = scan.next();
            playAgain = choice.equalsIgnoreCase("y");
            System.out.println();
        }
        System.out.println("感谢您的游玩，再见！");
    }

    /**
     * 显示一次性的欢迎信息。
     */
    private void welcomeMessage() {
        System.out.println("--------------------欢迎进入游戏世界--------------------");
        System.out.println("                 ******************");
        System.out.println("                 *****猜拳，开始*****");
        System.out.println("                 ******************");
    }

    /**
     * 初始化一局新游戏，包括重置分数和设置玩家信息。
     */
    public void initial() {
        this.personScore = 0;
        this.computerScore = 0;

        System.out.print("请输入你的名字: ");
        person.setName(scan.next());

        System.out.print("请选择对方角色（1.刘备 2.孙权 3.曹操）: ");
        int choice = getValidIntInput(1, 3);
        switch (choice) {
            case 1:
                this.computerName = "刘备";
                break;
            case 2:
                this.computerName = "孙权";
                break;
            case 3:
                this.computerName = "曹操";
                break;
        }
        System.out.println("你选择了 " + this.computerName + " 作为你的对手。");
        System.out.println(person.getName() + " VS " + this.computerName);
        System.out.println("----------------------------------------------------");
    }

    /**
     * 询问并获取用户想要进行的游戏局数。
     * @return 用户输入的有效局数。
     */
    public int askForRounds() {
        System.out.print("请输入您想玩几局: ");
        return getValidIntInput(1, Integer.MAX_VALUE); // 至少玩1局
    }

    /**
     * 开始进行指定局数的游戏。
     * @param rounds 要进行的游戏局数。
     */
    public void startGame(int rounds) {
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n--- 第 " + i + "/" + rounds + " 局 ---");
            System.out.print("请出拳: 1.剪刀 2.石头 3.布 (输入相应数字): ");
            int personFist = getValidIntInput(1, 3);
            person.setShow(personFist);

            int computerFist = computer.getShow();

            String personFistName = person.getFistName(personFist);
            String computerFistName = computer.getFistName(computerFist);

            System.out.println(person.getName() + " 出拳: " + personFistName);
            System.out.println(this.computerName + " 出拳: " + computerFistName);

            judgeRound(personFist, computerFist);
        }
    }

    /**
     * 判断单局的胜负，并更新分数。
     * @param personFist 玩家的出拳。
     * @param computerFist 电脑的出拳。
     */
    public void judgeRound(int personFist, int computerFist) {
        // 核心胜负算法: (玩家出拳 - 电脑出拳 + 3) % 3
        // 结果为 1 表示玩家赢，2 表示电脑赢，0 表示平局。
        int result = (personFist - computerFist + 3) % 3;
        if (result == 1) {
            System.out.println("结果: 恭喜，你赢了这一局!");
            personScore++;
        } else if (result == 2) {
            System.out.println("结果: 很遗憾，你输了这一局。");
            computerScore++;
        } else {
            System.out.println("结果: 双方出拳一致，平局!");
        }
    }

    /**
     * 显示最终的游戏结果和总得分。
     */
    public void showResult() {
        System.out.println("\n--------------------游戏结束--------------------");
        System.out.println("最终得分: " + person.getName() + " " + personScore + " VS " + computerScore + " " + this.computerName);
        if (personScore > computerScore) {
            System.out.println("恭喜你，最终你赢得了比赛！ :)");
        } else if (personScore < computerScore) {
            System.out.println("很遗憾，最终你输了。下次加油！ :(");
        } else {
            System.out.println("最终结果是平局！实力相当！ =-=");
        }
    }

    /**
     * 一个健壮的辅助方法，用于从用户处获取一个在指定范围内的有效整数输入。
     * @param min 允许的最小值。
     * @param max 允许的最大值。
     * @return 用户输入的有效整数。
     */
    private int getValidIntInput(int min, int max) {
        int choice = 0;
        while (true) {
            try {
                choice = scan.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.print("输入无效，请输入 " + min + " 到 " + max + " 之间的数字: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("输入错误，请输入一个有效的数字，而不是文本: ");
                scan.next(); // 清除缓冲区中的无效输入
            }
        }
        return choice;
    }
}