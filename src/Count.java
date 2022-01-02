public class Count {
    public int counter(String inputs,String word){
        int sum = 0;
        int length = word.length();
        while (inputs.contains(word)) {
            int index = inputs.indexOf(word);
            inputs = inputs.substring(index+length);
            sum++;
        }
        return sum;
    }
}
