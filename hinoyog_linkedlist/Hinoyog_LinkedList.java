
package hinoyog_linkedlist;

import java.util.LinkedList;
public class Hinoyog_LinkedList {

    public static void main(String[] args) {
        LinkedList<String> creatures = new LinkedList<>();
        
        creatures.add("Dragon");
        creatures.addFirst("Wyvern");
        creatures.addLast("Tikbalang");
        creatures.add(1, "Goblin");
        
        
        System.out.println("Linked List Original: " + creatures);
        System.out.println(creatures.size());
        
        if (creatures.contains("Dragon")) {
            System.out.println("Hatdog");
        } else {
            System.out.println("False");
        }

        boolean containsDragon = creatures.contains("Lion");
        System.out.println(containsDragon);

    }
    
}
