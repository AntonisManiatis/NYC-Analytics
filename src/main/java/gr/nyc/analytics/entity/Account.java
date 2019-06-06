package gr.nyc.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * For every registration made an account is created. Under one account you can register many
 * websites.
 * @author AnthonyManiatis
 */
@Entity
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long accountId;
	
	@Column(nullable = false)
	private String accountName;
	
	// TODO: OneToMany WebsiteInfo
	
	public Account()
	{
		// Default constructor for Hibernate
	}
	
	public Account(String accountName)
	{
		this.accountName = accountName;
	}

	public String getName()
	{
		return accountName;
	}

	public void setName(String accountName)
	{
		this.accountName = accountName;
	}
}
