package com.spring.sneakzoneofflineboot.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequest {
     private String username;
     private String password;
}
