class Solution {
    int[] months;
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < 12; i++) {
            months[i] += months[i - 1];
        }
        int aliceStart = days(arriveAlice);
        int aliceEnd = days(leaveAlice);
        int bobStart = days(arriveBob);
        int bobEnd = days(leaveBob);
​
        int diff = Math.min(aliceEnd, bobEnd) - Math.max(aliceStart, bobStart);
        if (diff < 0) return 0;
        return diff + 1;
    }
    
    int parseMonth(String date) {
        return Integer.parseInt((date.charAt(0) == '0') ? "" + date.charAt(1) : "" + date.charAt(0) + date.charAt(1));
    }
    int parseDay(String date) {
        return Integer.parseInt((date.charAt(3) == '0') ? "" + date.charAt(4) : "" + date.charAt(3) + date.charAt(4));
    }
    
    int days(String date) {
        int month = parseMonth(date);
        int day = parseDay(date);
        int days = (month > 1 ? months[month - 2] : 0) + day;
        return days;
    }
}
