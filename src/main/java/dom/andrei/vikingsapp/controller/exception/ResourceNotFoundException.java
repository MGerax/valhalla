package dom.andrei.vikingsapp.controller.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private final HttpStatus status;
    private final String description; // huj
}
