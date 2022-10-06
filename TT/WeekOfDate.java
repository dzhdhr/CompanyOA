package TT;

public class WeekOfDate {
    public static long DateToWeek(long year,int month,int date){


        long prev =  ((365*(year-1))%7+((year-1)/4)%7-((year-1)/100)%7+((year-1)/400)%7+7)%7;
        int day = 0;
        switch (month){
            case 12:
                day+=30;
            case 11:
                day+=31;
            case 10:
                day+=30;
            case 9:
                day+=31;
            case 8:
                day+=31;
            case 7:
                day+=30;
            case 6:
                day+=31;
            case 5:
                day+=30;
            case 4:
                day+=31;
            case 3:
                if(year%4==0&&year%100!=0||year%400==0) day+=29;
                else day+=28;
            case 2:
                day+=31;
            default:
                day+=date;
        }
        System.out.println(prev);
        return (prev+day+7)%7;


    }

    public static void main(String[] args) {
        System.out.println(DateToWeek(2022, 10, 29));
    }

}
