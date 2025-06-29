package org.example.utils;

import java.time.format.DateTimeFormatter;

public class Const {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final int LOGOUT_OPTION = -1;
    public static final int DEPOSIT_OPTION = 1;
    public static final int WITHDRAW_OPTION = 2;
    public static final int PRINT_STATEMENT_OPTION = 3;
}
