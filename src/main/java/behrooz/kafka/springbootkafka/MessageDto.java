package behrooz.kafka.springbootkafka;

public class MessageDto {

    private int id;
    private String date;

    public MessageDto() {
    }

    public MessageDto(int id, String date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
