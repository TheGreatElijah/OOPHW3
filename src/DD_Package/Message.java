package DD_Package;

public class Message {
    protected String message;
    public Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}