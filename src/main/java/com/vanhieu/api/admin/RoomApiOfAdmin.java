package com.vanhieu.api.admin;

import com.vanhieu.dto.RoomDto;
import com.vanhieu.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Controller
public class RoomApiOfAdmin {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/api/admin/room")
    public String getRoomList(@RequestParam("page") int page,
                              @RequestParam("limit") int limit,
                              HttpServletRequest request) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        List<RoomDto> rooms = roomService.findAll(pageable);
        StringBuilder string = new StringBuilder("<tbody id=\"table_body\">");
        for (RoomDto room : rooms) {
            string.append(
                    "<tr>\n" +
                    "  <td>\n" +
                    "  <input data-toggle=\"tooltip\" id=\"checkbox_" +room.getId()+"\"\n" +
                    "         title=\"Select item" +room.getId()+ "\" name=\"select\"\n" +
                    "         value=\""+room.getId()+"\" type=\"checkbox\">\n" +
                    "  </td>\n" +
                    "  <td>"+room.getId()+"</td>\n" +
                    "  <td>"+room.getRoomNumber()+"</td>\n" +
                    "  <td>"+room.getStatus()+"</td>\n" +
                    "  <td>"+room.getCategory().getName()+"</td>\n" +
                    "  <td>\n" +
                    "  <a class=\"btn btn-primary btn-user\" data-toggle=\"tooltip\"\n" +
                    "             href=\"/admin/room/edit?id=" +room.getId()+"\"\n" +
                    "             title=\"Edit news\"> <i class=\"fas fa-edit\"></i>\n" +
                    "  </a>\n" +
                    "  </td>\n" +
                    "</tr>");
        }
        string.append("</tbody");
        return string.toString();
    }

    @PostMapping("/api/admin/room")
    public RoomDto createRoom(@RequestBody RoomDto roomDto) {
        return roomService.save(roomDto);
    }

    @PutMapping("/api/admin/room")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return  roomService.update(roomDto);
    }

    @DeleteMapping("/api/admin/room")
    public void deleteRoom(@RequestBody Long[] ids) {
        roomService.delete(ids);
    }


}
