package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import com.example.demo.controller.Coach;
import com.example.demo.repository.CoachEntity;

@Mapper(componentModel = "spring", uses = {PokemonMapper.class})
public interface CoachMapper {
	

	Coach CoachEntityToCoach(CoachEntity coachEntity);

	CoachEntity CoachToCoachEntity(Coach coach);

	List<Coach> CoachEntityListToCoachList (List<CoachEntity> coachEntityList);
}
