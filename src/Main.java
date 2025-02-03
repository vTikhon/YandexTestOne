import enums.Nominals;
import service.ATM;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Map<Nominals, Integer> map;
        map = atm.reloadATM(1000, 1000, 1000, 1000, 1000);
        System.out.println(map);
        map = atm.refreshBalanceATM(5555);
        System.out.println(map);
        map = atm.refreshBalanceATM(5750);
        System.out.println(map);
    }
}