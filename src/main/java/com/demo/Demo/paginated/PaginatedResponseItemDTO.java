package com.demo.Demo.paginated;

import com.demo.Demo.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseItemDTO {
    private List<ItemDTO> itemDTOList;
    private long dataCount;

}
