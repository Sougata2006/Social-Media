package com.social.media.services;

import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public SocialUser deleteUser(Long userId) {
        SocialUser socialUser = socialUserRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found !!"));
        socialUserRepository.deleteById(userId);
        return socialUser;
    }
}
