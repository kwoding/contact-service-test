package it.ding.contact.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseBody {

    private Date timestamp;

    private Integer status;

    private String error;

    private Map<String, String> fieldErrors;

    private String message;

}
