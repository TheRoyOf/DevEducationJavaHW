package practice.wednesday_27_05;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Checkpoints highway = new Checkpoints();
        highway.generateCheckpoint();

        for (Checkpoint checkpoint : highway.getCheckpoints().values()) {
            System.out.print("Driver coins: " + driver.getCoins());
            System.out.println("Price: " + checkpoint.getPrice());
            driver.payTheToll(checkpoint.getPrice());
            System.out.println("Driver's debt: " + driver.getDebt());
        }

        System.out.println("_______________");
        System.out.println(highway.getCheckpoints());
        System.out.println(driver.getCoins());
        System.out.println("Driver debt: " + driver.getDebt());
    }
}
