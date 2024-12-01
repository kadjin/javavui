class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
class BinaryTree {
    Student root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int id, String name, double score) throws IllegalArgumentException {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Điểm số phải nằm trong khoảng từ 0 đến 10.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không hợp lệ.");
        }
        Student newStudent = new Student(id, name, score);
        if (root == null) {
            root = newStudent;
        } else {
            insertRecursive(root, newStudent);
        }
    }
    private void insertRecursive(Student node, Student newStudent) {
        if (newStudent.score < node.score) {
            if (node.left == null) {
                node.left = newStudent;
            } else {
                insertRecursive(node.left, newStudent);
            }
        } else {
            if (node.right == null) {
                node.right = newStudent;
            } else {
                insertRecursive(node.right, newStudent);
            }
        }
    }
    public Student search(double score) throws StudentNotFoundException {
        Student result = searchRecursive(root, score);
        if (result == null) {
            throw new StudentNotFoundException("Sinh viên không tồn tại với điểm số: " + score);
        }
        return result;
    }
    private Student searchRecursive(Student node, double score) {
        if (node == null) {
            return null;
        }
        if (score == node.score) {
            return node;
        }
        if (score < node.score) {
            return searchRecursive(node.left, score);
        } else {
            return searchRecursive(node.right, score);
        }
    }
    public void delete(double score) throws StudentNotFoundException {
        if (root == null) {
            throw new StudentNotFoundException("Cây rỗng, không thể xóa sinh viên.");
        }
        root = deleteRecursive(root, score);
    }
    private Student deleteRecursive(Student node, double score) {
        if (node == null) {
            return null;
        }

        if (score < node.score) {
            node.left = deleteRecursive(node.left, score);
        } else if (score > node.score) {
            node.right = deleteRecursive(node.right, score);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.score = minValue(node.right);
            node.right = deleteRecursive(node.right, node.score);
        }
        return node;
    }
    private double minValue(Student node) {
        double minValue = node.score;
        while (node.left != null) {
            minValue = node.left.score;
            node = node.left;
        }
        return minValue;
    }
    public void inorder() {
        if (root == null) {
            System.out.println("Cây rỗng.");
            return;
        }
        inorderRecursive(root);
    }
    private void inorderRecursive(Student node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.println("ID: " + node.id + ", Name: " + node.name + ", Score: " + node.score);
            inorderRecursive(node.right);
        }
    }
}
