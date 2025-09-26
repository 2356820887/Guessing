public class StartGuess {
    public static void main(String[] args){
        Game game = new Game();
        // 调用重构后的主游戏方法，该方法包含了所有逻辑
        game.play();
    }
}