package com.demo.Demo.controller;

import com.demo.Demo.dto.ItemDTO;
import com.demo.Demo.paginated.PaginatedResponseItemDTO;
import com.demo.Demo.service.ItemService;
import com.demo.Demo.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/item")
public class ItemController {
    @Autowired
   private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDTO itemDTO) {
        String message = itemService.saveItem(itemDTO);
        return new ResponseEntity<>(
                new StandardResponse(201,"success",message), HttpStatus.CREATED
        );
    }

    @GetMapping(value = "/get-by-name",params = "name") //if get only active
    public List<ItemDTO> getItemIfActive(@RequestParam(value = "name") String name){
        return itemService.getItemByNameIfActive(name);
    }
 
    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemssByStatus(
            @RequestParam(value = "activeStatus")boolean activeStatus,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(40) int size
    ){
        //List<ItemDTO> itemDTOList=itemService.getItemByNameByActiveStatus(activeStatus,page,size);
        PaginatedResponseItemDTO paginatedResponseItemDTO=itemService.getItemByNameByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<>(
                new StandardResponse(200,"success",paginatedResponseItemDTO ),
                HttpStatus.OK
        );
    }
}
