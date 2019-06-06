package gr.nyc.analytics.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.nyc.analytics.entity.Account;
import gr.nyc.analytics.repository.AccountRepository;
import gr.nyc.analytics.repository.WebsiteRepository;

@RestController("/api")
public class AnalyticsController
{
	private final AccountRepository accountRepository;
	private final WebsiteRepository websiteRepository;
	
	@Autowired
	public AnalyticsController(AccountRepository accountRepository,
			WebsiteRepository websiteRepository)
	{
		this.accountRepository = accountRepository;
		this.websiteRepository = websiteRepository;
	}
	
	@RequestMapping("/search")
	public void retrieveWebsites(@RequestParam(value="name") String accountName)
	{
		Example<Account> example = Example.of(new Account(accountName));
		Optional<Account> account = accountRepository.findOne(example);
		if (account.isPresent())
		{
			
		}
		else
		{
			
		}
	}
	
	@RequestMapping("/addsite")
	public void addSite(@RequestBody String d)
	{
		// TODO: Gather the typed data.
		// Save them to the database
	}
}
