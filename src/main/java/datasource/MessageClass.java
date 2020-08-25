package datasource;

import lombok.Getter;

@Getter
public class MessageClass {
    public MessageClass(){
        topicOfMessage = "topic";
        addressee = "locatortest@yandex.by";
        message = "sometext";
    }
    public MessageClass(String topicOfMess, String addres, String mess){
        topicOfMessage = topicOfMess;
        addressee = addres;
        message = mess;
    }
    private String topicOfMessage;
    private String addressee;
    private String message;
}
