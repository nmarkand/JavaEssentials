package Collection.STREAM.object;

import java.time.LocalDate;

public class User {
    private Long userId;
    private Integer amount;
    private LocalDate date;

    public User(Long userId, Integer amount, LocalDate date) {
        this.userId = userId;
        this.amount = amount;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
