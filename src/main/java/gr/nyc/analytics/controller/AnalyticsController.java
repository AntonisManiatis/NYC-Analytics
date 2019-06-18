package gr.nyc.analytics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gr.nyc.analytics.entity.Account;
import gr.nyc.analytics.entity.WebsiteInfo;
import gr.nyc.analytics.model.SiteInfo;
import gr.nyc.analytics.repository.AccountRepository;

@Controller("/account")
public class AnalyticsController
{
	private final AccountRepository accountRepository;

	@Autowired
	public AnalyticsController(AccountRepository accountRepository)
	{
		this.accountRepository = accountRepository;
	}
	
	@RequestMapping("/account/username")
	public ModelAndView retrieveWebsites(@RequestParam("accountName") String accountName)
	{
		Example<Account> example = Example.of(new Account(accountName));
		Optional<Account> optional = accountRepository.findOne(example);
		if (optional.isPresent())
		{
			List<SiteInfo> sites = new ArrayList<>();
			Account account = optional.get();
			for (WebsiteInfo info : account.websites())
			{
				sites.add(new SiteInfo(info.getWebsiteName(), info.getTrackingId()));
			}
			
			ModelAndView mav = new ModelAndView("account");
			mav.addObject("sitesSize", sites.size());
			mav.addObject("sites", sites);
			return mav;
		}
		else
		{
			// TODO: Shouldn't return null, probably redirect to index with error.
			return null;
		}
	}
	
	@RequestMapping("/addsite")
	public void addSite(@RequestBody String d)
	{
		// TODO: Gather the typed data.
		// Save them to the database
	}
}
