package Stack;

/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/21
 * @Content:
 */

import java.net.Inet4Address;
import java.util.Stack;

/**
 *
 *
 * 两个栈实现一个队列
 *
 * 入队：都指定入队到第一个栈中
 * 出队：1.判断第二个栈（s2）中是否有元素
 * 2.如果没有，判断第一个栈（s1）中是否有元素   s1有，把s1中的元素全部倒入s2 出s2的栈顶元素
 * 3.如果没有，判断第一个栈（s1）中是否有元素   s1没有，队列为空
 * 4.如果s2有元素，直接出s2的栈顶元素
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if(empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public int peek(){
        if(empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public boolean empty(){
        if(stack1.empty() && stack2.empty()){
            return true;
        }
        return false;
    }
}
