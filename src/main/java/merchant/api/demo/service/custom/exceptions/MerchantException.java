package merchant.api.demo.service.custom.exceptions;

import org.springframework.http.HttpStatus;

public class MerchantException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public MerchantException(String message) {
        super();
        this.message = message;
    }

    public MerchantException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
