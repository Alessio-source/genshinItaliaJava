package com.genshinItalia.services;

import com.genshinItalia.entity.Streammer;
import com.genshinItalia.repositories.StreammersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreammersService {
    @Autowired
    private StreammersRepository streammersRepository;

    public List<Streammer> getAllStreamers() {
        return streammersRepository.findAll();
    }
}
