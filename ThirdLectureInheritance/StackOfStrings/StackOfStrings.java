package ThirdLectureInheritance.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings{
    private ArrayList<String> data;

    public StackOfStrings(ArrayList<String> data) {
        this.data = data;
    }

    public void push (String text){
        this.data.add(text);
    }

    public String  peek (){
        return this.data.get(this.data.size() - 1);
    }

    public String pop(){
        return this.data.remove(this.data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
