package com.bookstore;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.bookstore.model.Post;
import com.bookstore.repository.elastic.PostRepository;

@SpringBootApplication
@EnableJpaRepositories("com.bookstore.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.bookstore.repository.elastic")
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	/**
	 * This method hits the api "https://jsonplaceholder.typicode.com/posts" and
	 * parses the json response It then saves the data into the elasticsearch db
	 */
	@Bean
	public CommandLineRunner setup(PostRepository postRepository) {
		return (args) -> {
			RestTemplate externalAPI = new RestTemplate();
			Post[] posts = externalAPI.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
			postRepository.saveAll(Arrays.asList(posts));
		};
	}

}
