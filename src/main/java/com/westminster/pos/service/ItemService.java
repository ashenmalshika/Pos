package com.westminster.pos.service;

import com.westminster.pos.dto.paginated.PaginatedResponseItemDTO;
import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByStatus(boolean status);

    PaginatedResponseItemDTO getItemByStatusWithPagination(boolean status, int page, int size);
}
