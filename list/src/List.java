
import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class List {

    public static void main(String[] args) {
        LinkedList<String> toDoList = new LinkedList<>();
        LinkedList<String> completedTasks = new LinkedList<>();
        Stack<String> undoStack = new Stack<>();

        while (true) {
            String[] options = {"ADD TASK", "MARK TASK AS DONE", "UNDO", "VIEW TO-DO LIST", "COMPLETED TASK", "EXIT"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:",
                    "To-Do List Manager",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            
            if (choice == -1) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }

            switch (choice) {
                case 0: 
                    String task = JOptionPane.showInputDialog("Enter a new task:");
                    if (task != null && !task.trim().isEmpty()) {
                        toDoList.add(task);
                        undoStack.push("add:" + task);
                        JOptionPane.showMessageDialog(null, "Task added: " + task);
                    } else {
                        JOptionPane.showMessageDialog(null, "Task description cannot be empty.");
                    }
                    break;

                case 1: 
                    if (toDoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No tasks to mark as done.");
                    } else {
                        StringBuilder listDisplay = new StringBuilder("To-Do List:\n");
                        for (int i = 0; i < toDoList.size(); i++) {
                            listDisplay.append((i + 1)).append(". ").append(toDoList.get(i)).append("\n");
                        }
                        String input = JOptionPane.showInputDialog(listDisplay.toString() + "Enter the task number to mark as done:");
                        try {
                            int taskNumber = Integer.parseInt(input);
                            if (taskNumber >= 1 && taskNumber <= toDoList.size()) {
                                String selectedTask = toDoList.remove(taskNumber - 1);
                                completedTasks.add(selectedTask);
                                undoStack.push("done:" + selectedTask);
                                JOptionPane.showMessageDialog(null, "Task marked as done: " + selectedTask);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        }
                    }
                    break;

                case 2: 
                    if (undoStack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No actions to undo.");
                    } else {
                        String lastAction = undoStack.pop();
                        if (lastAction.startsWith("add:")) {
                            String lastAddedTask = lastAction.substring(4);
                            toDoList.removeLastOccurrence(lastAddedTask);
                            JOptionPane.showMessageDialog(null, "Undo add task: " + lastAddedTask);
                        } else if (lastAction.startsWith("done:")) {
                            String lastCompletedTask = lastAction.substring(5);
                            completedTasks.removeLastOccurrence(lastCompletedTask);
                            toDoList.add(lastCompletedTask);
                            JOptionPane.showMessageDialog(null, "Undo mark as done: " + lastCompletedTask);
                        }
                    }
                    break;

                case 3: 
                    if (toDoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "To-Do List is empty.");
                    } else {
                        StringBuilder toDoDisplay = new StringBuilder("To-Do List:\n");
                        for (int i = 0; i < toDoList.size(); i++) {
                            toDoDisplay.append((i + 1)).append(". ").append(toDoList.get(i)).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, toDoDisplay.toString());
                    }
                    break;

                case 4: 
                    if (completedTasks.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No completed tasks.");
                    } else {
                        StringBuilder completedDisplay = new StringBuilder("Completed Tasks:\n");
                        for (int i = 0; i < completedTasks.size(); i++) {
                            completedDisplay.append((i + 1)).append(". ").append(completedTasks.get(i)).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, completedDisplay.toString());
                    }
                    break;

                case 5: 
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
  
//
//MEMBERS: 
//-HINOYOG
//-SALES
//-ONGCOL