package com.jhanp.gestioneventos.mapper;

import com.jhanp.gestioneventos.domain.entity.*;
import com.jhanp.gestioneventos.domain.view.*;
import com.jhanp.gestioneventos.dto.request.*;
import com.jhanp.gestioneventos.dto.response.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapper {

    public static RegistrationResponseDTO toResponseDTO(Registration registration) {
        if (registration == null)  return null;

            UserResponseDTO userResponseDTO = toResponseDTO(registration.getUser());
            EventAccessResponseDTO eventAccessResponseDTO = toResponseDTO(registration.getEventAccess());

        return RegistrationResponseDTO.builder()
                .id(registration.getId())
                .RegistrationDate(registration.getRegistrationDate())
                .registrationStatus(registration.getRegistrationStatus())
                .attendance(registration.getAttendance())
                .active(registration.getActive())
                .user(userResponseDTO)
                .eventAccess(eventAccessResponseDTO)
                .build();
    }

    public static AccessTypeResponseDTO toResponseDTO (AccessType accessType) {
        if (accessType == null) return null;

        return AccessTypeResponseDTO.builder()
                .id(accessType.getId())
                .name(accessType.getName())
                .description(accessType.getDescription())
                .active(accessType.getActive())
                .build();
    }

    // Events toDTO
    public static EventResponseDTO toResponseDTO (Event event){
        if(event == null) return null;

        EventTypeResponseDTO eventTypeResponse = toResponseDTO(event.getEventType());
        OrganizationResponseDTO organizationResponseDTO = toResponseDTO(event.getOrganization());

        ArrayList <EventAccessResponseDTO> eventAccesses = event.getAccesses() == null ? new ArrayList<>() :
                (ArrayList<EventAccessResponseDTO>) event.getAccesses().stream()
                        .map(Mapper::toResponseDTO)
                        .toList();

        return EventResponseDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .address(event.getAddress())
                .place(event.getPlace())
                .date(event.getDate())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .capacity(event.getCapacity())
                .accessRestriction(event.getAccessRestriction())
                .eventStatus(event.getEventStatus())
                .active(event.getActive())
                .eventType(eventTypeResponse)
                .organization(organizationResponseDTO)
                .eventAccessList(eventAccesses)
                .build();
    }

    public static EventTypeResponseDTO toResponseDTO (EventType eventType){
        if(eventType == null) return null;

        return EventTypeResponseDTO.builder()
                .id(eventType.getId())
                .name(eventType.getName())
                .description(eventType.getDescription())
                .active(eventType.getActive())
                .build();
    }

    public static EventRoleResponseDTO toResponseDTO (EventRole eventRole) {
        if (eventRole == null) return null;

        return EventRoleResponseDTO.builder()
                .id(eventRole.getId())
                .name(eventRole.getName())
                .description(eventRole.getDescription())
                .active(eventRole.getActive())
                .build();
    }

    public static EventAccessResponseDTO toResponseDTO (EventAccess eventAccess){
        if (eventAccess == null) return null;

        EventResponseDTO eventResponseDTO = toResponseDTO(eventAccess.getEvent());
        AccessTypeResponseDTO accessTypeResponseDTO = toResponseDTO(eventAccess.getAccessType());

        ArrayList <RegistrationResponseDTO> registrationResponseDTO = eventAccess.getRegistrations() == null ? new ArrayList<>() :
                (ArrayList<RegistrationResponseDTO>) eventAccess.getRegistrations().stream()
                        .map(Mapper::toResponseDTO)
                        .toList();

        return EventAccessResponseDTO.builder()
                .id(eventAccess.getId())
                .price(eventAccess.getPrice())
                .spots(eventAccess.getSpots())
                .accessStatus(eventAccess.getAccessStatus())
                .active(eventAccess.getActive())
                .event(eventResponseDTO)
                .access(accessTypeResponseDTO)
                .registrations(registrationResponseDTO)
                .build();
    }

    // Organizations toDTO
    public static OrganizationResponseDTO toResponseDTO(Organization organization){
        if(organization == null) return null;

        OrganizationTypeResponseDTO organizationTypeResponseDTO = toResponseDTO(organization.getOrganizationType());

        ArrayList <EventResponseDTO> events = organization.getEvents() == null ? new ArrayList<>() :
                (ArrayList<EventResponseDTO>) organization.getEvents().stream()
                        .map(Mapper::toResponseDTO)
                        .toList();

        ArrayList <UserOrganizationResponseDTO> members = organization.getMembers() == null ? new ArrayList<>() :
                (ArrayList<UserOrganizationResponseDTO>) organization.getMembers().stream()
                        .map(Mapper::toResponseDTO)
                        .toList();

        ArrayList <InvitationOrganizationEventResponseDTO> invitations = organization.getInvitations()== null ? new ArrayList<>() :
                (ArrayList<InvitationOrganizationEventResponseDTO>) organization.getInvitations().stream()
                        .map(Mapper::toResponseDTO)
                        .toList();

        return OrganizationResponseDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .organizationType(organizationTypeResponseDTO)
                .active(organization.getActive())
                .events(events)
                .members(members)
                .invitations(invitations)
                .build();
    }

    public static OrganizationTypeResponseDTO toResponseDTO (OrganizationType organizationType){
        if(organizationType == null) return null;

        return OrganizationTypeResponseDTO.builder()
                .id(organizationType.getId())
                .name(organizationType.getName())
                .description(organizationType.getDescription())
                .active(organizationType.getActive())
                .build();
    }

    public static InvitationOrganizationEventResponseDTO toResponseDTO (InvitationOrganizationEvent invitationOrganizationEvent){
        if(invitationOrganizationEvent == null) return null;

        EventResponseDTO eventResponseDTO = toResponseDTO(invitationOrganizationEvent.getEvent());
        OrganizationResponseDTO organizationResponseDTO = toResponseDTO(invitationOrganizationEvent.getOrganization());

        return InvitationOrganizationEventResponseDTO.builder()
                .id(invitationOrganizationEvent.getId())
                .event(eventResponseDTO)
                .organization(organizationResponseDTO)
                .invitationStatus(invitationOrganizationEvent.getInvitationStatus())
                .sentDate(invitationOrganizationEvent.getSentDate())
                .active(invitationOrganizationEvent.getActive())
                .build();
    }

    // Users to DTO
    public static UserResponseDTO toResponseDTO(User user) {
        if (user == null) return null;

        List<UserOrganizationResponseDTO> userOrganizationResponseDTO = user.getOrganizations() == null ? new ArrayList<>() :
                user.getOrganizations().stream().map(Mapper::toResponseDTO).toList();

        List<InvitationUserEventResponseDTO> invitationUserResponseDTO = user.getInvitations() == null ? new ArrayList<>() :
                user.getInvitations().stream().map(Mapper::toResponseDTO).toList();

        List<UserSystemRoleResponseDTO> userSystemRoleResponseDTO = user.getUserSystemRoles() == null ? new ArrayList<>() :
                user.getUserSystemRoles().stream().map(Mapper::toResponseDTO).toList();

        List<RegistrationResponseDTO> registrationResponseDTO = user.getRegistrations() == null ? new ArrayList<>() :
                user.getRegistrations().stream().map(Mapper::toResponseDTO).toList();

        return UserResponseDTO.builder()
                .idUser(user.getId())
                .typeIdentification(user.getIdentificationType())
                .numberIdentification(user.getIdentificationNumber())
                .name(user.getFirstName())
                .lastName(user.getLastName())
                .secondLastName(user.getSecondLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .organizations(userOrganizationResponseDTO)
                .invitations(invitationUserResponseDTO)
                .userSystemRoles(userSystemRoleResponseDTO)
                .registrations(registrationResponseDTO)
                .active(user.getActive())
                .build();
    }

    public static UserOrganizationResponseDTO toResponseDTO (UserOrganization userOrganization){
        if (userOrganization == null) return null;

        UserResponseDTO userResponseDTO = toResponseDTO(userOrganization.getUser());
        OrganizationResponseDTO organizationResponseDTO = toResponseDTO(userOrganization.getOrganization());
        return UserOrganizationResponseDTO.builder()
                .idUserOrganization(userOrganization.getId())
                .userResponseDTO(userResponseDTO)
                .organizationResponseDTO(organizationResponseDTO)
                .OrganizationRole(userOrganization.getRoleInOrganization())
                .active(userOrganization.getActive())
                .build();
    }

    public static UserEventRoleResponseDTO toResponseDTO (UserEventRole userEventRole) {
        if (userEventRole == null) return null;

        UserResponseDTO userResponseDTO = toResponseDTO(userEventRole.getUser());
        EventResponseDTO eventResponseDTO = toResponseDTO(userEventRole.getEvent());
        EventRoleResponseDTO eventRoleResponseDTO = toResponseDTO(userEventRole.getEventRole());

        return UserEventRoleResponseDTO.builder()
                .id(userEventRole.getId())
                .user(userResponseDTO)
                .event(eventResponseDTO)
                .eventRole(eventRoleResponseDTO)
                .active(userEventRole.getActive())
                .build();
    }

    public static InvitationUserEventResponseDTO toResponseDTO (InvitationUserEvent invitationUserEvent){
        if (invitationUserEvent == null) return null;

        UserResponseDTO userResponseDTO = toResponseDTO(invitationUserEvent.getUser());
        EventResponseDTO eventResponseDTO = toResponseDTO(invitationUserEvent.getEvent());

        return InvitationUserEventResponseDTO.builder()
                .id(invitationUserEvent.getId())
                .event(eventResponseDTO)
                .user(userResponseDTO)
                .invitationStatus(invitationUserEvent.getInvitationStatus())
                .sentDate(invitationUserEvent.getSentDate())
                .active(invitationUserEvent.getActive())
                .build();
    }

    public static UserSystemRoleResponseDTO toResponseDTO (UserSystemRole userSystemRole){
        if(userSystemRole == null) return null;

        UserResponseDTO userResponseDTO = toResponseDTO(userSystemRole.getUser());
        SystemRoleResponseDTO systemRoleResponseDTO = toResponseDTO(userSystemRole.getSystemRole());

        return UserSystemRoleResponseDTO.builder()
                .idUserSystemRole(userSystemRole.getId())
                .user(userResponseDTO)
                .systemRole(systemRoleResponseDTO)
                .build();
    }

    public static SystemRoleResponseDTO toResponseDTO (SystemRole systemRole) {
        if (systemRole == null) return null;

        return SystemRoleResponseDTO.builder()
                .id(systemRole.getId())
                .name(systemRole.getName())
                .description(systemRole.getDescription())
                .active(systemRole.getActive())
                .build();
    }
    // VISTAS → DTO

    public static EventResponseDTO toResponseDTO(ActiveEventsView view) {
        if (view == null) return null;

        EventTypeResponseDTO eventTypeResponseDTO = EventTypeResponseDTO.builder()
                .name(view.getEventType())
                .build();

        OrganizationResponseDTO organizationResponseDTO = OrganizationResponseDTO.builder()
                .name(view.getOrganization())
                .build();

        return EventResponseDTO.builder()
                .id(view.getId())
                .name(view.getName())
                .description(view.getDescription())
                .address(view.getAddress())
                .place(view.getPlace())
                .date(view.getDate())
                .startTime(view.getStartTime())
                .endTime(view.getEndTime())
                .capacity(view.getCapacity())
                .accessRestriction(view.getAccessRestriction())
                .eventStatus(view.getEventStatus())
                .eventType(eventTypeResponseDTO)
                .organization(organizationResponseDTO)
                .eventAccessList(new ArrayList<>())
                .build();
    }

    public static EventResponseDTO toResponseDTO(CancelledEventsView view) {
        if (view == null) return null;

        EventTypeResponseDTO eventTypeResponseDTO = EventTypeResponseDTO.builder()
                .name(view.getEventType())
                .build();

        OrganizationResponseDTO organizationResponseDTO = OrganizationResponseDTO.builder()
                .name(view.getOrganization())
                .build();

        return EventResponseDTO.builder()
                .id(view.getId())
                .name(view.getName())
                .description(view.getDescription())
                .address(view.getAddress())
                .place(view.getPlace())
                .date(view.getDate())
                .eventStatus(view.getEventStatus())
                .eventType(eventTypeResponseDTO)
                .organization(organizationResponseDTO)
                .eventAccessList(new ArrayList<>())
                .build();
    }

    public static EventAccessResponseDTO toResponseDTO(AvailableAccessView view) {
        if (view == null) return null;

        EventResponseDTO eventResponseDTO = EventResponseDTO.builder()
                .id(view.getIdEvent())
                .name(view.getEventName())
                .date(view.getDate())
                .eventStatus(view.getEventStatus())
                .build();

        AccessTypeResponseDTO accessTypeResponseDTO = AccessTypeResponseDTO.builder()
                .name(view.getAccessType())
                .build();

        return EventAccessResponseDTO.builder()
                .id(view.getIdEventAccess())
                .price(view.getPrice())
                .spots(view.getAvailable_spots())
                .accessStatus(view.getAccessStatus())
                .event(eventResponseDTO)
                .access(accessTypeResponseDTO)
                .registrations(new ArrayList<>())
                .build();
    }

    public static UserResponseDTO toResponseDTO(ActiveUsersView view) {
        if (view == null) return null;

        return UserResponseDTO.builder()
                .idUser(view.getId())
                .typeIdentification(view.getIdentificationType())
                .numberIdentification(view.getIdentificationNumber())
                .name(view.getFirstName())
                .lastName(view.getLastName())
                .secondLastName(view.getSecondLastName())
                .phone(view.getPhone())
                .email(view.getEmail())
                .build();
    }

    public static EventAccessResponseDTO toResponseDTO(DetailEventView view) {
        if (view == null) return null;

        EventResponseDTO eventResponseDTO = EventResponseDTO.builder()
                .id(view.getIdEvent())
                .name(view.getName())
                .address(view.getAddress())
                .place(view.getPlace())
                .date(view.getDate())
                .startTime(view.getStartTime())
                .endTime(view.getEndTime())
                .capacity(view.getCapacity())
                .accessRestriction(view.getAccessRestriction())
                .eventStatus(view.getEventStatus())
                .eventType(EventTypeResponseDTO.builder().name(view.getEventType()).build())
                .organization(OrganizationResponseDTO.builder().name(view.getOrganization()).build())
                .build();

        AccessTypeResponseDTO accessTypeResponseDTO = AccessTypeResponseDTO.builder()
                .name(view.getAccessType())
                .build();

        return EventAccessResponseDTO.builder()
                .price(view.getPrice())
                .spots(view.getAvailableSpots())
                .accessStatus(view.getAccessStatus())
                .event(eventResponseDTO)
                .access(accessTypeResponseDTO)
                .registrations(new ArrayList<>())
                .build();
    }
}
