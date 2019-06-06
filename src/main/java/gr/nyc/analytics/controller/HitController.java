package gr.nyc.analytics.controller;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.nyc.analytics.entity.HitStatistics;
import gr.nyc.analytics.entity.WebsiteInfo;
import gr.nyc.analytics.model.HitInfo;
import gr.nyc.analytics.repository.StatisticsRepository;
import gr.nyc.analytics.repository.WebsiteRepository;

@Controller
public class HitController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(HitController.class);
	
	private final WebsiteRepository websiteRepository;
	private final StatisticsRepository statsRepository;

	@Autowired
	public HitController(WebsiteRepository websiteRepository,
			StatisticsRepository statsRepository)
	{
		this.websiteRepository = websiteRepository;
		this.statsRepository = statsRepository;
	}
	
	@RequestMapping("/hit")
	public ResponseEntity<Object> hit(HitInfo info)
	{
		UUID trackingId = UUID.fromString(info.getTrackingId());
		Optional<WebsiteInfo> wi = websiteRepository.findById(trackingId);
		if (wi.isPresent())
		{
			LOGGER.debug("Received a hit with trackingId {} from {} at {}",
					info.getTrackingId(), info.getIp(), info.getHitDate());
			
			statsRepository.save(new HitStatistics(info.getTrackingId(), info.getHitDate(), info.getIp()));
			return ResponseEntity.ok().build();
		}
		else
		{
			LOGGER.debug("Received a hit wiht unregistered trackingId! {}", info.getTrackingId());
			return ResponseEntity.badRequest().build();
		}
	}
}
