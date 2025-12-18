import java.util.Scanner;

class CircularArray {
    private int[] arr;
    private int size;
    private int count;


    public CircularArray(int size) {
        this.size = size;
        this.arr = new int[size];
        this.count = 0;
    }


    private boolean isDuplicate(int value) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }


    public void add(int value) {
        if (count == size) {
            System.out.println("Array is full. Cannot add more elements.");
            return;
        }
        if (isDuplicate(value)) {
            System.out.println("Duplicate value not allowed: " + value);
            return;
        }
        arr[count] = value;
        count++;
        System.out.println("Added: " + value);
    }


    public void remove(int value) {
        if (count == 0) {
            System.out.println("Array is empty. Nothing to remove.");
            return;
        }

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Value not found: " + value);
            return;
        }


        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
        System.out.println("Removed: " + value);
    }


    public void display() {
        if (count == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Circular Array: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public void search(int value) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == value) {
                System.out.println("Value " + value + " found at index " + i);
                return;
            }
        }
        System.out.println("Value " + value + " not found.");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        CircularArray ca = new CircularArray(size);

        while (true) {
            System.out.println("\n1. Add\n2. Remove\n3. Display\n4. Search\n5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    ca.add(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to remove: ");
                    ca.remove(sc.nextInt());
                    break;
                case 3:
                    ca.display();
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    ca.search(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
