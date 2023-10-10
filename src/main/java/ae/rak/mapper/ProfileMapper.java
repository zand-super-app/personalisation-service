package ae.rak.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import ae.rak.dto.ProfileDTO;
import ae.rak.dto.ApplicationDTO;
import ae.rak.entity.ProfileEntity;
import ae.rak.entity.ApplicationEntity;

@Mapper(componentModel = "cdi")
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDTO toDTO(ProfileEntity profileEntity);
    ProfileEntity toEntity(ProfileDTO profileDTO);

    ApplicationDTO toDTO(ApplicationEntity applicationEntity);
    ApplicationEntity toEntity(ApplicationDTO applicationDTO);

    void updateEntityFromDto(@MappingTarget ProfileEntity entity, ProfileDTO profile);
}
