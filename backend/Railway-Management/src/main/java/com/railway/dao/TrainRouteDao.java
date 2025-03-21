package com.railway.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.dto.SearchByStationCodeResDto;
import com.railway.dto.TrainScheduleDto;
import com.railway.entity.Station;
import com.railway.entity.Train;
import com.railway.entity.TrainRoute;

@Repository
public interface TrainRouteDao extends JpaRepository<TrainRoute, Long> {
	
	@Query("SELECT NEW com.railway.dto.SearchByStationCodeResDto(r.trainNumber.trainNumber, t.trainName, "
			+ "r.arrivalTime, r.departureTime, t.stationFrom, t.stationTo, r.haltTime) "
			+ "FROM TrainRoute r, Train t "
			+ "WHERE t.trainNumber = r.trainNumber.trainNumber AND r.stationCode.stationCode=:stationCode")
	List<SearchByStationCodeResDto> searchBySataionCode(String stationCode);
	
	@Query("SELECT NEW com.railway.dto.TrainScheduleDto( r.stnSerialNumber, s.stationName, s.stationCode, "
			+ "r.distance, r.arrivalTime, r.departureTime, r.haltTime, r.routeNumber, r.dayCount) "
			+ "from TrainRoute r, Station s "
			+ "where r.stationCode.stationCode = s.stationCode and r.trainNumber.trainNumber=:trainNumber")
	List<TrainScheduleDto> getTrainSchedule(String trainNumber);

	TrainRoute findByTrainNumberAndStationCode(Train trainNumber, Station station);

}
