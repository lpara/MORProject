package br.com.mor.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import br.com.mor.dominio.Aluguel;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Categoria;
import br.com.mor.dominio.Cidade;
import br.com.mor.dominio.Cliente;
import br.com.mor.dominio.Endereco;
import br.com.mor.dominio.Equipe;
import br.com.mor.dominio.Filme;
import br.com.mor.dominio.Idioma;
import br.com.mor.dominio.Inventario;
import br.com.mor.dominio.Loja;
import br.com.mor.dominio.Pagamento;
import br.com.mor.dominio.Pais;

public class SessionFactoryHolder {
	
	private static SessionFactory sessionFactory;
	
	static {
		inicializarSessionFactory();
	}

	public static void inicializarSessionFactory(){
		
		ServiceRegistry serviceRegistry = construirServiceRegistry();
		
		Metadata metadata = construirMetaData(serviceRegistry);
		
		sessionFactory = metadata.buildSessionFactory();
		 
	}

	/**
	 *  Para construir o {@link ServiceRegistry}, podemos utilizar:
	 *  
	 *  Para {@link BootstrapServiceRegistry} o builder {@link BootstrapServiceRegistryBuilder}.
	 *  
	 *  e para {@link StandardServiceRegistry} builder o {@link StandardServiceRegistryBuilder}
	 *  
	 * @return
	 */
	private static ServiceRegistry construirServiceRegistry(){
		 
		ServiceRegistry standarServiceRegistry = 
				new StandardServiceRegistryBuilder()
					.configure()
					.build();
		 
		return standarServiceRegistry;
	}
	
	private static Metadata construirMetaData(ServiceRegistry sr){
		MetadataSources metadataSources = new MetadataSources(sr);
		
		metadataSources.addAnnotatedClass( Aluguel.class )
			.addAnnotatedClass(Ator.class)
			.addAnnotatedClass(Categoria.class)
			.addAnnotatedClass(Cidade.class)
			.addAnnotatedClass(Cliente.class)
			.addAnnotatedClass(Endereco.class)
			.addAnnotatedClass(Equipe.class)
			.addAnnotatedClass(Filme.class)
			.addAnnotatedClass(Idioma.class)
			.addAnnotatedClass(Inventario.class)
			.addAnnotatedClass(Loja.class)
			.addAnnotatedClass(Pagamento.class)
			.addAnnotatedClass(Pais.class);
		
		// define outras configura��es 
		MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
		
		Metadata metadata = metadataBuilder.build();
		
		return metadata;
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutdown(){
		sessionFactory.close();
	}
}

