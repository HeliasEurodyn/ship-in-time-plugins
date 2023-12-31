package com.ed.tenacityxml.dto.user;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginDTO {
  private String username;
  private String password;
}
