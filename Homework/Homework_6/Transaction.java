package Homework_6;

import java.util.Optional;

public class Transaction
{
    TransactionType type;
    double amount;
    Optional<String> comment;
    public Transaction(TransactionType type, double amount)
    {
        this.type = type;
        this.amount = amount;
        comment = Optional.empty();
    }
    public Transaction(TransactionType type, double amount, String com )
    {
        this.type = type;
        this.amount = amount;
        comment = Optional.ofNullable(com);
    }
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



    public Optional<String> getComment() {
        return comment;
    }

    public void setComment(Optional<String> comment) {
        this.comment = comment;
    }
}