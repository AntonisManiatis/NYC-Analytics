package gr.nyc.analytics.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gr.nyc.analytics.entity.WebsiteInfo;
import gr.nyc.analytics.repository.WebsiteRepository;

@Controller
public class SiteController
{
	@Autowired
	private final WebsiteRepository websiteRepository;
	
	public SiteController(WebsiteRepository websiteRepository)
	{
		this.websiteRepository = websiteRepository;
	}
	
	@RequestMapping("/site/view/{trackingId}")
	public ModelAndView viewDataForSite(@PathVariable UUID trackingId)
	{
		Optional<WebsiteInfo> optional = websiteRepository.findById(trackingId);
		if (optional.isPresent())
		{
			WebsiteInfo webInfo = optional.get();
			
			ModelAndView mav = new ModelAndView("siteview");
			mav.addObject("websiteName", webInfo.getWebsiteName());
			mav.addObject("hits", webInfo.getHits());
			return mav;
		}
		
		return null;	
	}
}
