import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidAmountException;
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.utils.ExceptionMessages.*;


class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("test",500);
    }

    @Test
    @DisplayName("Should deposit valid amount successfully")
    void shouldDepositValidAmount() {

        account.deposit(100);

        assertEquals(600, account.getBalance());
    }

    @Test
    @DisplayName("Should withdraw valid amount successfully")
    void shouldWithdrawValidAmount() {

        account.withdraw(50);

        assertEquals(450, account.getBalance());
    }


    @Test
    @DisplayName("Should throw InvalidAmountException when depositing invalid amount")
    void shouldThrowExceptionWhenDepositingInvalidAmount() {
        InvalidAmountException exception = assertThrows(
                InvalidAmountException.class,
                () -> account.deposit(-50)
        );
        assertEquals(INVALID_AMOUNT, exception.getMessage());
    }

    @Test
    @DisplayName("Should throw InvalidAmountException when withdrawing invalid amount")
    void shouldThrowExceptionWhenWithdrawingInvalidAmount() {

        InvalidAmountException exception = assertThrows(
                InvalidAmountException.class,
                () -> account.withdraw(-25)
        );
        assertEquals(INVALID_AMOUNT, exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalStateException when withdrawing more than balance")
    void shouldThrowExceptionWhenInsufficientFunds() {

        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class,
                () -> account.withdraw(700)
        );
        assertEquals(INSUFFICIENT_FUNDS, exception.getMessage());
    }
}