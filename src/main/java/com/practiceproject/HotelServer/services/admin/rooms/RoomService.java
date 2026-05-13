package com.practiceproject.HotelServer.services.admin.rooms;

import com.practiceproject.HotelServer.dtos.RoomDto;

public interface RoomService {
    boolean postRoom(RoomDto roomDto);
}
