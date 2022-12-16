package org.example;

import org.example.dto.WidgetContainerDto;
import org.example.dto.WidgetDto;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sample.xml.Status;
import org.sample.xml.Widget;
import org.sample.xml.WidgetContainer;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.instancio.Select.field;

@ExtendWith(InstancioExtension.class)
public class MappersTest {

    private final WidgetContainerMapper mapper = new WidgetContainerMapperImpl();

    @Test
    void toWidgetContainer() {
        //Given
        WidgetContainerDto source = Instancio.of(WidgetContainerDto.class)
                .supply(field(WidgetDto.class, "status"), random -> random.oneOf(Status.values()).name())
                .create();

        // When
        WidgetContainer mapped = mapper.toContainer(source);

        // When
        assertWidgets(mapped.getWidgets(), source.getWidgets());
    }

    @Test
    void toDto() {
        // Given
        WidgetContainer source = Instancio.create(WidgetContainer.class);

        // When
        WidgetContainerDto mapped = mapper.toDto(source);

        // Then
        assertWidgets(source.getWidgets(), mapped.getWidgets());
    }

    private static void assertWidgets(List<Widget> widgets, List<WidgetDto> dtos) {
        assertFalse(widgets.isEmpty());
        assertEquals(widgets.size(), dtos.size());

        for (int i = 0; i < widgets.size(); i++) {
            Widget widget = widgets.get(i);
            WidgetDto dto = dtos.get(i);

            assertEquals(widget.getId(), dto.getId());
            assertEquals(widget.getName(), dto.getName());
            assertEquals(widget.getStatus().name(), dto.getStatus());
        }
    }
}
