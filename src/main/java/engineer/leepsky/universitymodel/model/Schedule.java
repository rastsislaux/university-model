package engineer.leepsky.universitymodel.model;

import java.util.List;
import java.util.Map;

public class Schedule {

    /**
     * Holds a date (day of the month and the month)
     */
    public static class Date {

        enum Month {
            JANUARY,
            FEBRUARY,
            MARCH,
            APRIL,
            MAY,
            JUNE,
            JULY,
            AUGUST,
            SEPTEMBER,
            OCTOBER,
            NOVEMBER,
            DECEMBER
        }

        private int day;
        private Month month;

        /**
         * Sets the day of the month.
         * @param day - day number (1 - 29/30/31)
         * @return - true if the day was changed, false otherwise
         */
        public boolean setDay(int day) {
            int maxDay = 29;

            switch (month) {
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER   -> maxDay = 31;
                case FEBRUARY, APRIL, JUNE, SEPTEMBER, NOVEMBER             -> maxDay = 30;
                default -> { }
            }

            if (day < 1 || day > maxDay) {
                return false;
            } else {
                this.day = day;
                return true;
            }
        }

        /**
         * Returns the day of the month
         * @return - day of the month (1 - 31)
         */
        public int getDay() {
            return day;
        }

        /**
         * Sets the month
         * @param month - month (see Schedule.Date.Month)
         */
        public void setMonth(Month month) {
            this.month = month;
        }

        /**
         * Gets the month
         * @return - month (see Schedule.Date.Month)
         */
        public Month getMonth() {
            return month;
        }
    }

    Map<Date, List<Lesson>> schedule;
    
    

}
