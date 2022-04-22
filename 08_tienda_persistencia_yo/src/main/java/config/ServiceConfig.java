package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Inyectamos el archivo de propiedades
@PropertySource(value="classpath:/config/application.properties")
@Configuration //Especifica esta clase como clase de configuracion
@ComponentScan(basePackages = { "service" }) // escanea todas las clases que se encuentren con la anotacion service para instanciarlas
@EnableTransactionManagement //Habilita la transaccionalidad mediante anotaciones									
public class ServiceConfig {

	//Se inyectan los valores de las propiedades del archivo properties.
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String password;
	// Esto hace que cuando se este iniciando Spring
	// detecte que esto es una clase de confguracion
	// LLama a todos los metodos con el bean
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(password);
		return data;
	}

	@Bean
	public JdbcTemplate template(DataSource data) {
		return new JdbcTemplate(data);
	}
	
	// adaptador de Hibernate
		@Bean
		public HibernateJpaVendorAdapter adapter() {
			HibernateJpaVendorAdapter adp = new HibernateJpaVendorAdapter();
			adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
			return adp;
		}

		// factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
		@Bean
		public LocalContainerEntityManagerFactoryBean factory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
			LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
			factory.setPersistenceUnitName("tiendaPU");
			factory.setDataSource(dataSource);
			factory.setPackagesToScan("model");
			factory.setJpaVendorAdapter(adapter);
			return factory;
		}

		// gestor de transacción
		@Bean
		public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
			JpaTransactionManager manager = new JpaTransactionManager();
			manager.setEntityManagerFactory(factory.getObject());
			return manager;
		}

}
