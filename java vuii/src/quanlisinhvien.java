// Lớp Student để lưu thông tin sinh viên
class Student {
    int id;
    String name;
    double score;
    Student left, right;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.left = null;
        this.right = null;
    }
}

// Lớp BinaryTree để quản lý cây nhị phân
class BinaryTree {
    Student root;

    public BinaryTree() {
        this.root = null;
    }

    // Hàm chèn sinh viên vào cây
    public void insert(int id, String name, double score) {
        Student newStudent = new Student(id, name, score);
        if (root == null) {
            root = newStudent;
        } else {
            insertRec(root, newStudent);
        }
    }

    // Hàm chèn sinh viên vào cây (đệ quy)
    private void insertRec(Student current, Student newStudent) {
        if (newStudent.score < current.score) {
            if (current.left == null) {
                current.left = newStudent;
            } else {
                insertRec(current.left, newStudent);
            }
        } else {
            if (current.right == null) {
                current.right = newStudent;
            } else {
                insertRec(current.right, newStudent);
            }
        }
    }

    // Hàm tìm kiếm sinh viên theo điểm
    public Student search(double score) {
        return searchRec(root, score);
    }

    // Hàm tìm kiếm đệ quy
    private Student searchRec(Student current, double score) {
        if (current == null) {
            return null;
        }
        if (current.score == score) {
            return current;  // nếu tìm thấy điểm số
        }
        if (score < current.score) {
            return searchRec(current.left, score);
        } else {
            return searchRec(current.right, score);
        }
    }

    // Hàm duyệt cây theo thứ tự in-order
    public void inorder() {
        inorderRec(root);
    }

    // Hàm duyệt cây theo thứ tự in-order (đệ quy)
    private void inorderRec(Student node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(String.format("ID: %d, Name: %s, Score: %.1f", node.id, node.name, node.score));
            inorderRec(node.right);
        }
    }
}

public class quanlisinhvien {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Chèn dữ liệu vào cây
        tree.insert(1, "Alice", 90.5);
        tree.insert(2, "Bob", 85.0);
        tree.insert(3, "Charlie", 95.0);
        tree.insert(4, "David", 80.0);

        // Duyệt cây in-order
        System.out.println("Inorder traversal:");
        tree.inorder();

        // Tìm kiếm sinh viên theo điểm
        double searchScore = 85.0;
        Student result = tree.search(searchScore);
        if (result != null) {
            System.out.println(String.format("Found student with score %.1f: ID: %d, Name: %s", searchScore, result.id, result.name));
        } else {
            System.out.println(String.format("Student with score %.1f not found.", searchScore));
        }
    }
}