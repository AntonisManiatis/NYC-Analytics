package gr.nyc.analytics.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "website_info")
public class WebsiteInfo
{
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@Column(updatable = false, nullable = false)
	private UUID trackingId;
	
	@Column(nullable = false)
	private String accountName;
	
	@Column(nullable = false)
	private String websiteName;
	
	@Column(nullable = false)
	private String websiteURL;
	
	// TODO: OneToMany HitStatistics
	
	public WebsiteInfo()
	{
		// TODO Auto-generated constructor stub
	}
	
	public WebsiteInfo(String accountName, String websiteName, String websiteURL)
	{
		this.accountName = accountName;
		this.websiteName = websiteName;
		this.websiteURL = websiteURL;
	}
	 
	public UUID getTrackingId()
	{
		return trackingId;
	}

	public void setTrackingId(UUID trackingId)
	{
		this.trackingId = trackingId;
	}

	public String getAccountName()
	{
		return accountName;
	}
	
	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}
	
	public String getWebsiteName()
	{
		return websiteName;
	}
	
	public void setWebsiteName(String websiteName)
	{
		this.websiteName = websiteName;
	}
	
	public String getWebsiteURL()
	{
		return websiteURL;
	}
	
	public void setWebsiteURL(String websiteURL)
	{
		this.websiteURL = websiteURL;
	}
}
