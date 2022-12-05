package org.supermarket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceMessage {
    private String message;
    private String example;
    private String finish;
}
