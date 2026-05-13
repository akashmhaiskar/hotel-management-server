package com.practiceproject.HotelServer.services.admin.rooms;


import com.practiceproject.HotelServer.dtos.RoomDto;
import com.practiceproject.HotelServer.entity.Room;
import com.practiceproject.HotelServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
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
}
