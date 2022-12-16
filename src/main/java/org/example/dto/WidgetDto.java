package org.example.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WidgetDto {
    String id;
    String name;
    String status;
}
