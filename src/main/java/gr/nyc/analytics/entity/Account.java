package gr.nyc.analytics.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "account")
	private List<WebsiteInfo> websites;
	
	public Account()
	{
		// Default constructor for Hibernate
	}

	public Long getAccountId()
	{
		return accountId;
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
	
	public List<WebsiteInfo> websites()
	{
		return websites;
	}
}
