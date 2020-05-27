package com.bookstore.repository.elastic;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Post;

/**
 * This is the repository for elastic search
 * 
 * @author StutiRastogi
 *
 */
@Repository
public interface PostRepository extends ElasticsearchRepository<Post, Integer> {

	/**
	 * Use multimatch to match against title and body of the Posts
	 * 
	 * @param query title to search 
	 * @return list of posts that matches the given title
	 */
	@Query("{\"multi_match\" : {\"query\":\"?0\", \"fields\": [ \"title\", \"body\" ] }}")
	public List<Post> findPostsBySearchQuery(String query);

}
