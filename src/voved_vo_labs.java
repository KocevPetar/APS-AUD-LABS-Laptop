//import java.util.Scanner;
//
//public class voved_vo_labs {
//
//    public static class Employee{
//         protected String id;
//         protected String name;
//         protected double baseSalary;
//
//        public Employee(String id, String name, double baseSalary){
//            this.id = id;
//            this.name = name;
//            this.baseSalary = baseSalary;
//        }
//
//        public double calculateSalary(){
//            return baseSalary;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%s %s salary=%.2f",
//                    id, name, calculateSalary());
//        }
//
//
//
//    }
//
//     static class Developer extends Employee{
//       protected int overtimeHours;
//
//       public Developer(String id, String name, double baseSalary, int overtimeHours){
//           super(id, name, baseSalary);
//           this.overtimeHours = overtimeHours;
//       }
//
//
//       @Override public double calculateSalary(){
//           return super.calculateSalary() +overtimeHours * 300;
//       }
//
//       @Override public String toString(){
//           return super.toString() + " overtime=" + overtimeHours;
//       }
//    }
//
//    static class TeamLead extends Developer{
//        protected int teamSize;
//
//        public TeamLead(String id, String name, double baseSalary, int overtimeHours, int teamSize){
//            super(id,name,baseSalary,overtimeHours);
//            this.teamSize = teamSize;
//        }
//
//        @Override public double calculateSalary(){
//            double salary = super.calculateSalary() + teamSize * 1000;
//
//            if(teamSize >= 5){
//                salary *=1.05;
//            }
//            return salary;
//        }
//
//        @Override public String toString(){
//            return super.toString() + " team=" + teamSize;
//        }
//    }
//
//    static class Intern extends Employee{
//        protected int months;
//
//        public Intern(String id, String name, double baseSalary, int months) {
//            super(id, name, baseSalary);
//            this.months = months;
//        }
//
//        @Override public double calculateSalary(){
//            double salary =0.0;
//            if(months >= 6){
//                return super.calculateSalary() * 0.80;
//            }
//
//            return super.calculateSalary() * 0.60;
//        }
//
//        @Override public String toString() {
//            return super.toString() + " months=" + months;
//        }
//
//    }
//
//    static class Company{
//        private String name;
//        private Employee[] employees;
//        private int count;
//
//        public Company(String name, int count){
//            this.name = name;
//            employees = new Employee[count];
//            this.count =0;
//        }
//
//        public void hire(Employee e){
//            if(count < employees.length){
//                employees[count++] =e;
//            }
//        }
//
//        public void printAll(){
//            System.out.println("=== " + name + " ===");
//
//            for(int i = 0 ; i < count; i++){
//                System.out.println(employees[i]);
//            }
//        }
//
//        public void printStatistics(){
//            int developer =0;
//            int teamLeads =0;
//            int interns = 0;
//            int others = 0;
//
//            for(int i = 0; i < count;i++){
//                Employee e = employees[i];
//
//                if(e instanceof TeamLead){
//                    teamLeads++;
//                }else if(e instanceof Developer){
//                    developer++;
//                }else if(e instanceof Intern){
//                    interns++;
//                }else{
//                    others++;
//                }
//            }
//
//            System.out.printf(
//                    "Developers: %d, Team leads: %d, Interns: %d, Others: %d%n",
//                    developer, teamLeads, interns, others
//            );
//        }
//
//        public double totalPayroll(){
//            double total =0;
//
//            for(int i = 0; i < count; i++){
//                total += employees[i].calculateSalary();
//            }
//            return total;
//        }
//
//        public double averageSalary(){
//            if(count ==0 ){
//                return 0;
//            }
//
//            return totalPayroll() / count;
//        }
//
//        public Employee highestPaid(){
//            if(count ==0 ){
//                return null;
//            }
//            Employee highest = employees[0];
//
//            for(int i =0; i < count ;i++){
//                if(employees[i].calculateSalary() > highest.calculateSalary()){
//                    highest = employees[i];
//                }
//            }
//            return highest;
//        }
//
//        public int countAbove(double threshold){
//            int result =0;
//
//            for(int i =0; i < count; i++){
//                if(employees[i].calculateSalary() > threshold){
//                    result++;
//                }
//            }
//            return result;
//        }
//
//    }
//
//
//
//    public static  void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        Company company = new Company("FINKI Soft", n);
//
//        for (int i = 0; i < n; i++) {
//            String type = sc.next();
//            String id = sc.next();
//            String name = sc.next();
//            double base = sc.nextDouble();
//
//            if (type.equals("E")) {
//                company.hire(new Employee(id, name, base));
//            } else if (type.equals("D")) {
//                int overtime = sc.nextInt();
//
//                company.hire(
//                        new Developer(id, name, base, overtime)
//                );
//            } else if (type.equals("L")) {
//                int overtime = sc.nextInt();
//                int teamSize = sc.nextInt();
//
//                company.hire(
//                        new TeamLead(id, name, base, overtime, teamSize)
//                );
//            } else if (type.equals("I")) {
//                int months = sc.nextInt();
//
//                company.hire(
//                        new Intern(id, name, base, months)
//                );
//            }
//        }
//
//        double threshold = sc.nextDouble();
//
//        company.printAll();
//        company.printStatistics();
//
//        System.out.printf(
//                "Total payroll: %.2f%n", company.totalPayroll()
//        );
//
//        System.out.printf(
//                "Average salary: %.2f%n", company.averageSalary()
//        );
//
//        Employee highest = company.highestPaid();
//
//        if (highest != null) {
//            System.out.printf(
//                    "Highest paid: %s %s (%.2f)%n",
//                    highest.id, highest.name, highest.calculateSalary()
//            );
//        }
//
//        System.out.printf(
//                "Employees with salary above %.2f: %d%n",
//                threshold, company.countAbove(threshold)
//        );
//
//        sc.close();
//    }
//}

import java.util.Scanner;
import java.util.ArrayList;

public class voved_vo_labs{

    static class Product{
        protected String name;
        protected double price;

        public Product(String name, double price){
            this.name = name;
            this.price = price;
        }


        public double finalPrice(){
            return price;
        }

        @Override public String toString(){
            return String.format("%s price=%.2f final=%.2f" , name,  price, finalPrice());
        }
    }

    static class Food extends Product{
        private int daysToExpiry;

        public Food(String name, double price, int daysToExpiry){
            super(name,price);
            this.daysToExpiry = daysToExpiry;
        }

        @Override public double finalPrice(){
            if(daysToExpiry <=3){
                return super.finalPrice() * 0.50;
            }

            return super.finalPrice();
        }


        @Override public String toString(){
            return (super.toString() + " days=" + daysToExpiry);
        }

        public int getDaysToExpiry(){
            return daysToExpiry;
        }


    }

    static class Electronics extends Product{
        private int warrantyMonths;

        public Electronics(String name, double price, int warrantyMonths){
            super(name,price);
            this.warrantyMonths = warrantyMonths;
        }

        @Override public double finalPrice(){
            if(warrantyMonths > 24){
                return super.finalPrice() * 1.15;
            }
            return super.finalPrice();
        }


        @Override public String toString(){
            return super.toString() + " warranty=" + warrantyMonths;
        }

        public int getWarrantyMonths(){
            return warrantyMonths;
        }
    }

    static class Pair<K, V>{
        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey (){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    static class Container<T extends Product>{
        private String name;
        private int capacity;
        private ArrayList<T> items;

        public Container(String name, int capacity){
            this.name = name;
            this.capacity = capacity;
            items = new ArrayList<>();
        }

        public boolean add(T item){
            if(items.size() >= capacity){
                return false;
            }

            items.add(item);
            return true;
        }

        public int size(){
            return items.size();
        }

        public double totalValue(){
            double total =0;

            for(int i = 0; i < items.size(); i++){
                total +=items.get(i).finalPrice();
            }

            return total;
        }

        public T mostExpensive(){
            if(items.isEmpty()){
                return null;
            }

            T most = items.get(0);

            for(int i = 0; i < items.size(); i++){
                if(items.get(i).finalPrice() > most.finalPrice()){
                    most = items.get(i);
                }
            }
            return most;
        }

        public Pair<String, Double> summary(){
            return new Pair<>(name,totalValue());
        }

        public void print(){
            System.out.printf(
                    "=== %s (%d/%d) ===%n",
                    name, items.size(), capacity);
            for(int i = 0; i < items.size(); i ++){
                System.out.println(items.get(i));
            }

            System.out.printf("Total: %.2f%n", totalValue());

            T most = mostExpensive();

            if(most == null){
                System.out.println("Most expensive: none");
            }else{
                System.out.printf("Most expensive: %s (%.2f)%n", most.name, most.finalPrice());
            }
        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int fridgeCapacity = sc.nextInt();
        int techCapacity = sc.nextInt();
        int overflowCapacity = sc.nextInt();

        Container<Food> fridge =
                new Container<>("Fridge", fridgeCapacity);

        Container<Electronics> tech =
                new Container<>("Tech", techCapacity);

        Container<Product> overflow =
                new Container<>("Overflow", overflowCapacity);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();

            if (type.equals("F")) {
                int days = sc.nextInt();
                Food food = new Food(name, price, days);

                if (!fridge.add(food)) {
                    if (!overflow.add(food)) {
                        System.out.println("Rejected: " + name);
                    }
                }

            } else if (type.equals("E")) {
                int warranty = sc.nextInt();
                Electronics electronics =
                        new Electronics(name, price, warranty);

                if (!tech.add(electronics)) {
                    if (!overflow.add(electronics)) {
                        System.out.println("Rejected: " + name);
                    }
                }
            }
        }

        fridge.print();
        tech.print();
        overflow.print();

        Pair<String, Double> fridgeSummary = fridge.summary();
        Pair<String, Double> techSummary = tech.summary();
        Pair<String, Double> overflowSummary = overflow.summary();

        Pair<String, Double> best = fridgeSummary;

        if (techSummary.getValue() > best.getValue()) {
            best = techSummary;
        }

        if (overflowSummary.getValue() > best.getValue()) {
            best = overflowSummary;
        }

        System.out.printf(
                "Most valuable container: %s (%.2f)%n",
                best.getKey(), best.getValue()
        );

        Food topFood = fridge.mostExpensive();

        if (topFood != null) {
            System.out.printf(
                    "Top food expires in %d days%n",
                    topFood.getDaysToExpiry()
            );
        }

        Electronics topElectronics = tech.mostExpensive();

        if (topElectronics != null) {
            System.out.printf(
                    "Top electronics warranty: %d months%n",
                    topElectronics.getWarrantyMonths()
            );
        }

        sc.close();
    }
}
//petar