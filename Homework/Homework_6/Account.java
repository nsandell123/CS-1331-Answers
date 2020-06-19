package Homework_6;
import java.util.*;
import java.util.function.Predicate;

public class Account {
    List<Transaction> pastTransactions;

    public Account(List<Transaction> pastTransactions) {
        this.pastTransactions = pastTransactions;
    }

    public Transaction getTransaction(int index)
    {
        return this.pastTransactions.get(index);
    }
    public List<Transaction> findTransactionsByPredicate(Predicate<Transaction> predicate)
    {
        List<Transaction> newList = new ArrayList<Transaction>();
        for(int i = 0; i < pastTransactions.size(); i++)
        {
            if(predicate.test(pastTransactions.get(i)))
            {
                newList.add(pastTransactions.get(i));
            }
        }
        return newList;

    }
    public List<Transaction> getTransactionsByAmount(double amount)
    {
        class Amount implements Predicate<Transaction>
        {
            public double amount;
            public Amount(double amount)
            {
                this.amount = amount;
            }

            @Override
            public boolean test(Transaction transaction) {
                return this.amount == transaction.getAmount();
            }
        }
        return findTransactionsByPredicate(new Amount(amount));

    }
    public List<Transaction> getWithdrawals()
    {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            @Override
            public boolean test(Transaction transaction) {
                return transaction.getType() == TransactionType.WITHDRAWAL;
            }
        });
    }
    public static boolean  isDeposit(Transaction t)
    {
        return t.getType() == TransactionType.DEPOSIT;
    }
    public List<Transaction> getDeposits()
    {
        return findTransactionsByPredicate(Account::isDeposit);
    }
    public List<Transaction> getTransactionsWithCommentLongerThan(int length){
        return findTransactionsByPredicate(new Predicate<Transaction>() {

            @Override
            public boolean test(Transaction transaction) {
                return transaction.getComment().get().length() > length;
            }
        });
    }



}