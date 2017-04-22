package com.mdw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdw.controllers.RoomController;
import com.mdw.wrappers.RoomWrapper;

@RestController
@RequestMapping(Uris.VERSION + Uris.ROOM)
public class RoomResource {
    private RoomController roomController;

    @Autowired
    public void setRoomController(RoomController roomController) {
        this.roomController = roomController;
    }

    @RequestMapping(value = Uris.ID, method = RequestMethod.GET)
    public RoomWrapper getRoom(@PathVariable(value = "id") Long id) {
        return roomController.getRoom(id);
    }

}
