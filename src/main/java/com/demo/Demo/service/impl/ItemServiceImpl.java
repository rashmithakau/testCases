package com.demo.Demo.service.impl;

import com.demo.Demo.dto.ItemDTO;
import com.demo.Demo.entiry.ItemEntity;
import com.demo.Demo.exception.NotFoundException;
import com.demo.Demo.paginated.PaginatedResponseItemDTO;
import com.demo.Demo.repositary.ItemRepositary;
import com.demo.Demo.service.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private ItemRepositary itemRepositary;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = modelMapper.map(itemDTO, ItemEntity.class);
        itemRepositary.save(itemEntity);
        return "Successfully saved Item id : " + itemEntity.getItemId();
    }

    @Override
    public List<ItemDTO> getItemByNameIfActive(String itemName) {
        if (itemRepositary.existsByItemName(itemName)) {

            List<ItemEntity> itemEntityList = itemRepositary.findAllByItemNameEqualsAndActiveStateEquals(itemName, true);
            List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();


            if (itemEntityList.size() > 0) {

                //itemDTOList=modelMapper.map(itemEntityList,new TypeToken<List<ItemDTO>>(){}.getType());//to convert list

                for (ItemEntity itemEntity : itemEntityList) {
                    itemDTOList.add(modelMapper.map(itemEntity, ItemDTO.class));
                }
            }


            return itemDTOList;

        } else {
            throw new RuntimeException("Item Not Found");
        }
    }

    @Override
    public List<ItemDTO> getItemByNameByActiveStatus(boolean activeStatus) {
        List<ItemEntity> itemEntityList = itemRepositary.findAllByActiveState(activeStatus);

        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

        if (itemEntityList.size() > 0) {
            //itemDTOList=modelMapper.map(itemEntityList,new TypeToken<List<ItemDTO>>(){}.getType());//to convert list
            for (ItemEntity itemEntity : itemEntityList) {
                itemDTOList.add(modelMapper.map(itemEntity, ItemDTO.class));
            }
            return itemDTOList;
        } else {
            throw new NotFoundException("Item Not Found");
        }

    }

    @Override
    public PaginatedResponseItemDTO getItemByNameByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        // Fetch paginated data
        Page<ItemEntity> items = itemRepositary.findAllByActiveState(activeStatus, PageRequest.of(page, size));

        // Check if the page contains items
        if (items.isEmpty()) {
            throw new NotFoundException("Items not found for the given active status.");
        }

        // Map entities to DTOs
        List<ItemDTO> itemDTOList = modelMapper.map(items.getContent(), new TypeToken<List<ItemDTO>>() {}.getType());

        int count=itemRepositary.countAllByActiveState(activeStatus);

        // Construct and return the response
        return new PaginatedResponseItemDTO(
                itemDTOList,
                count
        );
    }
}
