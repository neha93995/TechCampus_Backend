//package techcampus.example.techcampus.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfiguration  {
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailsService();
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider()
//	{
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		
//		return authProvider;
//	}
//	
//	 @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeHttpRequests((authz) -> authz
//	                .anyRequest().authenticated()
//	            )
//	            .httpBasic(withDefaults());
//	        return http.build();
//	    }
//
//	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	 @Bean
//	    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
//	        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
//	            EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
//	        contextSourceFactoryBean.setPort(0);
//	        return contextSourceFactoryBean;
//	    }
//
//	    @Bean
//	    AuthenticationManager ldapAuthenticationManager(
//	            BaseLdapPathContextSource contextSource) {
//	        LdapBindAuthenticationManagerFactory factory = 
//	            new LdapBindAuthenticationManagerFactory(contextSource);
//	        factory.setUserDnPatterns("uid={0},ou=people");
//	        factory.setUserDetailsContextMapper(new PersonContextMapper());
//	        return factory.createAuthenticationManager();
//	    }
//	
//}
package teckcampusbackend.example.techcampusbackend.Security;


