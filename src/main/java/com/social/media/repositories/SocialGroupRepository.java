package com.social.media.repositories;

import com.social.media.models.SocialGroup;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {
}
