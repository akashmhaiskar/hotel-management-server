package com.practiceproject.HotelServer.services.admin.rooms;


import com.practiceproject.HotelServer.dtos.RoomDto;
import com.practiceproject.HotelServer.dtos.RoomsResponseDto;
import com.practiceproject.HotelServer.entity.Room;
import com.practiceproject.HotelServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;


    public boolean postRoom(RoomDto roomDto){
        try {
            Room room = new Room();
            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setType(roomDto.getType());
            room.setIsAvailable(true);
            roomRepository.save(room);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public RoomsResponseDto getAllRooms(int pageNumber){

        PageRequest pageable = PageRequest.of(pageNumber, 1);
        Page<Room> roomsPage = roomRepository.findAll(pageable);

        RoomsResponseDto roomsResponseDto = new RoomsResponseDto();
        roomsResponseDto.setPageNumber(roomsPage.getPageable().getPageNumber());
        roomsResponseDto.setTotalPages(roomsPage.getTotalPages());
        roomsResponseDto.setRoomDtoList(roomsPage.stream().map(Room::getRoomDto).toList());
        return roomsResponseDto;
    }
}
