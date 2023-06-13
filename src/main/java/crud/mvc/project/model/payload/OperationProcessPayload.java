package crud.mvc.project.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OperationProcessPayload {
    public String senderName;
    public String receiverName;
    public String code;

}
