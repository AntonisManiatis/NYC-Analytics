package gr.nyc.analytics.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Long accountId;
	
	@Column(nullable = false)
	private String websiteName;
	
	@Column(nullable = false)
	private String websiteURL;
	
    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false)
    private Account account;
	
    @OneToMany(mappedBy = "websiteInfo")
    private List<HitStatistics> hits;
	
	public WebsiteInfo()
	{
		// TODO Auto-generated constructor stub
	}
	
	public WebsiteInfo(Long accountId, String websiteName, String websiteURL)
	{
		this.accountId = accountId;
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

	public Long getAccountId()
	{
		return accountId;
	}
	
	public void setAccountName(Long accountId)
	{
		this.accountId = accountId;
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

	public List<HitStatistics> getHits()
	{
		return hits;
	}
}
