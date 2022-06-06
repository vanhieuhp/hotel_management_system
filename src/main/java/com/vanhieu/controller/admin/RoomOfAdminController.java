package com.vanhieu.controller.admin;

import com.vanhieu.dto.RoomDto;
import com.vanhieu.service.IRoomService;
import com.vanhieu.util.MessageUtils;
import com.vanhieu.util.PageUtils;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RoomOfAdminController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/admin/room/list")
    public String showRoomList(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           HttpServletRequest request,
                           Model model) {
        RoomDto roomModel = new RoomDto();
        Pageable pageable = PageRequest.of(page - 1, limit);
        if (roomService.findAll(pageable).size() == 0 && page > 1) {
            page --;
            pageable = PageRequest.of(page - 1, limit);
        }
        roomModel.setListResult(roomService.findAll(pageable));
        roomModel.setTotalItem(roomService.count());
        roomModel = PageUtils.getModel(roomModel, page, limit);
        String message = request.getParameter("message");
        if (message != null) {
            Map<String, String> messages = MessageUtils.getMessage(message);
            model.addAttribute("message", messages.get("message"));
            model.addAttribute("alert", messages.get("alert"));
        }
            model.addAttribute("roomModel", roomModel);
        return "views/admin/room/list";
    }

    @GetMapping("/admin/room/edit")
    public String showEditPage(HttpServletRequest request,
                               Model model) {
        RoomDto roomModel = new RoomDto();
        Long categoryCheck = null;
        if (request.getParameter("id") != null) {
            Long id = Long.valueOf(request.getParameter("id"));
            roomModel = roomService.getOne(id);
            categoryCheck = roomModel.getCategory().getId();
        }
        roomModel.setPage(PageUtils.getPage(roomService.count(), 5));
        model.addAttribute("roomModel", roomModel);
        model.addAttribute("categoryCheck", categoryCheck);
        model.addAttribute("categories", ViewModelUtils.getCategories());
        return "views/admin/room/edit";
    }
}
