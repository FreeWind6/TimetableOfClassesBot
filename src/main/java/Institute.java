public class Institute {
    private int idCabinet;
    private String lesson;
    private String fullNameTeacher;

    public Institute(int idCabinet, String lesson, String fullNameTeacher) {
        this.idCabinet = idCabinet;
        this.lesson = lesson;
        this.fullNameTeacher = fullNameTeacher;
    }

    @Override
    public String toString() {
        return "Номер кабинета: " + idCabinet + "\n" +
                "Урок: " + lesson + "\n" +
                "ФИО учителя: " + fullNameTeacher;
    }
}
