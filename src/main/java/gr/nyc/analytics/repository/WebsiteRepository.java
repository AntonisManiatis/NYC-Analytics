package gr.nyc.analytics.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.nyc.analytics.entity.WebsiteInfo;

public interface WebsiteRepository extends JpaRepository<WebsiteInfo, UUID>
{

}
