import java.util.Scanner;

class Dictionary {
   private Node root;

   public Dictionary() {
      root = null;
   }

   // Add a new record to the dictionary
   public void add(int key, String firstName, String lastName, String address, String city, String state, String zip,
                   String email, String phoneNumber) {
      root = addNode(root, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
      System.out.println("Data added successfully.");
   }

   // Recursive method to add a new node
   private Node addNode(Node root, int key, String firstName, String lastName, String address, String city,
                        String state, String zip, String email, String phoneNumber) {
      if (root == null) {
         root = new Node(key, firstName, lastName, address, city, state, zip, email, phoneNumber);
         return root;
      }
   
      if (key < root.key)
         root.left = addNode(root.left, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
      else if (key > root.key)
         root.right = addNode(root.right, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
   
      return root;
   }

   // Delete a record from the dictionary
   public void delete(int key) {
      root = deleteNode(root, key);
   }

   // Recursive method to delete a node
   private Node deleteNode(Node root, int key) {
      if (root == null)
         return root;
   
      if (key < root.key)
         root.left = deleteNode(root.left, key);
      else if (key > root.key)
         root.right = deleteNode(root.right, key);
      else {
         if (root.left == null)
            return root.right;
         else if (root.right == null)
            return root.left;
      
         // If the node to be deleted has two children,
         // find the minimum value in the right subtree
         // and replace the node's key with that value
         root.key = minValue(root.right);
         root.right = deleteNode(root.right, root.key);
      }
      return root;
   }

   // Find the minimum value in a subtree (used for deleting a node with two children)
   private int minValue(Node root) {
      int minv = root.key;
      while (root.left != null) {
         minv = root.left.key;
         root = root.left;
      }
      return minv;
   }

   // Modify an existing record in the dictionary
   public void modify(int key) {
      Node node = searchNode(root, key);
      if (node == null) {
         System.out.println("Record not found.");
         return;
      }
   
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter first name: ");
      node.firstName = scanner.nextLine();
      System.out.print("Enter last name: ");
      node.lastName = scanner.nextLine();
      System.out.print("Enter address: ");
      node.address = scanner.nextLine();
      System.out.print("Enter city: ");
      node.city = scanner.nextLine();
      System.out.print("Enter state: ");
      node.state = scanner.nextLine();
      System.out.print("Enter zip: ");
      node.zip = scanner.nextLine();
      System.out.print("Enter email: ");
      node.email = scanner.nextLine();
      System.out.print("Enter phone number: ");
      node.phoneNumber = scanner.nextLine();
      System.out.println("Record modified successfully.");
   }

   // Recursive method to search for a node
   private Node searchNode(Node root, int key) {
      if (root == null || root.key == key)
         return root;
   
      if (key < root.key)
         return searchNode(root.left, key);
   
      return searchNode(root.right, key);
   }

   // Lookup records in the dictionary using a specified traversal order
   public void lookup(int order) {
      switch (order) {
         case 1:
            preOrderTraversal(root);
            break;
         case 2:
            inOrderTraversal(root);
            break;
         case 3:
            postOrderTraversal(root);
            break;
         default:
            System.out.println("Invalid order.");
            break;
      }
   }

   // Perform pre-order traversal
   private void preOrderTraversal(Node root) {
      if (root != null) {
         printNode(root);
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   // Perform in-order traversal
   private void inOrderTraversal(Node root) {
      if (root != null) {
         inOrderTraversal(root.left);
         printNode(root);
         inOrderTraversal(root.right);
      }
   }

   // Perform post-order traversal
   private void postOrderTraversal(Node root) {
      if (root != null) {
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         printNode(root);
      }
   }

   // Print the details of a node
   private void printNode(Node node) {
      System.out.println("Key: " + node.key);
      System.out.println("First Name: " + node.firstName);
      System.out.println("Last Name: " + node.lastName);
      System.out.println("Address: " + node.address);
      System.out.println("City: " + node.city);
      System.out.println("State: " + node.state);
      System.out.println("Zip: " + node.zip);
      System.out.println("Email: " + node.email);
      System.out.println("Phone Number: " + node.phoneNumber);
      System.out.println("-------------------------");
   }

   // Count the number of records in the dictionary
   public int countRecords() {
      return countNodes(root);
   }

   // Recursive method to count the number of nodes in the BST
   private int countNodes(Node root) {
      if (root == null)
         return 0;
   
      return 1 + countNodes(root.left) + countNodes(root.right);
   }

   public static void main(String[] args) {
      Dictionary dictionary = new Dictionary();
      Scanner scanner = new Scanner(System.in);
   
      while (true) {
         System.out.println("********************");
         System.out.println("** Employee Lookup **");
         System.out.println("********************");
         System.out.println("1. Add Record");
         System.out.println("2. Delete Record");
         System.out.println("3. Modify Record");
         System.out.println("4. Lookup Records");
         System.out.println("5. List Number of Records");
         System.out.println("6. Exit");
         System.out.println("********************");
      
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
      
         switch (choice) {
            case 1:
               System.out.print("Enter key: ");
               int key = scanner.nextInt();
               scanner.nextLine();
               System.out.print("Enter first name: ");
               String firstName = scanner.nextLine();
               System.out.print("Enter last name: ");
               String lastName = scanner.nextLine();
               System.out.print("Enter address: ");
               String address = scanner.nextLine();
               System.out.print("Enter city: ");
               String city = scanner.nextLine();
               System.out.print("Enter state: ");
               String state = scanner.nextLine();
               System.out.print("Enter zip: ");
               String zip = scanner.nextLine();
               System.out.print("Enter email: ");
               String email = scanner.nextLine();
               System.out.print("Enter phone number: ");
               String phoneNumber = scanner.nextLine();
               dictionary.add(key, firstName, lastName, address, city, state, zip, email, phoneNumber);
               break;
            case 2:
               System.out.print("Enter key of the record to delete: ");
               int deleteKey = scanner.nextInt();
               dictionary.delete(deleteKey);
               break;
            case 3:
               System.out.print("Enter key of the record to modify: ");
               int modifyKey = scanner.nextInt();
               dictionary.modify(modifyKey);
               break;
            case 4:
               System.out.println("1. Pre-order");
               System.out.println("2. In-order");
               System.out.println("3. Post-order");
               System.out.print("Enter the order of traversal: ");
               int order = scanner.nextInt();
               dictionary.lookup(order);
               break;
            case 5:
               System.out.println("Number of records: " + dictionary.countRecords());
               break;
            case 6:
               System.exit(0);
               break;
            default:
               System.out.println("Invalid choice.");
               break;
         }
      }
   }
}
