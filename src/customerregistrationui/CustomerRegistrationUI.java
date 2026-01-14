package customerregistrationui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class CustomerType {
    private final String typeId;
    private final String typeName;

    public CustomerType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }
}

class Customer extends CustomerType {
    private final String id;
    private final String fullName;
    private final String phone;
    private final String email;
    private final String address;

    public Customer(String id, String fullName, String phone, String email, String address,
                    String typeId, String typeName) {
        super(typeId, typeName);
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

public class CustomerRegistrationUI extends JFrame {

    private JTextField txtId, txtName, txtPhone, txtEmail, txtAddress, txtSearch;
    private JComboBox<String> cmbType;
    private JTextArea txtOutput;

    private final ArrayList<Customer> customers = new ArrayList<>();
    private boolean isSorted = false;

    public CustomerRegistrationUI() {
        setTitle("CIMS - Customer Registration");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Customer Registration", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField();
        txtName = new JTextField();
        txtPhone = new JTextField();
        txtEmail = new JTextField();
        txtAddress = new JTextField();
        txtSearch = new JTextField();

        cmbType = new JComboBox<>(new String[]{
                "Prepaid (TP01)", "Postpaid (TP02)", "VIP (TP03)", "B2B (TP04)"
        });

        int row = 0;
        addRow(form, c, row++, "Customer ID:", txtId);
        addRow(form, c, row++, "Full Name:", txtName);
        addRow(form, c, row++, "Phone Number:", txtPhone);
        addRow(form, c, row++, "Email Address:", txtEmail);
        addRow(form, c, row++, "Customer Address:", txtAddress);
        addRow(form, c, row++, "Customer Type:", cmbType);
        addRow(form, c, row++, "Search by ID:", txtSearch);

        JPanel outputPanel = new JPanel(new BorderLayout());
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        outputPanel.add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        center.add(form);
        center.add(outputPanel);
        add(center, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout());
        JButton btnRegister = new JButton("Register Customer");
        JButton btnSort = new JButton("Sort & View");
        JButton btnSearch = new JButton("Jump Search");

        buttons.add(btnRegister);
        buttons.add(btnSort);
        buttons.add(btnSearch);
        add(buttons, BorderLayout.SOUTH);

        btnRegister.addActionListener(e -> registerCustomer());
        btnSort.addActionListener(e -> sortAndView());
        btnSearch.addActionListener(e -> jumpSearchCustomer());

        loadSampleData();
    }

    private static void addRow(JPanel panel, GridBagConstraints c, int row, String label, JComponent field) {
        c.gridx = 0;
        c.gridy = row;
        c.weightx = 0;
        panel.add(new JLabel(label), c);

        c.gridx = 1;
        c.weightx = 1;
        panel.add(field, c);
    }

    private void loadSampleData() {
        customers.add(new Customer("1001", "Customer One", "0791111101", "c1@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1002", "Customer Two", "0791111102", "c2@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1003", "Customer Three", "0791111103", "c3@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1004", "Customer Four", "0791111104", "c4@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1005", "Customer Five", "0791111105", "c5@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1006", "Customer Six", "0791111106", "c6@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1007", "Customer Seven", "0791111107", "c7@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1008", "Customer Eight", "0791111108", "c8@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1009", "Customer Nine", "0791111109", "c9@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1010", "Customer Ten", "0791111110", "c10@mail.com", "Amman", "TP02", "Postpaid"));

        customers.add(new Customer("1011", "Customer Eleven", "0791111111", "c11@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1012", "Customer Twelve", "0791111112", "c12@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1013", "Customer Thirteen", "0791111113", "c13@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1014", "Customer Fourteen", "0791111114", "c14@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1015", "Customer Fifteen", "0791111115", "c15@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1016", "Customer Sixteen", "0791111116", "c16@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1017", "Customer Seventeen", "0791111117", "c17@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1018", "Customer Eighteen", "0791111118", "c18@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1019", "Customer Nineteen", "0791111119", "c19@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1020", "Customer Twenty", "0791111120", "c20@mail.com", "Amman", "TP04", "B2B"));

        customers.add(new Customer("1021", "Customer TwentyOne", "0791111121", "c21@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1022", "Customer TwentyTwo", "0791111122", "c22@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1023", "Customer TwentyThree", "0791111123", "c23@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1024", "Customer TwentyFour", "0791111124", "c24@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1025", "Customer TwentyFive", "0791111125", "c25@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1026", "Customer TwentySix", "0791111126", "c26@mail.com", "Amman", "TP02", "Postpaid"));
        customers.add(new Customer("1027", "Customer TwentySeven", "0791111127", "c27@mail.com", "Amman", "TP03", "VIP"));
        customers.add(new Customer("1028", "Customer TwentyEight", "0791111128", "c28@mail.com", "Amman", "TP04", "B2B"));
        customers.add(new Customer("1029", "Customer TwentyNine", "0791111129", "c29@mail.com", "Amman", "TP01", "Prepaid"));
        customers.add(new Customer("1030", "Customer Thirty", "0791111130", "c30@mail.com", "Amman", "TP02", "Postpaid"));

        isSorted = false;
        txtOutput.append("30 sample customers loaded.\n");
    }

    private void registerCustomer() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String phone = txtPhone.getText().trim();
        String email = txtEmail.getText().trim();
        String address = txtAddress.getText().trim();

        if (!validateInput(id, name, phone, email, address)) {
            txtOutput.append("Invalid input\n");
            return;
        }

        if (isDuplicate(id)) {
            txtOutput.append("Duplicate Customer ID\n");
            return;
        }

        String selected = (String) cmbType.getSelectedItem();
        String typeId = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
        String typeName = selected.substring(0, selected.indexOf("(")).trim();

        customers.add(new Customer(id, name, phone, email, address, typeId, typeName));
        isSorted = false;

        txtOutput.append("Customer registered: " + id + "\n");
        clearForm();
    }

    private void sortAndView() {
        if (customers.isEmpty()) return;

        long startTime = System.nanoTime();
        mergeSort(customers, 0, customers.size() - 1);
        isSorted = true;
        long endTime = System.nanoTime();

        txtOutput.append("Sorted Customers:\n");
        for (Customer c : customers) {
            txtOutput.append(c.getId() + " - " + c.getFullName() + "\n");
        }
        txtOutput.append("Execution Time (Sorting): " + (endTime - startTime) + " ns\n");
    }

    private void jumpSearchCustomer() {
        if (customers.isEmpty()) return;

        String target = txtSearch.getText().trim();
        if (target.isEmpty() || !target.matches("\\d+")) {
            txtOutput.append("Invalid search ID\n");
            return;
        }

        long startTime = System.nanoTime();

        if (!isSorted) {
            mergeSort(customers, 0, customers.size() - 1);
            isSorted = true;
        }

        int index = jumpSearch(customers, Integer.parseInt(target));

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        if (index >= 0) {
            txtOutput.append("Found: " + customers.get(index).getFullName() + "\n");
        } else {
            txtOutput.append("Customer not found\n");
        }

        txtOutput.append("Execution Time (After Improvement): " + executionTime + " ns\n");
    }

    private boolean validateInput(String id, String name, String phone, String email, String address) {
        if (id.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) return false;
        if (!id.matches("\\d+")) return false;
        if (!phone.startsWith("079")) return false;
        if (!email.contains("@")) return false;
        return true;
    }

    private boolean isDuplicate(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) return true;
        }
        return false;
    }

    private void mergeSort(ArrayList<Customer> list, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(ArrayList<Customer> list, int left, int mid, int right) {
        ArrayList<Customer> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (parseId(list.get(i).getId()) <= parseId(list.get(j).getId())) temp.add(list.get(i++));
            else temp.add(list.get(j++));
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    private int jumpSearch(ArrayList<Customer> list, int targetId) {
        int n = list.size();
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (prev < n) {
            int last = Math.min(prev + step, n) - 1;
            int lastId = parseId(list.get(last).getId());
            if (lastId >= targetId) break;
            prev += step;
            if (prev >= n) return -1;
        }

        int end = Math.min(prev + step, n);
        for (int i = prev; i < end; i++) {
            if (parseId(list.get(i).getId()) == targetId) return i;
        }
        return -1;
    }

    private int parseId(String id) {
        try {
            return Integer.parseInt(id.trim());
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerRegistrationUI().setVisible(true));
    }
}
