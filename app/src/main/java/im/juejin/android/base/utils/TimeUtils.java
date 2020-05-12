package im.juejin.android.base.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {
    private static String DAY = "天前";
    private static String DAY_AFTER = "天后";
    private static String HOUR = "小时前";
    private static String HOUR_AFTER = "小时后";
    private static String JUST_NOW = "片刻之前";
    private static String MIN = "分钟前";
    private static String MIN_AFTER = "分钟后";
    private static String MONTH = "个月前";
    private static String MONTH_AFTER = "个月后";
    public static long UNIT_DAY = 0;
    public static long UNIT_HOUR = 0;
    public static long UNIT_MIN = 60000;
    public static long UNIT_MONTH = 0;
    public static long UNIT_WEEK = 0;
    public static long UNIT_YEAR = 0;
    private static String WEEK = "周前";
    private static String WEEK_AFTER = "周后";
    private static String YEAR = "年前";
    private static String YEAR_AFTER = "年后";
    private static DateFormat format;
    private static DateFormat formatDay;

    static {
        TimeUtils.UNIT_HOUR = TimeUtils.UNIT_MIN * 60;
        TimeUtils.UNIT_DAY = TimeUtils.UNIT_HOUR * 24;
        long v0 = TimeUtils.UNIT_DAY;
        TimeUtils.UNIT_WEEK = 7 * v0;
        TimeUtils.UNIT_MONTH = 30 * v0;
        TimeUtils.UNIT_YEAR = v0 * 365;
        TimeUtils.format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        TimeUtils.formatDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public TimeUtils() {
        super();
    }

    public static String format(long arg4) {
        long v0 = System.currentTimeMillis();
        if (v0 >= arg4) {
            v0 -= arg4;
            if (v0 < TimeUtils.UNIT_MIN) {
                return TimeUtils.JUST_NOW;
            }

            if (v0 < TimeUtils.UNIT_HOUR) {
                return v0 / TimeUtils.UNIT_MIN + TimeUtils.MIN;
            }

            if (v0 < TimeUtils.UNIT_DAY) {
                return v0 / TimeUtils.UNIT_HOUR + TimeUtils.HOUR;
            }

            if (v0 < TimeUtils.UNIT_WEEK) {
                return v0 / TimeUtils.UNIT_DAY + TimeUtils.DAY;
            }

            if (v0 < TimeUtils.UNIT_MONTH) {
                return v0 / TimeUtils.UNIT_WEEK + TimeUtils.WEEK;
            }

            if (v0 < TimeUtils.UNIT_YEAR) {
                return v0 / TimeUtils.UNIT_MONTH + TimeUtils.MONTH;
            }

            return v0 / TimeUtils.UNIT_YEAR + TimeUtils.YEAR;
        }

        arg4 -= v0;
        if (arg4 < TimeUtils.UNIT_MIN) {
            return TimeUtils.JUST_NOW;
        }

        if (arg4 < TimeUtils.UNIT_HOUR) {
            return arg4 / TimeUtils.UNIT_MIN + TimeUtils.MIN_AFTER;
        }

        if (arg4 < TimeUtils.UNIT_DAY) {
            return arg4 / TimeUtils.UNIT_HOUR + TimeUtils.HOUR_AFTER;
        }

        if (arg4 < TimeUtils.UNIT_WEEK) {
            return arg4 / TimeUtils.UNIT_DAY + TimeUtils.DAY_AFTER;
        }

        if (arg4 < TimeUtils.UNIT_MONTH) {
            return arg4 / TimeUtils.UNIT_WEEK + TimeUtils.WEEK_AFTER;
        }

        if (arg4 < TimeUtils.UNIT_YEAR) {
            return arg4 / TimeUtils.UNIT_MONTH + TimeUtils.MONTH_AFTER;
        }

        return arg4 / TimeUtils.UNIT_YEAR + TimeUtils.YEAR_AFTER;
    }

    public static String format(String arg0) {
        if (arg0 == null) {
            return "";
        }

        return TimeUtils.format(TimeUtils.parseUTC(arg0));
    }

    public static String format(Date arg2) {
        if (arg2 == null) {
            return "";
        }

        return TimeUtils.format(arg2.getTime());
    }

    public static String formatYMD(Date arg3) {
        return new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(arg3);
    }

    public static String formatYMDorYesterday(Date arg3) {
        if (TimeUtils.isYesterday(arg3)) {
            return "昨天";
        }

        return new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(arg3);
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static Date getDateEnd(Date arg5) {
        return new Date(arg5.getTime() + TimeUtils.getPerDayTimes() - 1);
    }

    public static Date getDateStart(String arg1) {
        return TimeUtils.parseDay(arg1.split("T")[0]);
    }

    public static Date getDayStart(Date arg2) {
        return TimeUtils.minusDays(arg2.getTime(), 1);
    }

    public static Date getMonthStart(Date arg2) {
        return TimeUtils.minusDays(arg2.getTime(), 30);
    }

    public static long getPerDayTimes() {
        return 86400000;
    }

    public static Date getThreeDaysStart(Date arg2) {
        return TimeUtils.minusDays(arg2.getTime(), 3);
    }

    public static long getTimestampMinute_8() {
        SimpleDateFormat v0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:00", Locale.CHINA);
        String v1 = v0.format(new Date());
        long v2 = 1000;
        try {
            return v0.parse(v1).getTime() / v2;
        } catch (ParseException e) {
            AppLogger.e("getTimestampMinute_8 fail!");
            return new Date().getTime() / v2;
        }
    }

    public static String getUTC(Date arg3) {
        SimpleDateFormat v0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.getDefault());
        v0.setTimeZone(TimeZone.getTimeZone("GMT"));
        return v0.format(arg3);
    }

    public static Date getWeekStart(Date arg2) {
        return TimeUtils.minusDays(arg2.getTime(), 7);
    }

    public static String getXiaoceReadTime(long arg7) {
        long v2 = arg7 / 720;
        arg7 %= 720;
        String v0 = "分";
        String v1 = "";
        if (arg7 == 0) {
            return v1 + v2 + v0;
        }

        if (arg7 > 360) {
            return v1 + (v2 + 1) + v0;
        }

        return v1 + v2 + "分30秒";
    }

    public static boolean isIn48Hours(Date arg4) {
        boolean v4 = System.currentTimeMillis() - arg4.getTime() < 259200000 ? true : false;
        return v4;
    }

    public static boolean isInDate(String arg5, String arg6, String arg7) {
        boolean v0 = false;
        try {
            long v1 = TimeUtils.parseUTC(arg5).getTime();
            long v5_1 = TimeUtils.parseUTC(arg6).getTime();
            long v3 = TimeUtils.parseUTC(arg7).getTime();
            if (v1 <= v5_1) {
                return false;
            }
            if (v1 < v3) {
                v0 = true;
            }
        } catch (Exception v5) {
            v5.printStackTrace();
            return false;
        }


        return v0;
    }

    public static boolean isInDate(Date arg5, Date arg6, Date arg7) {
        boolean v0 = false;
        try {
            long v1 = arg5.getTime();
            long v5_1 = arg6.getTime();
            long v3 = arg7.getTime();
            if (v1 <= v5_1) {
                return false;
            }
            if (v1 < v3) {
                v0 = true;
            }
        } catch (Exception v5) {
            v5.printStackTrace();
            return false;
        }


        return v0;
    }

    public static boolean isSameDay(Date arg4, Date arg5) {
        if (arg4 != null) {
            if (arg5 == null) {
            } else {
                Calendar v1 = Calendar.getInstance();
                v1.setTime(arg4);
                Calendar v4 = Calendar.getInstance();
                v4.setTime(arg5);
                boolean v5 = true;
                if (v1.get(1) != v4.get(1) || v1.get(2) != v4.get(2) || v1.get(5) != v4.get(5)) {
                    v5 = false;
                } else {
                }

                return v5;
            }
        }

        return false;
    }

    public static boolean isYesterday(Date arg6) {
        if (arg6 == null) {
            return false;
        }

        Calendar v1 = Calendar.getInstance();
        v1.setTimeInMillis(System.currentTimeMillis());
        int v3 = 5;
        v1.add(v3, -1);
        Calendar v2 = Calendar.getInstance();
        v2.setTime(arg6);
        boolean v6 = true;
        if (v1.get(1) != v2.get(1) || v1.get(2) != v2.get(2) || v1.get(v3) != v2.get(v3)) {
            v6 = false;
        }

        return v6;
    }

    public static Date minusDays(long arg4, int arg6) {
        return new Date(arg4 - (((long) arg6)) * TimeUtils.UNIT_DAY);
    }

    public static boolean moreThan7Days(Date arg5) {
        boolean v0 = false;
        if (arg5 == null) {
            AppLogger.e("date can not be null");
            return false;
        }

        if (System.currentTimeMillis() - arg5.getTime() > 604800000) {
            v0 = true;
        }

        return v0;
    }

    public static Date parseDay(String arg2) {
        try {
            TimeUtils.formatDay.setTimeZone(TimeZone.getTimeZone("UTC"));
            AppLogger.e("时间 : " + TimeUtils.formatDay.parse(arg2));
            return TimeUtils.formatDay.parse(arg2);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date parseUTC(String arg3) {
        SimpleDateFormat v0;
        if (arg3 == null) {
            return null;
        }

        if (arg3.endsWith("+08:00")) {
            v0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS", Locale.getDefault());
            v0.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            try {
                return v0.parse(arg3);
            } catch (ParseException e) {
                return new Date();
            }
        }

        v0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.getDefault());
        v0.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return v0.parse(arg3);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
