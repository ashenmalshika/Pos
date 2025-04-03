package com.westminster.pos.util.mappers;

import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.response.ItemGetResponseDTO;
import com.westminster.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    ItemGetResponseDTO entityToDto(Item item);

    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO>ListDTOToPage(Page<Item> items);
}
