package com.demo.Demo.service;

import com.demo.Demo.dto.ItemDTO;
import com.demo.Demo.paginated.PaginatedResponseItemDTO;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);
    List<ItemDTO> getItemByNameIfActive(String name);

    List<ItemDTO> getItemByNameByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemByNameByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
