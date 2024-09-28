package com.spring.sneakzoneofflineboot.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
     String accessToken;
     Boolean authenticated;
}
