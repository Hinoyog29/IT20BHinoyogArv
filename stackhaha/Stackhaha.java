
package stackhaha;
import java.util.Stack;
public class Stackhaha {

    public static void main(String[] args) {
       Stack<String> Foods = new Stack<>();
       
      
        Foods.push("Proben");
        Foods.push("Puso");
        Foods.push("Kwek-kwek");

        System.out.println("Stack: " + Foods);
        
        String topElement = Foods.pop();
        System.out.println("Popped: " + topElement);
        
      
        String peekedElement = Foods.peek();
        System.out.println("Peeked: " + peekedElement);

  
        boolean isEmpty = Foods.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);


        int stackSize = Foods.size();
        System.out.println("Stack Size: " + stackSize);
    }
    
}
