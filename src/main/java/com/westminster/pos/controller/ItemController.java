package com.westminster.pos.controller;

import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.response.ItemGetResponseDTO;
import com.westminster.pos.service.impl.ItemServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemServiceIMPL itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message=itemService.saveItem(itemSaveRequestDTO);
        return "save item";
    }

    @GetMapping(
            path="/get-item-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS=itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }
}
