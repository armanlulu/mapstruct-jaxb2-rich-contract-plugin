package org.example;

import org.example.dto.WidgetContainerDto;
import org.mapstruct.Mapper;
import org.sample.xml.WidgetContainer;

@Mapper
public interface WidgetContainerMapper {

    WidgetContainer toContainer(WidgetContainerDto dto);

    WidgetContainerDto toDto(WidgetContainer container);
}
