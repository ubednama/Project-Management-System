package com.ubednama.controller;

import com.ubednama.modal.Chat;
import com.ubednama.modal.Message;
import com.ubednama.modal.User;
import com.ubednama.request.CreateMessageRequest;
import com.ubednama.service.MessageService;
import com.ubednama.service.ProjectService;
import com.ubednama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) throws Exception{
        User user = userService.findUserById(request.getSenderId());

        Chat chats = projectService.getProjectById(request.getProjectId()).getChat();
        if(chats == null) throw new Exception("Chat not found");

        Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(),
        request.getContent());
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId) throws Exception{
        List<Message> messages = messageService.getMessagesByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}
