package com.fatec.stacktec.searchapi.controller.base;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.TypeMap;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.stacktec.searchapi.dto.PostDto;
import com.fatec.stacktec.searchapi.dto.PostShortDto;
import com.fatec.stacktec.searchapi.helper.SearchResult;
import com.fatec.stacktec.searchapi.holder.PostHolder;
import com.fatec.stacktec.searchapi.service.PostSearchService;
import com.fatec.stacktec.searchapi.util.MapperUtil;
import com.fatec.stacktec.searchapi.util.PageResults;

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
	
	private TypeMap<PostHolder, PostShortDto> postShortDtoTypeMap;
	
	public PostController(PostSearchService postService, MapperUtil mapperUtil) {
		this.postService = postService;
		this.mapperUtil = mapperUtil;
	}
	
	@PostConstruct
	private void createMappers() {
		this.postShortDtoTypeMap = modelMapper
				.createTypeMap(PostHolder.class, PostShortDto.class);
	}
	
	@ApiOperation("Get Posts Pageable")
	@GetMapping(value = "/v1.0/pageable")
	public ResponseEntity<PageResults> pageablePost(@RequestParam(value = "page") Integer page,
													@RequestParam(value = "size") Integer size) {
		
		SearchResult searchResult = postService.search(page, size);
		
		if(searchResult.getNumResults() > 0) {
			PageResults pageResults = new PageResults();
			pageResults.setNumResults(searchResult.getNumResults());
			
			if((searchResult.getNumResults() % size) == 0) {
				pageResults.setTotalPages(Math.floorDiv((int) searchResult.getNumResults(), size));
			}else {
				Integer totalPages = (Math.floorDiv((int) searchResult.getNumResults(), size)) + 1;
				pageResults.setTotalPages(totalPages);
			}
			
			List<PostHolder> postHolders = searchResult.getResults();
			
			List<PostShortDto> postShorts = postHolders.stream().map(postHolder -> {
				PostShortDto postShortDto = postShortDtoTypeMap.map(postHolder);
				return postShortDto;
			}).collect(Collectors.toList());
			
			pageResults.setResults(postShorts);
			return ResponseEntity.ok(pageResults);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Get Post by Id")
	@GetMapping(value = "/v1.0/{id}")
	public ResponseEntity<PostDto> getById(@PathVariable Long id) {
		Optional<PostHolder> postOptional = postService.findById(id);
		
		if(postOptional.isPresent()) {
			PostHolder postHolder = postOptional.get();
			return ResponseEntity.ok(modelMapper.map(postHolder, PostDto.class));
		}
		
		return ResponseEntity.noContent().build();
	}
}
