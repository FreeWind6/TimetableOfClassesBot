import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Logic {

    public static int getDays() throws ParseException {
        Date date1 = new Date();
        Date date2;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        date2 = sdf.parse("2019.01.01");
        int days = (int) ((date1.getTime() - date2.getTime()) / 1000 / 3600 / 24 / 7);
        return days;
    }

    public static int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek - 1;
        return dayOfWeek;
    }

    public static ArrayList<Institute> fillArrayList() {
        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(new Institute(101, "Математика", "Кубышкин Дмитрий Сергеевич"));
        institutes.add(new Institute(0, "Урок", "ФИО"));
        return institutes;
    }

    public static String condition(int days, int dayOfWeek) {
        String string;
        ArrayList<Institute> institutes = Logic.fillArrayList();
        if (days % 2 == 0) {
            switch (dayOfWeek) {
                case 0:
                    string = "Учимся" + "\n" + institutes.get(0).toString();
                    break;
                case 1:
                    string = institutes.get(0).toString();
                    break;
                case 2:
                    string = institutes.get(0).toString();
                    break;
                case 3:
                    string = institutes.get(0).toString();
                    break;
                case 4:
                    string = institutes.get(0).toString();
                    break;
                case 5:
                    string = institutes.get(0).toString();
                    break;
                case 6:
                    string = institutes.get(0).toString();
                    break;
                default:
                    string = institutes.get(0).toString();
                    break;
            }
        } else {
            switch (dayOfWeek) {
                case 0:
                    string = "Учимся" + "\n" + institutes.get(0).toString();
                    break;
                case 1:
                    string = institutes.get(0).toString();
                    break;
                case 2:
                    string = institutes.get(0).toString();
                    break;
                case 3:
                    string = institutes.get(0).toString();
                    break;
                case 4:
                    string = institutes.get(0).toString();
                    break;
                case 5:
                    string = institutes.get(0).toString();
                    break;
                case 6:
                    string = institutes.get(0).toString();
                    break;
                default:
                    string = institutes.get(0).toString();
                    break;
            }
        }
        return string;
    }
}
