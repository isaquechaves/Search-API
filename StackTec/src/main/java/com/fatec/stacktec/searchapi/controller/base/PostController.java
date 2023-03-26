package com.fatec.stacktec.searchapi.controller.base;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.stacktec.searchapi.dto.PostDto;
import com.fatec.stacktec.searchapi.holder.PostHolder;
import com.fatec.stacktec.searchapi.service.PostSearchService;
import com.fatec.stacktec.searchapi.util.MapperUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@Api(value = "Post", description = "post api", tags = {"Post"})
@RestController
@RequestMapping("/api/post")
public class PostController extends BaseSearchController{
	
	private final PostSearchService postService;
	
	private final MapperUtil mapperUtil;
	
	public PostController(PostSearchService postService, MapperUtil mapperUtil) {
		this.postService = postService;
		this.mapperUtil = mapperUtil;
	}
	
	@ApiOperation("Get Posts Pageable")
	@GetMapping(value = "/v1.0/pageable")
	public ResponseEntity<List<PostDto>> pageablePost(Pageable pageable) {
		List<PostHolder> results = postService.search(pageable);
		
		if(results != null && !results.isEmpty()) {
			List<PostDto> postDtoList = mapperUtil.mapPostDtosFromsHolder(results);
			return ResponseEntity.ok(postDtoList);
		}		
		return ResponseEntity.noContent().build();
	}
}
