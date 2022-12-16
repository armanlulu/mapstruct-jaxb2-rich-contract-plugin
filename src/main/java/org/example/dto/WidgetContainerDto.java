package org.example.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class WidgetContainerDto {
    List<WidgetDto> widgets;
}
