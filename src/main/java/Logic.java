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
        return dayOfWeek;
    }

    public static ArrayList<Institute> fillArrayList() {
        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(new Institute("Стадион", "Физическая культура", "Боброва"));//0
        institutes.add(new Institute("201", "Операционные системы", "Челпанов"));//1
        institutes.add(new Institute("201", "Сети и телекоммуникации", "Челпанов"));//2
        institutes.add(new Institute("405", "Правоведение", "Еременская"));//3
        institutes.add(new Institute("201", "Операционные системы", "Зотов"));//4
        institutes.add(new Institute("210", "Базы данных", "Чибисова"));//5
        institutes.add(new Institute("210", "Обьектно-ориентированное программирование", "Зотов"));//6
        institutes.add(new Institute("310", "Авиационные материалы", "Мамонов"));//7
        return institutes;
    }

    public static String conditionOneWeak(int days) {
        String string;
        ArrayList<Institute> institutes = Logic.fillArrayList();
        if ((days % 2) == 0) {
            string = "Понедельник:" + institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Вторник:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Среда:" + institutes.get(7).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Четверг:" + institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Пятница:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Суббота:" + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Воскресенье:" + "\n" + "Не учимся!";
        } else {
            string = "Понедельник:" + institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Вторник:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Среда:" + institutes.get(7).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Четверг:" + institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Пятница:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Суббота:" + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Воскресенье:" + "\n" + "Не учимся!";
        }
        return string;
    }

    public static String conditionPlusOneWeak(int days) {
        String string;
        ArrayList<Institute> institutes = Logic.fillArrayList();
        if ((days % 2) != 0) {
            string = "Понедельник:" + institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Вторник:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Среда:" + institutes.get(7).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Четверг:" + institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Пятница:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Суббота:" + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Воскресенье:" + "\n" + "Не учимся!";
        } else {
            string = "Понедельник:" + institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Вторник:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Среда:" + institutes.get(7).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Четверг:" + institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Пятница:" + "\n" + "Не учимся!" + "\n"
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Суббота:" + institutes.get(5).toString()
                    + "--------------------------------------------------------------------------"
                    + "\n" + "Воскресенье:" + "\n" + "Не учимся!";
        }
        return string;
    }

    public static String conditionOneDay(int days, int dayOfWeek) {
        String string;
        ArrayList<Institute> institutes = Logic.fillArrayList();
        if ((days % 2) == 0) {
            switch (dayOfWeek) {
                /*
                 *1 - воскресенье
                 *2 - понедельник
                 *3 - вторник
                 *4 - среда
                 *5 - четверг
                 *6 - пятница
                 *7 - суббота
                 */
                case 1://воскресенье
                case 6:
                case 3:
                    string = "Не учимся";
                    break;
                case 2:
                    string = institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString();
                    break;
                case 4://среда
                    string = institutes.get(7).toString();
                    break;
                case 5://четверг
                    string = institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString();
                    break;
                case 7://суббота
                    string = institutes.get(5).toString();
                    break;
                default:
                    string = "Ошибка conditionOneDay!";
                    break;
            }
        } else {
            switch (dayOfWeek) {
                case 1://воскресенье
                case 6:
                case 3:
                    string = "Не учимся";
                    break;
                case 2:
                    string = institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString();
                    break;
                case 4://среда
                    string = institutes.get(7).toString();
                    break;
                case 5://четверг
                    string = institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString();
                    break;
                case 7://суббота
                    string = institutes.get(5).toString();
                    break;
                default:
                    string = "Ошибка conditionOneDay!";
                    break;
            }
        }
        return string;
    }

    public static String conditionPlusOneDay(int days, int dayOfWeek) {
        String string;
        ArrayList<Institute> institutes = Logic.fillArrayList();
        if ((days % 2) == 0) {
            switch (dayOfWeek) {
                /*
                 *1 - понедельник
                 *2 - вторник
                 *3 - среда
                 *4 - четверг
                 *5 - пятница
                 *6 - суббота
                 *7 - воскресенье
                 */
                case 2:
                case 7:
                case 5:
                    string = "Не учимся";
                    break;
                case 1:
                    string = institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString();
                    break;
                case 3://среда
                    string = institutes.get(7).toString();
                    break;
                case 4://четверг
                    string = institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString();
                    break;
                case 6://суббота
                    string = institutes.get(5).toString();
                    break;
                default:
                    string = "Ошибка conditionOneDay!";
                    break;
            }
        } else {
            switch (dayOfWeek) {
                case 2:
                case 7:
                case 5:
                    string = "Не учимся";
                    break;
                case 1:
                    string = institutes.get(6).toString() + institutes.get(4).toString() + institutes.get(4).toString() + institutes.get(6).toString();
                    break;
                case 3://среда
                    string = institutes.get(7).toString();
                    break;
                case 4://четверг
                    string = institutes.get(1).toString() + institutes.get(1).toString() + institutes.get(5).toString() + institutes.get(5).toString();
                    break;
                case 6://суббота
                    string = institutes.get(5).toString();
                    break;
                default:
                    string = "Ошибка conditionOneDay!";
                    break;
            }
        }
        return string;
    }
}
