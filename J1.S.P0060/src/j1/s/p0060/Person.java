package j1.s.p0060;
// lớp này đại diện cho người mua sắm cái, sở hữu 1 cái ví

public class Person {
private Wallet wallet; // gọi theo kiểu tham chiếu, Người này sở hữu một cái Ví, và cái Ví đó có khả năng tự kiểm tra tiền
// lớp person không quan tâm cái ví hoạt động thế nào, chỉ cần hỏi cái ví này đủ tiền mua hay không thôi.

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }
// getter dùng để truy cập dữ liệu trong ví
    public Wallet getWallet() {
        return wallet;
    }


}
