package mod9.task4;

public class MyStackTest {
        public static void main(String[] args){
            MyStack S = new MyStack(20); //[] top=-1

            S.push(25); // [20] top =0
            S.push(35); // [20,35] top=1
            S.push(22); // [20,35,22] top=2

            System.out.println("Current Peek Value is : "+S.peek());

            S.size();


            S.push(99); // [20,35,22,99] top=3
            S.push(82); // [20,35,22,99,82] top=4

            S.pop(); // [20,35,22,99] top=3
            S.pop(); // [20,35,22,99] top=2

            while(!S.isEmpty()){
                System.out.println("Poped Element "+ S.pop());
            }
            S.clear();
            S.size();
            S.push(22);
            S.remove(2);
            S.size();
        }

    }
