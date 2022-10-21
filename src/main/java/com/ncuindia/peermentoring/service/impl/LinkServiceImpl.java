package com.ncuindia.peermentoring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.model.Link;
import com.ncuindia.peermentoring.repository.LinkRepository;
import com.ncuindia.peermentoring.service.LinkService;


@Service
public class LinkServiceImpl implements LinkService {
	private LinkRepository linkRepository;
	
	// Starting with Spring 4.3, if a class which is configured as a spring bean, has only one
	// constructor, the @autowired Annotation can be omitted and Spring use that contructor
	// and inject all neccessary dependecies.
	public LinkServiceImpl(LinkRepository linkRepository) {
		super();
		this.linkRepository = linkRepository;
	}
	@Override
	public Link saveLink(Link link) {
		// TODO Auto-generated method stub
		return linkRepository.save(link);
	}
	@Override
	public List<Link> getAllLinks() {
		// TODO Auto-generated method stub
		return linkRepository.findAll();
	}

}
