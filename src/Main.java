public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);
        while (true){
            try {
                bankAccount.withDraw(6000);
                System.out.println(bankAccount.getAmount());
            } catch (LimitException e) {
                try {
                    bankAccount.withDraw(bankAccount.getAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(bankAccount.getAmount());
                break;
            }
        }
    }
}