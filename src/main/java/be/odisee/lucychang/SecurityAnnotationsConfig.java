package be.odisee.lucychang;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true,proxyTargetClass=true)
public class SecurityAnnotationsConfig extends GlobalMethodSecurityConfiguration{
	
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery("select emailadres, paswoord, true as enabled from personen where emailadres=?")
			.authoritiesByUsernameQuery("select personen.emailadres, rollen.type as authority from personen,rollen"+
											" where personen.id=rollen.persoon_id and emailadres=?");
	}
}
