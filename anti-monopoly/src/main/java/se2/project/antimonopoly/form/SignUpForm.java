package se2.project.antimonopoly.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SignUpForm {

private String userId;
private String password;
private String userName;

// Point : @DateTimeFormat
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date birthday;
}