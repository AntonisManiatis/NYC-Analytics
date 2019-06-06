package gr.nyc.analytics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gr.nyc.analytics.entity.Account;
import gr.nyc.analytics.entity.WebsiteInfo;
import gr.nyc.analytics.model.Registration;
import gr.nyc.analytics.repository.AccountRepository;
import gr.nyc.analytics.repository.WebsiteRepository;

/**
 * 
 * @author AnthonyManiatis
 */
@Controller
@RequestMapping("/register")
public class RegistrationController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	private final AccountRepository accountRepo;
	private final WebsiteRepository websiteRepo;
	
	public RegistrationController(AccountRepository accountRepo,
			WebsiteRepository websiteRepo)
	{
		this.accountRepo = accountRepo;
		this.websiteRepo = websiteRepo;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView register(Registration registration)
	{
		Account account = new Account(registration.getAccountName());
		Example<Account> example = Example.of(account);
		if (accountRepo.exists(example))
		{
			LOGGER.debug("Account with name {} already exists!", registration.getAccountName());
			// TODO: How can i add an error message, like there's already one with this name registered?
			return new ModelAndView("redirect:/register.html");
		}
		else
		{
			accountRepo.save(account);
		}
		
		
		// TODO: Check for unique urls and names
		// Create a unique UUID for this site
		// and persist to the database
		WebsiteInfo storedInfo = websiteRepo.saveAndFlush(
				new WebsiteInfo(registration.getAccountName(), registration.getWebsiteName(),
						registration.getWebsiteUrl()));
		
		LOGGER.debug("Added new registration with trackingId {}", storedInfo.getTrackingId());
		// After registration, we give the user the script with the tracking ID generated
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("trackingId", storedInfo.getTrackingId().toString());
		return mav;
	}
}
