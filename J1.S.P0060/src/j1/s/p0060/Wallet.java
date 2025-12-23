package j1.s.p0060;

public class Wallet {
    private final int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }
    // kiểm tra xem có đủ tiền trả không
    public boolean payMoney(int total) {
        return this.amount >= total;
    }
}
