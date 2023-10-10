package ae.rak.service;

import java.util.stream.Collectors;

import java.util.List;

import ae.rak.dto.ProfileDTO;
import ae.rak.entity.ProfileEntity;
import ae.rak.mapper.ProfileMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfileService {
    @Inject
    ProfileMapper profileMapper;

    @Transactional
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = profileMapper.toEntity(profileDTO);
        profileEntity.persist();
        return profileMapper.toDTO(profileEntity);
    }

    public List<ProfileDTO> getAllProfiles() {
        List<ProfileEntity> entities = ProfileEntity.listAll();
        return entities.stream().map(profileMapper::toDTO).collect(Collectors.toList());
    }

    public ProfileDTO getProfileByUsername(String userName) {
        PanacheQuery<ProfileEntity> query = ProfileEntity.find("userName", userName);
        ProfileEntity profileEntity = query.firstResult();
        
        if (profileEntity != null) {
            return profileMapper.toDTO(profileEntity);
        }
        
        return null;
    }

    @Transactional
    public ProfileDTO updateProfileByUsername(String username, ProfileDTO profileDTO) {
        ProfileEntity profileEntity = ProfileEntity.find("userName", username).firstResult();

        if (profileEntity == null) {
            return null;
        }
        
       profileMapper.updateEntityFromDto(profileEntity, profileDTO);
        
        profileEntity.persistAndFlush();

        return profileMapper.toDTO(profileEntity);
    }
    
}
