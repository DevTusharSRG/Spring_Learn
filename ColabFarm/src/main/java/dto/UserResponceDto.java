package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponceDto {

    private int userId;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String typeOfUser;
    private String createDate; // Can be Timestamp if needed, here kept as formatted String for simplicity
}
