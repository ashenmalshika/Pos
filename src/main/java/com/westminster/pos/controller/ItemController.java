package com.westminster.pos.controller;

import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.response.ItemGetResponseDTO;
import com.westminster.pos.service.impl.ItemServiceIMPL;
import com.westminster.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemServiceIMPL itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message=itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
          new StandardResponse(201,"sucess",message), HttpStatus.CREATED
        );
        return response;
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
