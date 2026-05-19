package com.practiceproject.HotelServer.services.admin.rooms;

import com.practiceproject.HotelServer.dtos.RoomDto;
import com.practiceproject.HotelServer.dtos.RoomsResponseDto;

public interface RoomService {
    boolean postRoom(RoomDto roomDto);
    RoomsResponseDto getAllRooms(int pageNumber);
}
