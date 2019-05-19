public class Institute {
    private String Cabinet;
    private String lesson;
    private String fullNameTeacher;

    public Institute(String Cabinet, String lesson, String fullNameTeacher) {
        this.Cabinet = Cabinet;
        this.lesson = lesson;
        this.fullNameTeacher = fullNameTeacher;
    }

    @Override
    public String toString() {
        return "\n" + "\u2705 " + "Номер кабинета: " + Cabinet + "\n" +
                "\uD83D\uDCDA " + "Урок: " + lesson + "\n" +
                "\uD83E\uDD13 " + "ФИО учителя: " + fullNameTeacher + "\n";
    }
}
