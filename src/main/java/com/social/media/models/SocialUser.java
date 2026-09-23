//We use @JsonIgnore to exclude specific fields or methods from being processed during JSON serialization and deserialization to avoid recursive values

package com.social.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(mappedBy = "socialUser", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "social_profile_id")
    private SocialProfile socialProfile;

    @OneToMany(
            mappedBy = "socialUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "gorup_id")
    )

    private Set<SocialGroup> socialGroups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(Id);
    }

    public void setSocialProfile(SocialProfile socialProfile){
        this.socialProfile = socialProfile;
        socialProfile.setSocialUser(this);
    }
}
