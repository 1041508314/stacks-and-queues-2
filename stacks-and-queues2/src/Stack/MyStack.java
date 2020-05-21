package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/21
 * @Content:
 */

/**
 *
 * 用两个队列实现栈
 *
 * 入栈：1.哪个队列不为空，就将元素放到哪个队列当中
 * 2.如果两个队列都为空，那么放到第一个队列当中
 *
 *
 * 出栈：0.判断栈是否为空 --> 两个队列是否都是空的
 * 1.出不为空的哪个队列
 * 2.n个元素的话，出n-1个到另外的队列去
 */
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        if(queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }


    public int pop(){
        if(empty()){
            return -1;
        }
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        int data = 0;
        if(!queue1.isEmpty()){
            for (int i = 0; i < qSize1 - 1; i++) {
                queue2.offer(queue1.poll());
            }
            data = queue1.poll();
        }else{
            for (int i = 0; i < qSize2 - 1; i++) {
                queue1.offer(queue2.poll());
            }
            data = queue2.poll();
        }
        return data;
    }


    public int top(){
        if(empty()){
            return -1;
        }
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        int data = 0;
        if(!queue1.isEmpty()){
            for (int i = 0; i < qSize1 ; i++) {
                data = queue1.poll();
                queue2.offer(data);
            }
        }else{
            for (int i = 0; i < qSize2 ; i++) {
                data = queue2.poll();
                queue1.offer(data);
            }
        }
        return data;
    }

    public boolean empty(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}
