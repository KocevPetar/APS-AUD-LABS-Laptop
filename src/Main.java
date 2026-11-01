public class Main {

    // Parent class: Bicycle
//    public static class Bicycle {
//        public int gear;
//        public int speed;
//
//        // Constructor
//        public Bicycle(int gear, int speed) {
//            this.gear = gear;
//            this.speed = speed;
//        }
//
//        // Decreases the bicycle's speed
//        public void applyBrake(int brake) {
//            speed -= brake;
//        }
//
//        // Increases the bicycle's speed
//        public void speedUp(int increment) {
//            speed += increment;
//        }
//
//        // Returns information about the bicycle as a String
    ////
//        public String toString() {
//            return "Number of gears: " + gear
//                    + "\nSpeed of bicycle: " + speed;
//        }
//    }
//
//    // Child class: MountainBike inherits from Bicycle
//    public static class MountainBike extends Bicycle {
//        public int seatHeight;
//
//        // Constructor
//        public MountainBike(int gear, int speed, int seatHeight) {
//            super(gear, speed); // Calls the Bicycle constructor
//            this.seatHeight = seatHeight;
//        }
//
//        // Changes the seat height
//        public void setHeight(int newValue) {
//            seatHeight = newValue;
//        }
//
//        // Overrides the parent's toString() method
//        @Override
//        public String toString() {
//            return super.toString()
//                    + "\nSeat height: " + seatHeight;
//        }
//    }

    public static void main(String[] args) {

        // String examples
        // String s = new String("I'm"); // First way
        // String n = " FINKI student";   // Second way
        // System.out.println(s + n);

        // Reading a line from the keyboard
//            Scanner input = new Scanner(System.in);
//            int number = input.nextInt();
//            input.nextLine();
//            String name = input.nextLine();
//            float decimalNumber = input.nextFloat();
//            Boolean hasName = input.nextBoolean();
//            System.out.println(number + " " +  name + " " +  decimalNumber + " " +  hasName);
//            input.close();
        // TODO: Print the number of even and odd numbers
//         in a given array and calculate their average.

//         int[] niza = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
//         int sum = 0;
//         int odd = 0;
//         int even = 0;
//         double average;
//
//         for (int i = 0; i < niza.length; i++) {
//             if (niza[i] % 2 == 0) {
//                 even++;
//             } else {
//                 odd++;
//             }
//             sum += niza[i];
//         }
//
//         int arrayLength = niza.length;
//         average = (double) sum / arrayLength;
//
//         System.out.println("Number of even numbers: " + even
//                 + " and number of odd numbers: " + odd);
//         System.out.println("Average: " + average);


        // TODO: Create and print Bicycle and MountainBike objects

//        Bicycle b = new Bicycle(1, 60);
//        System.out.println(b.toString());
//
//        System.out.println();
//
//        MountainBike mb = new MountainBike(3, 100, 25);
//        System.out.println(mb.toString());

        // Example of changing the bicycle's speed
        // mb.speedUp(10);
        // mb.applyBrake(5);
        // System.out.println(mb);

        // Example of changing the mountain bike's seat height
        // mb.setHeight(30);
        // System.out.println(mb);

        // Scanner is not needed while the input examples remain commented out.
    }
}