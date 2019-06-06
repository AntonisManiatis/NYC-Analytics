package gr.nyc.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.nyc.analytics.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>
{

}
