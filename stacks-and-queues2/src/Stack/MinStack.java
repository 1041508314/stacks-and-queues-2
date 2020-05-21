package Stack;

/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/21
 * @Content:
 */


import java.util.Stack;

/**
 *
 * 最小栈
 * 需要两个栈 一个stack  一个minstack  minstack用来保存最小值
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.empty()){
            //最小栈内没有元素
            minStack.push(x);
        }else{
            //最小栈内有元素 拿到栈顶元素 但不删除 和x比较
            int top = minStack.peek();
            if(x <= top){
                minStack.push(x);
            }
        }
    }

    public void pop(){
        if(!stack.empty()){
            int tmp = stack.pop();
            if(tmp == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        if(stack.empty()){
           return -1;
        }
        return stack.peek();
    }

    public int getMin(){
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
