package gr.nyc.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.nyc.analytics.entity.HitStatistics;

@Repository
public interface StatisticsRepository extends JpaRepository<HitStatistics, Long>
{

}
