package dom.andrei.vikingsapp.controller.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private final HttpStatus status;
    private final String description;
}
