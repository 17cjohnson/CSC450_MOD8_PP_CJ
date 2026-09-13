public class ConcurrencyCounter {

    public static void main(String[] args) {

        Thread firstThread = new Thread(() -> {
            System.out.println("Counting up starting here:");

            for (int number = 0; number <= 20; number++) {
                System.out.println(number);
            }

            System.out.println("Count up finished.");
        });

        Thread secondThread = new Thread(() -> {
            System.out.println("Counting down starting here:");

            for (int number = 20; number >= 0; number--) {
                System.out.println(number);
            }

            System.out.println("Count down finished.");
        });

        firstThread.start();

        try {
            firstThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        secondThread.start();

        try {
            secondThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Both countdowns complete.");
    }
}