package com.westminster.pos.service.impl;

import com.westminster.pos.dto.paginated.PaginatedResponseItemDTO;
import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.response.ItemGetResponseDTO;
import com.westminster.pos.entity.Item;
import com.westminster.pos.exception.NotFoundException;
import com.westminster.pos.repo.ItemRepo;
import com.westminster.pos.service.ItemService;
import com.westminster.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return "Item Saved";
        }else{
            throw new DuplicateKeyException("Item Already Exists");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        List<Item> items= itemRepo.findAllByItemNameEqualsAndActiveStatusEquals(itemName,true);
        if(items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item Not Found");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByStatus(boolean status) {
        List<Item> items= itemRepo.findAllByActiveStatusEquals(status);
        if(items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item Not Found");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByStatusWithPagination(boolean status, int page, int size) {
        Page<Item> items= (Page<Item>) itemRepo.findAllByActiveStatusEquals(status, PageRequest.of(page,size));
        if(items.getSize()<1){
            throw new NotFoundException("No Data Found.");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO=new PaginatedResponseItemDTO(
                itemMapper.ListDTOToPage(items),itemRepo.countAllByActiveStatusEquals(status)
        );
        return paginatedResponseItemDTO;
    }
}
