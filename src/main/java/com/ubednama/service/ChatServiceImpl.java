package com.ubednama.service;

import com.ubednama.modal.Chat;
import com.ubednama.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
    private ChatRepository chatRepository;
    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }
}
