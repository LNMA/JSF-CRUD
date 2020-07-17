package com.walletERP.model.util.date;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NowDate implements Serializable {
    private static final long serialVersionUID = 3574934931968693941L;
    private static java.sql.Timestamp nowTimestamp;
    private static java.sql.Date nowDate;
    private static java.sql.Time nowTime;

    public static Timestamp getNowTimestamp() {
        return java.sql.Timestamp.valueOf(LocalDateTime.now());
    }

    public static Date getNowDate() {
        return java.sql.Date.valueOf(LocalDate.now());
    }

    public static Time getNowTime() {
        return java.sql.Time.valueOf(LocalTime.now());
    }
}
