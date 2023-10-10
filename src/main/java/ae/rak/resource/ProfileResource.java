package ae.rak.resource;

import java.util.List;

import ae.rak.dto.ProfileDTO;
import ae.rak.service.ProfileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    ProfileService profileService;

    @POST
    public Response createProfile(ProfileDTO profile) {
        ProfileDTO profileDTO = profileService.createProfile(profile);
        return Response.status(Response.Status.CREATED).entity(profileDTO).build();
    }

    @GET
    public Response getProfileByUsername(@QueryParam("username") String username) {

        if (username != null && !username.isEmpty()) {
            ProfileDTO profile = profileService.getProfileByUsername(username);
            if (profile != null) {
                return Response.ok(profile).build();
            }

        } else {

            List<ProfileDTO> profiles = profileService.getAllProfiles();
            return Response.ok(profiles).build();
        }
        return Response.noContent().build();

    }

    @PATCH
    public Response updateProfileByUsername(@QueryParam("username") String username, ProfileDTO profileDTO) {
        ProfileDTO updatedProfile = profileService.updateProfileByUsername(username, profileDTO);

        if (updatedProfile != null) {
            return Response.status(Response.Status.OK).entity(updatedProfile).build();
        }

        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

}
