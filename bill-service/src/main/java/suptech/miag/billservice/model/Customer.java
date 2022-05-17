package suptech.miag.billservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Long id ;
    private String name ;
    private String email ;
}
