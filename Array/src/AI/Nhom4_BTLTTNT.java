package AI;

import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

// Class chứa thuật toán tìm kiếm đồ thị với giá cực tiểu
public class Nhom4_BTLTTNT {
    private PriorityQueue<Node> MO; // Hàng đợi ưu tiên để duyệt các đỉnh
    private Set<Integer> DONG; // Tập hợp các đỉnh đã được duyệt
    private int[] g; // Mảng lưu trữ chi phí tới mỗi đỉnh
    private int numberOfNodes; // Số lượng đỉnh trong đồ thị
    private int[][] adjacencyMatrix; // Ma trận kề của đồ thị
    private LinkedList<Integer> path; // Danh sách lưu trữ đường đi từ đỉnh nguồn tới đích
    private int[] parent; // Mảng lưu trữ đỉnh cha của mỗi đỉnh trong đường đi từ nguồn tới đích
    private int source, destination; // Đỉnh nguồn và đỉnh đích
    public static final int MAX_VALUE = 999; // Giá trị MAX, được sử dụng khi không có cạnh nối giữa các đỉnh

    // Constructor
    public Nhom4_BTLTTNT(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.DONG = new HashSet<Integer>();
        this.MO = new PriorityQueue<>(numberOfNodes, new Node());
        this.g = new int[numberOfNodes + 1];
        this.path = new LinkedList<Integer>();
        this.adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];
        this.parent = new int[numberOfNodes + 1];
    }

    // Phương thức tìm kiếm đồ thị với giá cực tiểu
    public int uniformCostSearch(int adjacencyMatrix[][], int source, int destination) {
        int evaluationNode;
        this.source = source;
        this.destination = destination;

        // Khởi tạo mảng g với giá trị MAX_VALUE (vô cùng)
        for (int i = 1; i <= numberOfNodes; i++) {
            g[i] = MAX_VALUE;
        }

        // Sao chép ma trận kề từ tham số đầu vào
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++) {
            for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++) {
                this.adjacencyMatrix[sourceVertex][destinationVertex] = adjacencyMatrix[sourceVertex][destinationVertex];
            }
        }

        // Thêm đỉnh nguồn vào hàng đợi và đặt chi phí tới đỉnh nguồn là 0
        MO.add(new Node(source, 0));
        g[source] = 0;

        // Duyệt hàng đợi
        while (!MO.isEmpty()) {
            evaluationNode = getmoi();
            System.out.println("Đỉnh duyệt là: " + evaluationNode);
            if (evaluationNode == destination) { // Nếu đỉnh duyệt là đỉnh đích, kết thúc và trả về chi phí
                return g[destination];
            }
            DONG.add(evaluationNode); // Đánh dấu đỉnh đã duyệt
            addFrontiersToQueue(evaluationNode); // Thêm các đỉnh kề của đỉnh đang xét vào hàng đợi
        }
        return g[destination]; // Trả về chi phí từ nguồn tới đích
    }

    // Phương thức thêm các đỉnh kề của một đỉnh vào hàng đợi ưu tiên
    private void addFrontiersToQueue(int evaluationNode) {
        for (int destination = 1; destination <= numberOfNodes; destination++) {
            if (!DONG.contains(destination)) { // Nếu đỉnh chưa được duyệt
                if (adjacencyMatrix[evaluationNode][destination] != MAX_VALUE) { // Nếu có cạnh nối tới đỉnh đó
                    if (g[destination] > adjacencyMatrix[evaluationNode][destination] + g[evaluationNode]) {
                        g[destination] = adjacencyMatrix[evaluationNode][destination] + g[evaluationNode];
                        parent[destination] = evaluationNode;
                    }

                    Node node = new Node(destination, g[destination]);
                    if (MO.contains(node)) { // Nếu đỉnh đã tồn tại trong hàng đợi, loại bỏ để cập nhật chi phí mới
                        MO.remove(node);
                    }
                    MO.add(node); // Thêm đỉnh vào hàng đợi
                }
            }
        }
    }

    // Phương thức lấy đỉnh với chi phí nhỏ nhất từ hàng đợi
    private int getmoi() {
        Node node = MO.remove();
        return node.node;
    }

    // Phương thức in ra đường đi từ nguồn tới đích
    public void printPath() {
        path.add(destination);
        boolean found = false;
        int vertex = destination;
        while (!found) {
            if (vertex == source) {
                found = true;
                continue;
            }
            path.add(parent[vertex]);
            vertex = parent[vertex];
        }

        System.out.println("Đường đi giữa đỉnh " + source + " và " + destination+ " là: ");
        Iterator<Integer> iterator = path.descendingIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
    }


    public static void main(String... arg) {
        int adjacencyMatrix[][];
        int numberOfVertices;
        int source = 0;
        int destination = 0;
        int distance;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Nhập số đỉnh: ");
            numberOfVertices = scan.nextInt();

            adjacencyMatrix = new int[numberOfVertices + 1][numberOfVertices + 1];
            System.out.println("Nhập đồ thị: ");
            for (int i = 1; i <= numberOfVertices; i++) {
                for (int j = 1; j <= numberOfVertices; j++) {
                    adjacencyMatrix[i][j] = scan.nextInt();
                    if (i == j) {
                        adjacencyMatrix[i][j] = 0;
                        continue;
                    }
                    if (adjacencyMatrix[i][j] == 0) {
                        adjacencyMatrix[i][j] = MAX_VALUE;
                    }
                }
            }

            System.out.println("Nhập đỉnh bắt đầu: ");
            source = scan.nextInt();

            System.out.println("Nhập đích: ");
            destination = scan.nextInt();

            Nhom4_BTLTTNT uniformCostSearch = new Nhom4_BTLTTNT(numberOfVertices);
            distance = uniformCostSearch.uniformCostSearch(adjacencyMatrix, source, destination);
            uniformCostSearch.printPath();

            System.out.println("\nKhoảng cách giữa đỉnh bắt đầu " + source +
                    " và đỉnh đích " + destination + " là: " + distance);

        } catch (InputMismatchException inputMismatch) {
            System.out.println("Giá trị đầu vào không hợp lệ");
        }
        scan.close();
    }
}

// Class định nghĩa đối tượng Node, được sử dụng trong hàng đợi ưu tiên để duyệt các đỉnh
class Node implements Comparator<Node> {
    public int node; // Đỉnh
    public int cost; // Chi phí tới đỉnh đó

    public Node() {

    }


    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    // Phương thức so sánh 2 đối tượng Node theo chi phí, được sử dụng trong hàng đợi ưu tiên
    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        if (node1.node < node2.node)
            return -1;
        return 0;
    }

    // Phương thức so sánh 2 đối tượng Node, được sử dụng để kiểm tra tính duy nhất của một đỉnh trong hàng đợi
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node node = (Node) obj;
            if (this.node == node.node) {
                return true;
            }
        }
        return false;
    }
}
