package com.sun.jwttutorial.dto;

import lombok.*;

@Getter @ToString
@Builder
@AllArgsConstructor @NoArgsConstructor
public class AuthorityDto {
    private String authorityName;
}
