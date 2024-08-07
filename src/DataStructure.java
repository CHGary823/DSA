import java.util.Hashtable;

public class DataStructure {
    public static void main(String[] args) {
        /*
        //Stack
        Stack<String> stack = new Stack<String>();

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");

        //System.out.println(stack.empty());
        //String myFavGame = stack.pop();
        //System.out.println(stack.peek());
        //System.out.println(myFavGame);
        //System.out.println(stack.search("FFVII"));

        //Queue
        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println(queue.peek());
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.element());


        //Priority Queue
        Queue<String> queue = new PriorityQueue<>();
        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("零");
        queue.offer("一");
        queue.offer("二");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        //LinkedList
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();

        // Use offer and poll method will always add to the last element just like a queue
        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        //linkedList.poll();

        linkedList.add(4,"E");
        linkedList.remove("E");

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        linkedList.addFirst("0");
        linkedList.addLast("G");
        String first = linkedList.removeFirst();
        String last = linkedList.removeLast();
        System.out.println(linkedList);

        // Dynamic Array
        DynamicArray dynamicArray = new DynamicArray(5);
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");

        // After few data insertion the array will auto grow,if decrease certain numbers it will shrink.
        dynamicArray.insert(0,"X");
        dynamicArray.delete("A");
        System.out.println(dynamicArray.search("C"));

        System.out.println(dynamicArray);
        System.out.println("empty: " + dynamicArray.isEmpty());
        System.out.println("size: " + dynamicArray.capacity);
        System.out.println("capacity: " + dynamicArray.size);

        // ArrayList vs LinkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0;i<1000000;i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        // Linked List
        startTime = System.nanoTime();

        linkedList.get(0);
        linkedList.get(500000);
        linkedList.get(999999);
        linkedList.remove(0);
        linkedList.remove(500000);
        linkedList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("LinkedList:\t" + elapsedTime + " ns");

        // Array List
        startTime = System.nanoTime();

        arrayList.get(0);
        arrayList.get(500000);
        arrayList.get(999999);
        arrayList.remove(0);
        arrayList.remove(500000);
        arrayList.remove(999999);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("ArrayList:\t" + elapsedTime + " ns");
        */

        //Hash Table
//        Hashtable<String,String> table = new Hashtable<>(10);
//
//        table.put("100","Spongebob");
//        table.put("123","Patrick");
//        table.put("321","Sandy");
//        table.put("555","Squidward");
//        table.put("777","Gary");
//
//        //table.remove(777);
//
//        for (String key:table.keySet()){
//            System.out.println( key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
            //System.out.println( key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
            //System base on hashCode remainder to sort the result the % 10 is the size of the table
        //Adjacency Matrix
//        GraphAdjacencyMatrix graphAdjacencyMatrix = new GraphAdjacencyMatrix(5);
//
//        graphAdjacencyMatrix.addNodeM(new Node('A'));
//        graphAdjacencyMatrix.addNodeM(new Node('B'));
//        graphAdjacencyMatrix.addNodeM(new Node('C'));
//        graphAdjacencyMatrix.addNodeM(new Node('D'));
//        graphAdjacencyMatrix.addNodeM(new Node('E'));
//
//        graphAdjacencyMatrix.addEdgeM(0,1);
//        graphAdjacencyMatrix.addEdgeM(1,2);
//        graphAdjacencyMatrix.addEdgeM(2,3);
//        graphAdjacencyMatrix.addEdgeM(2,4);
//        graphAdjacencyMatrix.addEdgeM(4,0);
//        graphAdjacencyMatrix.addEdgeM(4,2);
//
//        graphAdjacencyMatrix.printM();
//
//        System.out.println(graphAdjacencyMatrix.checkEdgeM(0,1));

        //Adjacency List
//        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
//        graphAdjacencyList.addNodeL(new Node('A'));
//        graphAdjacencyList.addNodeL(new Node('B'));
//        graphAdjacencyList.addNodeL(new Node('C'));
//        graphAdjacencyList.addNodeL(new Node('D'));
//        graphAdjacencyList.addNodeL(new Node('E'));
//
//        graphAdjacencyList.addEdgeL(0,1);
//        graphAdjacencyList.addEdgeL(1,2);
//        graphAdjacencyList.addEdgeL(1,4);
//        graphAdjacencyList.addEdgeL(2,3);
//        graphAdjacencyList.addEdgeL(2,4);
//        graphAdjacencyList.addEdgeL(4,0);
//        graphAdjacencyList.addEdgeL(4,1);
//
//        graphAdjacencyList.printL();





    }//main
}//class



